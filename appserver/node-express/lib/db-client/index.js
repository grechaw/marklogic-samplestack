var options = sharedRequire('js/options');

var mlclient = require('marklogic');
var boundClients = {};

var execAsTransaction = function (ex) {
  var self = this;
  var txid;

  return this.transactions.open().result()
  .then(function (resp) {
    txid = resp.txid;
    return ex(txid);
  })
  .then(function (result) {
    return self.transactions.commit(txid).result()
    .then(function () {
      return result;
    });
  })
  .catch(function (err) {
    return self.transactions.rollback(txid).result()
    .thenThrow(err);
  });
};

var getClient = function (user, password) {
  return mlclient.createDatabaseClient(_.merge(
    options.middleTier.db.clientConnection,
    {
      user: user,
      password: password
    }
  ));
};

var getBoundClient = function (user, password) {
  if (!boundClients[user]) {
    var connection = getClient(user, password);
    // TODO: this used to work -- determine best way to catch
    // errors in-app and keep logging from being spit out of dbclient
    // connections[role].setLogger({ console: false });

    var boundClient = {};

    var modules = {
      qnaDoc: require('./qnaDoc'),
      contributor: require('./contributor'),
      tags: require('./tags'),
      search: require('./search')
    };

    // have the individual modules handle binding themselves to the connection
    // by calling their exported function
    _.each(modules, function (mod, key) {
      boundClient[key] = mod(connection);
    });
    boundClient.transactions = connection.transactions;
    boundClient.execAsTransaction = execAsTransaction.bind(connection);
    boundClients[user] = boundClient;
  }
  return boundClients[user];
};


module.exports = {
  getBoundClient: getBoundClient,
  getGenericClient: getClient,
  execAsTransaction: execAsTransaction
};

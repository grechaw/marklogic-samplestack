/*
 * Copyright 2012-2015 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marklogic.samplestack.unit.domain;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marklogic.samplestack.dbclient.CustomObjectMapper;
import com.marklogic.samplestack.dbclient.DateFacetBuilder;
import com.marklogic.samplestack.testing.UnitTests;

@Category(UnitTests.class)
public class DateFacetBuilderTest {

	private static Logger logger = Logger.getLogger(DateFacetBuilderTest.class);
	
	@Test
	@Ignore
	/**
	 * Not in use for Samplestack 1.0.0
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	public void testDayBuilder() throws JsonProcessingException, JSONException {
		ObjectMapper mapper = new CustomObjectMapper();
		DateTime minDate = new DateTime(2013, 1, 31, 0, 0, DateTimeZone.forID("US/Pacific"));
		DateTime maxDate = minDate.plusDays(30);

		String actual = mapper.writeValueAsString(DateFacetBuilder.dateFacet(
				minDate, maxDate));

		String expected =
			"{\"constraint\":{\"range\":{\"type\":\"xs:dateTime\",\"facet\":true,\"json-property\":\"lastActivityDate\",\"facet-option\":\"empties\",\"bucket\":[{\"ge\":\"2013-01-31T00:00:00.000-08:00\",\"lt\":\"2013-02-01T00:00:00.000-08:00\",\"name\":\"2013-01-31T00:00:00.000-08:00\",\"label\":\"2013-01-31T00:00:00.000-08:00\"},{\"ge\":\"2013-02-01T00:00:00.000-08:00\",\"lt\":\"2013-02-02T00:00:00.000-08:00\",\"name\":\"2013-02-01T00:00:00.000-08:00\",\"label\":\"2013-02-01T00:00:00.000-08:00\"},{\"ge\":\"2013-02-02T00:00:00.000-08:00\",\"lt\":\"2013-02-03T00:00:00.000-08:00\",\"name\":\"2013-02-02T00:00:00.000-08:00\",\"label\":\"2013-02-02T00:00:00.000-08:00\"},{\"ge\":\"2013-02-03T00:00:00.000-08:00\",\"lt\":\"2013-02-04T00:00:00.000-08:00\",\"name\":\"2013-02-03T00:00:00.000-08:00\",\"label\":\"2013-02-03T00:00:00.000-08:00\"},{\"ge\":\"2013-02-04T00:00:00.000-08:00\",\"lt\":\"2013-02-05T00:00:00.000-08:00\",\"name\":\"2013-02-04T00:00:00.000-08:00\",\"label\":\"2013-02-04T00:00:00.000-08:00\"},{\"ge\":\"2013-02-05T00:00:00.000-08:00\",\"lt\":\"2013-02-06T00:00:00.000-08:00\",\"name\":\"2013-02-05T00:00:00.000-08:00\",\"label\":\"2013-02-05T00:00:00.000-08:00\"},{\"ge\":\"2013-02-06T00:00:00.000-08:00\",\"lt\":\"2013-02-07T00:00:00.000-08:00\",\"name\":\"2013-02-06T00:00:00.000-08:00\",\"label\":\"2013-02-06T00:00:00.000-08:00\"},{\"ge\":\"2013-02-07T00:00:00.000-08:00\",\"lt\":\"2013-02-08T00:00:00.000-08:00\",\"name\":\"2013-02-07T00:00:00.000-08:00\",\"label\":\"2013-02-07T00:00:00.000-08:00\"},{\"ge\":\"2013-02-08T00:00:00.000-08:00\",\"lt\":\"2013-02-09T00:00:00.000-08:00\",\"name\":\"2013-02-08T00:00:00.000-08:00\",\"label\":\"2013-02-08T00:00:00.000-08:00\"},{\"ge\":\"2013-02-09T00:00:00.000-08:00\",\"lt\":\"2013-02-10T00:00:00.000-08:00\",\"name\":\"2013-02-09T00:00:00.000-08:00\",\"label\":\"2013-02-09T00:00:00.000-08:00\"},{\"ge\":\"2013-02-10T00:00:00.000-08:00\",\"lt\":\"2013-02-11T00:00:00.000-08:00\",\"name\":\"2013-02-10T00:00:00.000-08:00\",\"label\":\"2013-02-10T00:00:00.000-08:00\"},{\"ge\":\"2013-02-11T00:00:00.000-08:00\",\"lt\":\"2013-02-12T00:00:00.000-08:00\",\"name\":\"2013-02-11T00:00:00.000-08:00\",\"label\":\"2013-02-11T00:00:00.000-08:00\"},{\"ge\":\"2013-02-12T00:00:00.000-08:00\",\"lt\":\"2013-02-13T00:00:00.000-08:00\",\"name\":\"2013-02-12T00:00:00.000-08:00\",\"label\":\"2013-02-12T00:00:00.000-08:00\"},{\"ge\":\"2013-02-13T00:00:00.000-08:00\",\"lt\":\"2013-02-14T00:00:00.000-08:00\",\"name\":\"2013-02-13T00:00:00.000-08:00\",\"label\":\"2013-02-13T00:00:00.000-08:00\"},{\"ge\":\"2013-02-14T00:00:00.000-08:00\",\"lt\":\"2013-02-15T00:00:00.000-08:00\",\"name\":\"2013-02-14T00:00:00.000-08:00\",\"label\":\"2013-02-14T00:00:00.000-08:00\"},{\"ge\":\"2013-02-15T00:00:00.000-08:00\",\"lt\":\"2013-02-16T00:00:00.000-08:00\",\"name\":\"2013-02-15T00:00:00.000-08:00\",\"label\":\"2013-02-15T00:00:00.000-08:00\"},{\"ge\":\"2013-02-16T00:00:00.000-08:00\",\"lt\":\"2013-02-17T00:00:00.000-08:00\",\"name\":\"2013-02-16T00:00:00.000-08:00\",\"label\":\"2013-02-16T00:00:00.000-08:00\"},{\"ge\":\"2013-02-17T00:00:00.000-08:00\",\"lt\":\"2013-02-18T00:00:00.000-08:00\",\"name\":\"2013-02-17T00:00:00.000-08:00\",\"label\":\"2013-02-17T00:00:00.000-08:00\"},{\"ge\":\"2013-02-18T00:00:00.000-08:00\",\"lt\":\"2013-02-19T00:00:00.000-08:00\",\"name\":\"2013-02-18T00:00:00.000-08:00\",\"label\":\"2013-02-18T00:00:00.000-08:00\"},{\"ge\":\"2013-02-19T00:00:00.000-08:00\",\"lt\":\"2013-02-20T00:00:00.000-08:00\",\"name\":\"2013-02-19T00:00:00.000-08:00\",\"label\":\"2013-02-19T00:00:00.000-08:00\"},{\"ge\":\"2013-02-20T00:00:00.000-08:00\",\"lt\":\"2013-02-21T00:00:00.000-08:00\",\"name\":\"2013-02-20T00:00:00.000-08:00\",\"label\":\"2013-02-20T00:00:00.000-08:00\"},{\"ge\":\"2013-02-21T00:00:00.000-08:00\",\"lt\":\"2013-02-22T00:00:00.000-08:00\",\"name\":\"2013-02-21T00:00:00.000-08:00\",\"label\":\"2013-02-21T00:00:00.000-08:00\"},{\"ge\":\"2013-02-22T00:00:00.000-08:00\",\"lt\":\"2013-02-23T00:00:00.000-08:00\",\"name\":\"2013-02-22T00:00:00.000-08:00\",\"label\":\"2013-02-22T00:00:00.000-08:00\"},{\"ge\":\"2013-02-23T00:00:00.000-08:00\",\"lt\":\"2013-02-24T00:00:00.000-08:00\",\"name\":\"2013-02-23T00:00:00.000-08:00\",\"label\":\"2013-02-23T00:00:00.000-08:00\"},{\"ge\":\"2013-02-24T00:00:00.000-08:00\",\"lt\":\"2013-02-25T00:00:00.000-08:00\",\"name\":\"2013-02-24T00:00:00.000-08:00\",\"label\":\"2013-02-24T00:00:00.000-08:00\"},{\"ge\":\"2013-02-25T00:00:00.000-08:00\",\"lt\":\"2013-02-26T00:00:00.000-08:00\",\"name\":\"2013-02-25T00:00:00.000-08:00\",\"label\":\"2013-02-25T00:00:00.000-08:00\"},{\"ge\":\"2013-02-26T00:00:00.000-08:00\",\"lt\":\"2013-02-27T00:00:00.000-08:00\",\"name\":\"2013-02-26T00:00:00.000-08:00\",\"label\":\"2013-02-26T00:00:00.000-08:00\"},{\"ge\":\"2013-02-27T00:00:00.000-08:00\",\"lt\":\"2013-02-28T00:00:00.000-08:00\",\"name\":\"2013-02-27T00:00:00.000-08:00\",\"label\":\"2013-02-27T00:00:00.000-08:00\"},{\"ge\":\"2013-02-28T00:00:00.000-08:00\",\"lt\":\"2013-03-01T00:00:00.000-08:00\",\"name\":\"2013-02-28T00:00:00.000-08:00\",\"label\":\"2013-02-28T00:00:00.000-08:00\"},{\"ge\":\"2013-03-01T00:00:00.000-08:00\",\"lt\":\"2013-03-02T00:00:00.000-08:00\",\"name\":\"2013-03-01T00:00:00.000-08:00\",\"label\":\"2013-03-01T00:00:00.000-08:00\"}]},\"name\":\"date\"},period:\"DAY\"}";
		JSONAssert.assertEquals(actual, expected, false);
	}

	@Test
	@Ignore
	/**
	 * Not in use for Samplestack 1.0.0
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	public void testWeekBuilder() throws JsonProcessingException, JSONException {
		ObjectMapper mapper = new CustomObjectMapper();
		DateTime minDate = new DateTime(2013, 1, 31, 0, 0, DateTimeZone.forID("US/Pacific"));
		DateTime maxDate = minDate.plusDays(120);

		String actual = mapper.writeValueAsString(DateFacetBuilder.dateFacet(
				minDate, maxDate));
		logger.debug(actual);
		String expected = "{\"constraint\":{\"range\":{\"type\":\"xs:dateTime\",\"facet\":true,\"json-property\":\"lastActivityDate\",\"facet-option\":\"empties\",\"bucket\":[{\"ge\":\"2013-01-27T00:00:00.000-08:00\",\"lt\":\"2013-02-03T00:00:00.000-08:00\",\"name\":\"2013-01-27T00:00:00.000-08:00\",\"label\":\"2013-01-27T00:00:00.000-08:00\"},{\"ge\":\"2013-02-03T00:00:00.000-08:00\",\"lt\":\"2013-02-10T00:00:00.000-08:00\",\"name\":\"2013-02-03T00:00:00.000-08:00\",\"label\":\"2013-02-03T00:00:00.000-08:00\"},{\"ge\":\"2013-02-10T00:00:00.000-08:00\",\"lt\":\"2013-02-17T00:00:00.000-08:00\",\"name\":\"2013-02-10T00:00:00.000-08:00\",\"label\":\"2013-02-10T00:00:00.000-08:00\"},{\"ge\":\"2013-02-17T00:00:00.000-08:00\",\"lt\":\"2013-02-24T00:00:00.000-08:00\",\"name\":\"2013-02-17T00:00:00.000-08:00\",\"label\":\"2013-02-17T00:00:00.000-08:00\"},{\"ge\":\"2013-02-24T00:00:00.000-08:00\",\"lt\":\"2013-03-03T00:00:00.000-08:00\",\"name\":\"2013-02-24T00:00:00.000-08:00\",\"label\":\"2013-02-24T00:00:00.000-08:00\"},{\"ge\":\"2013-03-03T00:00:00.000-08:00\",\"lt\":\"2013-03-10T00:00:00.000-08:00\",\"name\":\"2013-03-03T00:00:00.000-08:00\",\"label\":\"2013-03-03T00:00:00.000-08:00\"},{\"ge\":\"2013-03-10T00:00:00.000-08:00\",\"lt\":\"2013-03-17T00:00:00.000-07:00\",\"name\":\"2013-03-10T00:00:00.000-08:00\",\"label\":\"2013-03-10T00:00:00.000-08:00\"},{\"ge\":\"2013-03-17T00:00:00.000-07:00\",\"lt\":\"2013-03-24T00:00:00.000-07:00\",\"name\":\"2013-03-17T00:00:00.000-07:00\",\"label\":\"2013-03-17T00:00:00.000-07:00\"},{\"ge\":\"2013-03-24T00:00:00.000-07:00\",\"lt\":\"2013-03-31T00:00:00.000-07:00\",\"name\":\"2013-03-24T00:00:00.000-07:00\",\"label\":\"2013-03-24T00:00:00.000-07:00\"},{\"ge\":\"2013-03-31T00:00:00.000-07:00\",\"lt\":\"2013-04-07T00:00:00.000-07:00\",\"name\":\"2013-03-31T00:00:00.000-07:00\",\"label\":\"2013-03-31T00:00:00.000-07:00\"},{\"ge\":\"2013-04-07T00:00:00.000-07:00\",\"lt\":\"2013-04-14T00:00:00.000-07:00\",\"name\":\"2013-04-07T00:00:00.000-07:00\",\"label\":\"2013-04-07T00:00:00.000-07:00\"},{\"ge\":\"2013-04-14T00:00:00.000-07:00\",\"lt\":\"2013-04-21T00:00:00.000-07:00\",\"name\":\"2013-04-14T00:00:00.000-07:00\",\"label\":\"2013-04-14T00:00:00.000-07:00\"},{\"ge\":\"2013-04-21T00:00:00.000-07:00\",\"lt\":\"2013-04-28T00:00:00.000-07:00\",\"name\":\"2013-04-21T00:00:00.000-07:00\",\"label\":\"2013-04-21T00:00:00.000-07:00\"},{\"ge\":\"2013-04-28T00:00:00.000-07:00\",\"lt\":\"2013-05-05T00:00:00.000-07:00\",\"name\":\"2013-04-28T00:00:00.000-07:00\",\"label\":\"2013-04-28T00:00:00.000-07:00\"},{\"ge\":\"2013-05-05T00:00:00.000-07:00\",\"lt\":\"2013-05-12T00:00:00.000-07:00\",\"name\":\"2013-05-05T00:00:00.000-07:00\",\"label\":\"2013-05-05T00:00:00.000-07:00\"},{\"ge\":\"2013-05-12T00:00:00.000-07:00\",\"lt\":\"2013-05-19T00:00:00.000-07:00\",\"name\":\"2013-05-12T00:00:00.000-07:00\",\"label\":\"2013-05-12T00:00:00.000-07:00\"},{\"ge\":\"2013-05-19T00:00:00.000-07:00\",\"lt\":\"2013-05-26T00:00:00.000-07:00\",\"name\":\"2013-05-19T00:00:00.000-07:00\",\"label\":\"2013-05-19T00:00:00.000-07:00\"},{\"ge\":\"2013-05-26T00:00:00.000-07:00\",\"lt\":\"2013-06-02T00:00:00.000-07:00\",\"name\":\"2013-05-26T00:00:00.000-07:00\",\"label\":\"2013-05-26T00:00:00.000-07:00\"}]},\"name\":\"date\"},period:\"WEEK\"}";
		JSONAssert.assertEquals(actual, expected, false);
	}

	@Test
	public void testMonthBuilder() throws JsonProcessingException,
			JSONException {
		ObjectMapper mapper = new CustomObjectMapper();
		DateTime minDate = new DateTime(2013, 1, 31, 0, 0, DateTimeZone.forID("US/Pacific"));
		DateTime maxDate = minDate.plusMonths(40);

		String actual = mapper.writeValueAsString(DateFacetBuilder.dateFacet(
				minDate, maxDate));

		String expected = "{\"constraint\":{\"range\":{\"type\":\"xs:dateTime\",\"facet\":true,\"json-property\":\"lastActivityDate\",\"facet-option\":\"empties\",\"bucket\":[{\"ge\":\"2013-01-01T00:00:00.000-08:00\",\"lt\":\"2013-02-01T00:00:00.000-08:00\",\"name\":\"2013-01-01T00:00:00.000-08:00\",\"label\":\"2013-01-01T00:00:00.000-08:00\"},{\"ge\":\"2013-02-01T00:00:00.000-08:00\",\"lt\":\"2013-03-01T00:00:00.000-08:00\",\"name\":\"2013-02-01T00:00:00.000-08:00\",\"label\":\"2013-02-01T00:00:00.000-08:00\"},{\"ge\":\"2013-03-01T00:00:00.000-08:00\",\"lt\":\"2013-04-01T00:00:00.000-07:00\",\"name\":\"2013-03-01T00:00:00.000-08:00\",\"label\":\"2013-03-01T00:00:00.000-08:00\"},{\"ge\":\"2013-04-01T00:00:00.000-07:00\",\"lt\":\"2013-05-01T00:00:00.000-07:00\",\"name\":\"2013-04-01T00:00:00.000-07:00\",\"label\":\"2013-04-01T00:00:00.000-07:00\"},{\"ge\":\"2013-05-01T00:00:00.000-07:00\",\"lt\":\"2013-06-01T00:00:00.000-07:00\",\"name\":\"2013-05-01T00:00:00.000-07:00\",\"label\":\"2013-05-01T00:00:00.000-07:00\"},{\"ge\":\"2013-06-01T00:00:00.000-07:00\",\"lt\":\"2013-07-01T00:00:00.000-07:00\",\"name\":\"2013-06-01T00:00:00.000-07:00\",\"label\":\"2013-06-01T00:00:00.000-07:00\"},{\"ge\":\"2013-07-01T00:00:00.000-07:00\",\"lt\":\"2013-08-01T00:00:00.000-07:00\",\"name\":\"2013-07-01T00:00:00.000-07:00\",\"label\":\"2013-07-01T00:00:00.000-07:00\"},{\"ge\":\"2013-08-01T00:00:00.000-07:00\",\"lt\":\"2013-09-01T00:00:00.000-07:00\",\"name\":\"2013-08-01T00:00:00.000-07:00\",\"label\":\"2013-08-01T00:00:00.000-07:00\"},{\"ge\":\"2013-09-01T00:00:00.000-07:00\",\"lt\":\"2013-10-01T00:00:00.000-07:00\",\"name\":\"2013-09-01T00:00:00.000-07:00\",\"label\":\"2013-09-01T00:00:00.000-07:00\"},{\"ge\":\"2013-10-01T00:00:00.000-07:00\",\"lt\":\"2013-11-01T00:00:00.000-07:00\",\"name\":\"2013-10-01T00:00:00.000-07:00\",\"label\":\"2013-10-01T00:00:00.000-07:00\"},{\"ge\":\"2013-11-01T00:00:00.000-07:00\",\"lt\":\"2013-12-01T00:00:00.000-08:00\",\"name\":\"2013-11-01T00:00:00.000-07:00\",\"label\":\"2013-11-01T00:00:00.000-07:00\"},{\"ge\":\"2013-12-01T00:00:00.000-08:00\",\"lt\":\"2014-01-01T00:00:00.000-08:00\",\"name\":\"2013-12-01T00:00:00.000-08:00\",\"label\":\"2013-12-01T00:00:00.000-08:00\"},{\"ge\":\"2014-01-01T00:00:00.000-08:00\",\"lt\":\"2014-02-01T00:00:00.000-08:00\",\"name\":\"2014-01-01T00:00:00.000-08:00\",\"label\":\"2014-01-01T00:00:00.000-08:00\"},{\"ge\":\"2014-02-01T00:00:00.000-08:00\",\"lt\":\"2014-03-01T00:00:00.000-08:00\",\"name\":\"2014-02-01T00:00:00.000-08:00\",\"label\":\"2014-02-01T00:00:00.000-08:00\"},{\"ge\":\"2014-03-01T00:00:00.000-08:00\",\"lt\":\"2014-04-01T00:00:00.000-07:00\",\"name\":\"2014-03-01T00:00:00.000-08:00\",\"label\":\"2014-03-01T00:00:00.000-08:00\"},{\"ge\":\"2014-04-01T00:00:00.000-07:00\",\"lt\":\"2014-05-01T00:00:00.000-07:00\",\"name\":\"2014-04-01T00:00:00.000-07:00\",\"label\":\"2014-04-01T00:00:00.000-07:00\"},{\"ge\":\"2014-05-01T00:00:00.000-07:00\",\"lt\":\"2014-06-01T00:00:00.000-07:00\",\"name\":\"2014-05-01T00:00:00.000-07:00\",\"label\":\"2014-05-01T00:00:00.000-07:00\"},{\"ge\":\"2014-06-01T00:00:00.000-07:00\",\"lt\":\"2014-07-01T00:00:00.000-07:00\",\"name\":\"2014-06-01T00:00:00.000-07:00\",\"label\":\"2014-06-01T00:00:00.000-07:00\"},{\"ge\":\"2014-07-01T00:00:00.000-07:00\",\"lt\":\"2014-08-01T00:00:00.000-07:00\",\"name\":\"2014-07-01T00:00:00.000-07:00\",\"label\":\"2014-07-01T00:00:00.000-07:00\"},{\"ge\":\"2014-08-01T00:00:00.000-07:00\",\"lt\":\"2014-09-01T00:00:00.000-07:00\",\"name\":\"2014-08-01T00:00:00.000-07:00\",\"label\":\"2014-08-01T00:00:00.000-07:00\"},{\"ge\":\"2014-09-01T00:00:00.000-07:00\",\"lt\":\"2014-10-01T00:00:00.000-07:00\",\"name\":\"2014-09-01T00:00:00.000-07:00\",\"label\":\"2014-09-01T00:00:00.000-07:00\"},{\"ge\":\"2014-10-01T00:00:00.000-07:00\",\"lt\":\"2014-11-01T00:00:00.000-07:00\",\"name\":\"2014-10-01T00:00:00.000-07:00\",\"label\":\"2014-10-01T00:00:00.000-07:00\"},{\"ge\":\"2014-11-01T00:00:00.000-07:00\",\"lt\":\"2014-12-01T00:00:00.000-08:00\",\"name\":\"2014-11-01T00:00:00.000-07:00\",\"label\":\"2014-11-01T00:00:00.000-07:00\"},{\"ge\":\"2014-12-01T00:00:00.000-08:00\",\"lt\":\"2015-01-01T00:00:00.000-08:00\",\"name\":\"2014-12-01T00:00:00.000-08:00\",\"label\":\"2014-12-01T00:00:00.000-08:00\"},{\"ge\":\"2015-01-01T00:00:00.000-08:00\",\"lt\":\"2015-02-01T00:00:00.000-08:00\",\"name\":\"2015-01-01T00:00:00.000-08:00\",\"label\":\"2015-01-01T00:00:00.000-08:00\"},{\"ge\":\"2015-02-01T00:00:00.000-08:00\",\"lt\":\"2015-03-01T00:00:00.000-08:00\",\"name\":\"2015-02-01T00:00:00.000-08:00\",\"label\":\"2015-02-01T00:00:00.000-08:00\"},{\"ge\":\"2015-03-01T00:00:00.000-08:00\",\"lt\":\"2015-04-01T00:00:00.000-07:00\",\"name\":\"2015-03-01T00:00:00.000-08:00\",\"label\":\"2015-03-01T00:00:00.000-08:00\"},{\"ge\":\"2015-04-01T00:00:00.000-07:00\",\"lt\":\"2015-05-01T00:00:00.000-07:00\",\"name\":\"2015-04-01T00:00:00.000-07:00\",\"label\":\"2015-04-01T00:00:00.000-07:00\"},{\"ge\":\"2015-05-01T00:00:00.000-07:00\",\"lt\":\"2015-06-01T00:00:00.000-07:00\",\"name\":\"2015-05-01T00:00:00.000-07:00\",\"label\":\"2015-05-01T00:00:00.000-07:00\"},{\"ge\":\"2015-06-01T00:00:00.000-07:00\",\"lt\":\"2015-07-01T00:00:00.000-07:00\",\"name\":\"2015-06-01T00:00:00.000-07:00\",\"label\":\"2015-06-01T00:00:00.000-07:00\"},{\"ge\":\"2015-07-01T00:00:00.000-07:00\",\"lt\":\"2015-08-01T00:00:00.000-07:00\",\"name\":\"2015-07-01T00:00:00.000-07:00\",\"label\":\"2015-07-01T00:00:00.000-07:00\"},{\"ge\":\"2015-08-01T00:00:00.000-07:00\",\"lt\":\"2015-09-01T00:00:00.000-07:00\",\"name\":\"2015-08-01T00:00:00.000-07:00\",\"label\":\"2015-08-01T00:00:00.000-07:00\"},{\"ge\":\"2015-09-01T00:00:00.000-07:00\",\"lt\":\"2015-10-01T00:00:00.000-07:00\",\"name\":\"2015-09-01T00:00:00.000-07:00\",\"label\":\"2015-09-01T00:00:00.000-07:00\"},{\"ge\":\"2015-10-01T00:00:00.000-07:00\",\"lt\":\"2015-11-01T00:00:00.000-07:00\",\"name\":\"2015-10-01T00:00:00.000-07:00\",\"label\":\"2015-10-01T00:00:00.000-07:00\"},{\"ge\":\"2015-11-01T00:00:00.000-07:00\",\"lt\":\"2015-12-01T00:00:00.000-08:00\",\"name\":\"2015-11-01T00:00:00.000-07:00\",\"label\":\"2015-11-01T00:00:00.000-07:00\"},{\"ge\":\"2015-12-01T00:00:00.000-08:00\",\"lt\":\"2016-01-01T00:00:00.000-08:00\",\"name\":\"2015-12-01T00:00:00.000-08:00\",\"label\":\"2015-12-01T00:00:00.000-08:00\"},{\"ge\":\"2016-01-01T00:00:00.000-08:00\",\"lt\":\"2016-02-01T00:00:00.000-08:00\",\"name\":\"2016-01-01T00:00:00.000-08:00\",\"label\":\"2016-01-01T00:00:00.000-08:00\"},{\"ge\":\"2016-02-01T00:00:00.000-08:00\",\"lt\":\"2016-03-01T00:00:00.000-08:00\",\"name\":\"2016-02-01T00:00:00.000-08:00\",\"label\":\"2016-02-01T00:00:00.000-08:00\"},{\"ge\":\"2016-03-01T00:00:00.000-08:00\",\"lt\":\"2016-04-01T00:00:00.000-07:00\",\"name\":\"2016-03-01T00:00:00.000-08:00\",\"label\":\"2016-03-01T00:00:00.000-08:00\"},{\"ge\":\"2016-04-01T00:00:00.000-07:00\",\"lt\":\"2016-05-01T00:00:00.000-07:00\",\"name\":\"2016-04-01T00:00:00.000-07:00\",\"label\":\"2016-04-01T00:00:00.000-07:00\"},{\"ge\":\"2016-05-01T00:00:00.000-07:00\",\"lt\":\"2016-06-01T00:00:00.000-07:00\",\"name\":\"2016-05-01T00:00:00.000-07:00\",\"label\":\"2016-05-01T00:00:00.000-07:00\"}]},\"name\":\"date\"},\"period\":\"MONTH\"}";
		JSONAssert.assertEquals(actual, expected, false);
		
		//test another time zone
		minDate = new DateTime(2013, 1, 31, 0, 0, DateTimeZone.forID("Europe/Prague"));
		maxDate = minDate.plusMonths(40);
		
		actual = mapper.writeValueAsString(DateFacetBuilder.dateFacet(
				minDate, maxDate));

		logger.debug(actual);
		expected = "{\"constraint\":{\"range\":{\"type\":\"xs:dateTime\",\"facet\":true,\"json-property\":\"lastActivityDate\",\"facet-option\":\"empties\",\"bucket\":[{\"ge\":\"2013-01-01T00:00:00.000+01:00\",\"lt\":\"2013-02-01T00:00:00.000+01:00\",\"name\":\"2013-01-01T00:00:00.000+01:00\",\"label\":\"2013-01-01T00:00:00.000+01:00\"},{\"ge\":\"2013-02-01T00:00:00.000+01:00\",\"lt\":\"2013-03-01T00:00:00.000+01:00\",\"name\":\"2013-02-01T00:00:00.000+01:00\",\"label\":\"2013-02-01T00:00:00.000+01:00\"},{\"ge\":\"2013-03-01T00:00:00.000+01:00\",\"lt\":\"2013-04-01T00:00:00.000+02:00\",\"name\":\"2013-03-01T00:00:00.000+01:00\",\"label\":\"2013-03-01T00:00:00.000+01:00\"},{\"ge\":\"2013-04-01T00:00:00.000+02:00\",\"lt\":\"2013-05-01T00:00:00.000+02:00\",\"name\":\"2013-04-01T00:00:00.000+02:00\",\"label\":\"2013-04-01T00:00:00.000+02:00\"},{\"ge\":\"2013-05-01T00:00:00.000+02:00\",\"lt\":\"2013-06-01T00:00:00.000+02:00\",\"name\":\"2013-05-01T00:00:00.000+02:00\",\"label\":\"2013-05-01T00:00:00.000+02:00\"},{\"ge\":\"2013-06-01T00:00:00.000+02:00\",\"lt\":\"2013-07-01T00:00:00.000+02:00\",\"name\":\"2013-06-01T00:00:00.000+02:00\",\"label\":\"2013-06-01T00:00:00.000+02:00\"},{\"ge\":\"2013-07-01T00:00:00.000+02:00\",\"lt\":\"2013-08-01T00:00:00.000+02:00\",\"name\":\"2013-07-01T00:00:00.000+02:00\",\"label\":\"2013-07-01T00:00:00.000+02:00\"},{\"ge\":\"2013-08-01T00:00:00.000+02:00\",\"lt\":\"2013-09-01T00:00:00.000+02:00\",\"name\":\"2013-08-01T00:00:00.000+02:00\",\"label\":\"2013-08-01T00:00:00.000+02:00\"},{\"ge\":\"2013-09-01T00:00:00.000+02:00\",\"lt\":\"2013-10-01T00:00:00.000+02:00\",\"name\":\"2013-09-01T00:00:00.000+02:00\",\"label\":\"2013-09-01T00:00:00.000+02:00\"},{\"ge\":\"2013-10-01T00:00:00.000+02:00\",\"lt\":\"2013-11-01T00:00:00.000+01:00\",\"name\":\"2013-10-01T00:00:00.000+02:00\",\"label\":\"2013-10-01T00:00:00.000+02:00\"},{\"ge\":\"2013-11-01T00:00:00.000+01:00\",\"lt\":\"2013-12-01T00:00:00.000+01:00\",\"name\":\"2013-11-01T00:00:00.000+01:00\",\"label\":\"2013-11-01T00:00:00.000+01:00\"},{\"ge\":\"2013-12-01T00:00:00.000+01:00\",\"lt\":\"2014-01-01T00:00:00.000+01:00\",\"name\":\"2013-12-01T00:00:00.000+01:00\",\"label\":\"2013-12-01T00:00:00.000+01:00\"},{\"ge\":\"2014-01-01T00:00:00.000+01:00\",\"lt\":\"2014-02-01T00:00:00.000+01:00\",\"name\":\"2014-01-01T00:00:00.000+01:00\",\"label\":\"2014-01-01T00:00:00.000+01:00\"},{\"ge\":\"2014-02-01T00:00:00.000+01:00\",\"lt\":\"2014-03-01T00:00:00.000+01:00\",\"name\":\"2014-02-01T00:00:00.000+01:00\",\"label\":\"2014-02-01T00:00:00.000+01:00\"},{\"ge\":\"2014-03-01T00:00:00.000+01:00\",\"lt\":\"2014-04-01T00:00:00.000+02:00\",\"name\":\"2014-03-01T00:00:00.000+01:00\",\"label\":\"2014-03-01T00:00:00.000+01:00\"},{\"ge\":\"2014-04-01T00:00:00.000+02:00\",\"lt\":\"2014-05-01T00:00:00.000+02:00\",\"name\":\"2014-04-01T00:00:00.000+02:00\",\"label\":\"2014-04-01T00:00:00.000+02:00\"},{\"ge\":\"2014-05-01T00:00:00.000+02:00\",\"lt\":\"2014-06-01T00:00:00.000+02:00\",\"name\":\"2014-05-01T00:00:00.000+02:00\",\"label\":\"2014-05-01T00:00:00.000+02:00\"},{\"ge\":\"2014-06-01T00:00:00.000+02:00\",\"lt\":\"2014-07-01T00:00:00.000+02:00\",\"name\":\"2014-06-01T00:00:00.000+02:00\",\"label\":\"2014-06-01T00:00:00.000+02:00\"},{\"ge\":\"2014-07-01T00:00:00.000+02:00\",\"lt\":\"2014-08-01T00:00:00.000+02:00\",\"name\":\"2014-07-01T00:00:00.000+02:00\",\"label\":\"2014-07-01T00:00:00.000+02:00\"},{\"ge\":\"2014-08-01T00:00:00.000+02:00\",\"lt\":\"2014-09-01T00:00:00.000+02:00\",\"name\":\"2014-08-01T00:00:00.000+02:00\",\"label\":\"2014-08-01T00:00:00.000+02:00\"},{\"ge\":\"2014-09-01T00:00:00.000+02:00\",\"lt\":\"2014-10-01T00:00:00.000+02:00\",\"name\":\"2014-09-01T00:00:00.000+02:00\",\"label\":\"2014-09-01T00:00:00.000+02:00\"},{\"ge\":\"2014-10-01T00:00:00.000+02:00\",\"lt\":\"2014-11-01T00:00:00.000+01:00\",\"name\":\"2014-10-01T00:00:00.000+02:00\",\"label\":\"2014-10-01T00:00:00.000+02:00\"},{\"ge\":\"2014-11-01T00:00:00.000+01:00\",\"lt\":\"2014-12-01T00:00:00.000+01:00\",\"name\":\"2014-11-01T00:00:00.000+01:00\",\"label\":\"2014-11-01T00:00:00.000+01:00\"},{\"ge\":\"2014-12-01T00:00:00.000+01:00\",\"lt\":\"2015-01-01T00:00:00.000+01:00\",\"name\":\"2014-12-01T00:00:00.000+01:00\",\"label\":\"2014-12-01T00:00:00.000+01:00\"},{\"ge\":\"2015-01-01T00:00:00.000+01:00\",\"lt\":\"2015-02-01T00:00:00.000+01:00\",\"name\":\"2015-01-01T00:00:00.000+01:00\",\"label\":\"2015-01-01T00:00:00.000+01:00\"},{\"ge\":\"2015-02-01T00:00:00.000+01:00\",\"lt\":\"2015-03-01T00:00:00.000+01:00\",\"name\":\"2015-02-01T00:00:00.000+01:00\",\"label\":\"2015-02-01T00:00:00.000+01:00\"},{\"ge\":\"2015-03-01T00:00:00.000+01:00\",\"lt\":\"2015-04-01T00:00:00.000+02:00\",\"name\":\"2015-03-01T00:00:00.000+01:00\",\"label\":\"2015-03-01T00:00:00.000+01:00\"},{\"ge\":\"2015-04-01T00:00:00.000+02:00\",\"lt\":\"2015-05-01T00:00:00.000+02:00\",\"name\":\"2015-04-01T00:00:00.000+02:00\",\"label\":\"2015-04-01T00:00:00.000+02:00\"},{\"ge\":\"2015-05-01T00:00:00.000+02:00\",\"lt\":\"2015-06-01T00:00:00.000+02:00\",\"name\":\"2015-05-01T00:00:00.000+02:00\",\"label\":\"2015-05-01T00:00:00.000+02:00\"},{\"ge\":\"2015-06-01T00:00:00.000+02:00\",\"lt\":\"2015-07-01T00:00:00.000+02:00\",\"name\":\"2015-06-01T00:00:00.000+02:00\",\"label\":\"2015-06-01T00:00:00.000+02:00\"},{\"ge\":\"2015-07-01T00:00:00.000+02:00\",\"lt\":\"2015-08-01T00:00:00.000+02:00\",\"name\":\"2015-07-01T00:00:00.000+02:00\",\"label\":\"2015-07-01T00:00:00.000+02:00\"},{\"ge\":\"2015-08-01T00:00:00.000+02:00\",\"lt\":\"2015-09-01T00:00:00.000+02:00\",\"name\":\"2015-08-01T00:00:00.000+02:00\",\"label\":\"2015-08-01T00:00:00.000+02:00\"},{\"ge\":\"2015-09-01T00:00:00.000+02:00\",\"lt\":\"2015-10-01T00:00:00.000+02:00\",\"name\":\"2015-09-01T00:00:00.000+02:00\",\"label\":\"2015-09-01T00:00:00.000+02:00\"},{\"ge\":\"2015-10-01T00:00:00.000+02:00\",\"lt\":\"2015-11-01T00:00:00.000+01:00\",\"name\":\"2015-10-01T00:00:00.000+02:00\",\"label\":\"2015-10-01T00:00:00.000+02:00\"},{\"ge\":\"2015-11-01T00:00:00.000+01:00\",\"lt\":\"2015-12-01T00:00:00.000+01:00\",\"name\":\"2015-11-01T00:00:00.000+01:00\",\"label\":\"2015-11-01T00:00:00.000+01:00\"},{\"ge\":\"2015-12-01T00:00:00.000+01:00\",\"lt\":\"2016-01-01T00:00:00.000+01:00\",\"name\":\"2015-12-01T00:00:00.000+01:00\",\"label\":\"2015-12-01T00:00:00.000+01:00\"},{\"ge\":\"2016-01-01T00:00:00.000+01:00\",\"lt\":\"2016-02-01T00:00:00.000+01:00\",\"name\":\"2016-01-01T00:00:00.000+01:00\",\"label\":\"2016-01-01T00:00:00.000+01:00\"},{\"ge\":\"2016-02-01T00:00:00.000+01:00\",\"lt\":\"2016-03-01T00:00:00.000+01:00\",\"name\":\"2016-02-01T00:00:00.000+01:00\",\"label\":\"2016-02-01T00:00:00.000+01:00\"},{\"ge\":\"2016-03-01T00:00:00.000+01:00\",\"lt\":\"2016-04-01T00:00:00.000+02:00\",\"name\":\"2016-03-01T00:00:00.000+01:00\",\"label\":\"2016-03-01T00:00:00.000+01:00\"},{\"ge\":\"2016-04-01T00:00:00.000+02:00\",\"lt\":\"2016-05-01T00:00:00.000+02:00\",\"name\":\"2016-04-01T00:00:00.000+02:00\",\"label\":\"2016-04-01T00:00:00.000+02:00\"},{\"ge\":\"2016-05-01T00:00:00.000+02:00\",\"lt\":\"2016-06-01T00:00:00.000+02:00\",\"name\":\"2016-05-01T00:00:00.000+02:00\",\"label\":\"2016-05-01T00:00:00.000+02:00\"}]},\"name\":\"date\"},\"period\":\"MONTH\"}";
		JSONAssert.assertEquals(actual, expected, false);
	}
}

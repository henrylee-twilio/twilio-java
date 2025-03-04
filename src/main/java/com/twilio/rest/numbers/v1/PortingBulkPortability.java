/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.numbers.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class PortingBulkPortability extends Resource {
    private static final long serialVersionUID = 54521824330020L;

    public static PortingBulkPortabilityCreator creator(final List<String> phoneNumbers){
        return new PortingBulkPortabilityCreator(phoneNumbers);
    }

    public static PortingBulkPortabilityFetcher fetcher(final String pathSid){
        return new PortingBulkPortabilityFetcher(pathSid);
    }

    /**
    * Converts a JSON String into a PortingBulkPortability object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return PortingBulkPortability object represented by the provided JSON
    */
    public static PortingBulkPortability fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PortingBulkPortability.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a PortingBulkPortability object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return PortingBulkPortability object represented by the provided JSON
    */
    public static PortingBulkPortability fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PortingBulkPortability.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Status {
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        EXPIRED("expired");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String sid;
    private final PortingBulkPortability.Status status;
    private final ZonedDateTime datetimeCreated;
    private final List<Map<String, Object>> phoneNumbers;
    private final URI url;

    @JsonCreator
    private PortingBulkPortability(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("status")
        final PortingBulkPortability.Status status,

        @JsonProperty("datetime_created")
        final String datetimeCreated,

        @JsonProperty("phone_numbers")
        final List<Map<String, Object>> phoneNumbers,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.status = status;
        this.datetimeCreated = DateConverter.iso8601DateTimeFromString(datetimeCreated);
        this.phoneNumbers = phoneNumbers;
        this.url = url;
    }

        public final String getSid() {
            return this.sid;
        }
        public final PortingBulkPortability.Status getStatus() {
            return this.status;
        }
        public final ZonedDateTime getDatetimeCreated() {
            return this.datetimeCreated;
        }
        public final List<Map<String, Object>> getPhoneNumbers() {
            return this.phoneNumbers;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PortingBulkPortability other = (PortingBulkPortability) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(status, other.status) &&  Objects.equals(datetimeCreated, other.datetimeCreated) &&  Objects.equals(phoneNumbers, other.phoneNumbers) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, status, datetimeCreated, phoneNumbers, url);
    }

}


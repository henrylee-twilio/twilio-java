/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class UserCreator extends Creator<User> {
    private final String pathChatServiceSid;
    private final String identity;
    private String friendlyName;
    private String attributes;
    private String roleSid;

    /**
     * Construct a new UserCreator.
     *
     * @param pathChatServiceSid The SID of the Service that the resource is
     *                           associated with
     * @param identity The string that identifies the resource's User
     */
    public UserCreator(final String pathChatServiceSid,
                       final String identity) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.identity = identity;
    }

    /**
     * The string that you assigned to describe the resource..
     *
     * @param friendlyName The string that you assigned to describe the resource
     * @return this
     */
    public UserCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The JSON Object string that stores application-specific data. If attributes
     * have not been set, `{}` is returned..
     *
     * @param attributes The JSON Object string that stores application-specific
     *                   data
     * @return this
     */
    public UserCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * The SID of the [Role](https://www.twilio.com/docs/chat/rest/role-resource) to
     * assign to the user..
     *
     * @param roleSid The SID of the Role to assign to the user
     * @return this
     */
    public UserCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created User
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public User create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            "/v1/Services/" + this.pathChatServiceSid + "/Users"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("User creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return User.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }

        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
        }
    }
}
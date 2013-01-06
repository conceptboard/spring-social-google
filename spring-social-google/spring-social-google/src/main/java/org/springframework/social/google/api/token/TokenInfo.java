package org.springframework.social.google.api.token;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * represents the answer to a tokeninfo call according to https://developers.google.com/accounts/docs/OAuth2Login
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenInfo {

    private String audience;
    private String issued_to;
    private String scope;
    private String userid;
    private Long expires_in;
    private String email;
    private Boolean verified_email;
    private String access_type;


    /**
     * The application that is the intended target of the token.
     * 
     * Client applications should check, that this token is meant for them and ignore any tokens which are not meant for the client
     */
    public String getAudience(){
        return audience;
    }

    /**
     * {@link #getAudience()}
     */
    public String getIssued_to(){
        return issued_to;
    }

    /**
     * The space delimited set of scopes that the user consented to.
     */
    public String getScope(){
        return scope;
    }

    /**
     * This field is only present if the https://www.googleapis.com/auth/userinfo.profile scope was present in the request for the access token. The value of this field is an
     * immutable identifier for the logged-in user, and may be used when creating and managing user sessions in your application. This identifier is the same regardless of the
     * client_id. This provides the ability to correlate profile information across multiple applications in the same organization.
     */
    public String getUserid(){
        return userid;
    }

    /** The number of seconds left in the lifetime of the token. */
    public Long getExpires_in(){
        return expires_in;
    }

    /**
     * {@link UserInfo#getEmail()}
     */
    public String getEmail(){
        return email;
    }

    /**
     * {@link UserInfo#getVerified_email()}
     */
    public Boolean getVerified_email(){
        return verified_email;
    }

    public String getAccess_type(){
        return access_type;
    }
}

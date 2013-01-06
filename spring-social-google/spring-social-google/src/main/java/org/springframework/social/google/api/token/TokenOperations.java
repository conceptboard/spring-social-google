package org.springframework.social.google.api.token;

/**
 * Defines operations applicable to a oauth token as described in https://developers.google.com/accounts/docs/OAuth2Login
 */
public interface TokenOperations {

    /**
     * retrieve information about the user with the current token
     * 
     * only available if the scope https://www.googleapis.com/auth/userinfo.profile was included for the access token
     */
    UserInfo getUserInfo();

    /**
     * retrieve information about the current token
     * 
     * user related information is only available if the scope https://www.googleapis.com/auth/userinfo.profile was included for the access token
     */
    TokenInfo getTokenInfo();
}

package org.springframework.social.google.api.token.impl;

import java.util.Map;
import java.util.HashMap;

import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.social.google.api.token.TokenInfo;
import org.springframework.social.google.api.token.TokenOperations;
import org.springframework.social.google.api.token.UserInfo;
import org.springframework.web.client.RestTemplate;

public class TokenTemplate extends AbstractGoogleApiOperations implements TokenOperations {

    private static final String TOKENINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v1/tokeninfo?access_token={access_token}";
    private static final String USERINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v1/userinfo?access_token={access_token}";
    private static final String ACCESS_TOKEN_REQUEST_PARAM_NAME = "access_token";
    private final String accessToken;

    public TokenTemplate(final RestTemplate restTemplate, final boolean isAuthorized, final String accessToken) {
        super(restTemplate, isAuthorized);
        this.accessToken = accessToken;
    }

    @Override
    public TokenInfo getTokenInfo() {
        return restTemplate.getForObject(TOKENINFO_ENDPOINT, TokenInfo.class, getParams(this.accessToken));
    }

    @Override
    public UserInfo getUserInfo() {
        return restTemplate.getForObject(USERINFO_ENDPOINT, UserInfo.class, getParams(this.accessToken));
    }

    private Map<String, String> getParams(String accessToken){
        final Map<String, String> params = new HashMap<String, String>();
        params.put(ACCESS_TOKEN_REQUEST_PARAM_NAME, accessToken);
        return params;
    }
}

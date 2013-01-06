/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.google.connect;

import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.token.TokenInfo;
import org.springframework.social.oauth2.AccessGrant;

/**
 * Google ConnectionFactory implementation.
 * @author Gabriel Axel
 */
public class GoogleConnectionFactory extends OAuth2ConnectionFactory<Google> {

	private final String clientId;

	public GoogleConnectionFactory(String clientId, String clientSecret) {
		super("google", new GoogleServiceProvider(clientId, clientSecret),
				new GoogleAdapter());
		this.clientId = clientId;
	}

	@Override
	protected String extractProviderUserId(final AccessGrant accessGrant) {
		final String accessToken = accessGrant.getAccessToken();
		final TokenInfo tokenInfo = getGoogleServiceProvider().getApi(accessToken).tokenOperations().getTokenInfo();
		validateToken(tokenInfo);
		return tokenInfo.getUserid();
	}

	protected void validateToken(final TokenInfo tokenInfo) {
		checkClientId(this.clientId, tokenInfo);
	}

	protected void checkClientId(final String clientId, final TokenInfo tokenInfo) {
		if (!clientId.equals(tokenInfo.getAudience())) {
			throw new InvalidAuthorizationException(
				String.format("the audience of the tokeninfo [ %s ] does not match clientid [ %s ]", tokenInfo.getAudience(), clientId));
		}
	}

	protected GoogleServiceProvider getGoogleServiceProvider() {
		return (GoogleServiceProvider) getServiceProvider();
	}
}

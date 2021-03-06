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

import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Google ServiceProvider implementation.
 * @author Gabriel Axel
 */
public class GoogleServiceProvider extends AbstractOAuth2ServiceProvider<Google> {

	private final String quotaUserId;

	public GoogleServiceProvider(String clientId, String clientSecret) {
		this(clientId, clientSecret, null, false);
	}
	
	public GoogleServiceProvider(String clientId, String clientSecret, String quotaUserId) {
		this(clientId, clientSecret, quotaUserId, false);
	}

	public GoogleServiceProvider(String clientId, String clientSecret, boolean offline) {
		this(clientId, clientSecret, null, offline);
	}

	public GoogleServiceProvider(String clientId, String clientSecret, String quotaUserId, boolean offline) {
		super(new GoogleOAuth2Template(clientId, clientSecret, offline));
		this.quotaUserId = quotaUserId;
	}

	@Override
	public Google getApi(String accessToken) {
		return new GoogleTemplate(accessToken, quotaUserId);
	}

}

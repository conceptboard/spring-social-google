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

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.token.UserInfo;

/**
 * Google ApiAdapter implementation.
 * @author Gabriel Axel
 */
public class GoogleAdapter implements ApiAdapter<Google> {

	public boolean test(Google google) {
		try {
			google.tokenOperations().getTokenInfo();
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	public void setConnectionValues(Google google, ConnectionValues values) {
		final UserInfo userInfo = google.tokenOperations().getUserInfo();
		values.setProviderUserId(userInfo.getId());
		values.setDisplayName(userInfo.getName());
		values.setProfileUrl(userInfo.getLink());
		values.setImageUrl(userInfo.getPicture() == null ? null : userInfo.getPicture().toString());
	}

	public UserProfile fetchUserProfile(Google google) {
		final UserInfo userInfo = google.tokenOperations().getUserInfo();
		return new UserProfileBuilder()
			.setEmail(userInfo.getEmail())
			.setName(userInfo.getName())
			.setFirstName(userInfo.getGiven_name())
			.setLastName(userInfo.getFamily_name())
			.build();
	}

	public void updateStatus(Google google, String message) {
		throw new UnsupportedOperationException();
	}
}

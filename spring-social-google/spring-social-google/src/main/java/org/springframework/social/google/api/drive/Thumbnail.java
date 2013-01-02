package org.springframework.social.google.api.drive;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Thumbnail {
	private String mimeType;

	private byte[] image;

	@JsonCreator
	public Thumbnail(@JsonProperty("mimeType") String mimeType, @JsonProperty("image") @JsonDeserialize(using = UrlsafeBase64Deserializer.class) byte[] image) {
		this.mimeType = mimeType;
		this.image = image;
	}

	public String getMimeType() {
		return mimeType;
	}

	@JsonSerialize(using = UrlsafeBase64Serializer.class)
	public byte[] getImage() {
		return image;
	}
}

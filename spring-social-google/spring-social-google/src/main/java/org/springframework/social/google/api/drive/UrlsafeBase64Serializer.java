package org.springframework.social.google.api.drive;

import java.io.IOException;

import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;

public class UrlsafeBase64Serializer extends SerializerBase<byte[]> {

	public UrlsafeBase64Serializer() {
		super(byte[].class);
	}

	@Override
	public void serialize(byte[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		jgen.writeBinary(Base64Variants.MODIFIED_FOR_URL, value, 0, value.length);
	}

}

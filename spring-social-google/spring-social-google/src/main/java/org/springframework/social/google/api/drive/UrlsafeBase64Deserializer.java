package org.springframework.social.google.api.drive;

import java.io.IOException;

import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.ser.std.SerializerBase;



public class UrlsafeBase64Deserializer extends StdDeserializer<byte[]> {

	public UrlsafeBase64Deserializer() {
	    super(byte[].class);
    }

	@Override
    public byte[] deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	    return jp.getBinaryValue(Base64Variants.MODIFIED_FOR_URL);
    }

}

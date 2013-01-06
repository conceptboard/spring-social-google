package org.springframework.social.google.api.impl;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.social.support.URIBuilder;

public final class AddUrlParamInterceptor implements ClientHttpRequestInterceptor {
    
    private final String paramName;
    private final String paramValue;

    public AddUrlParamInterceptor(String paramName, String paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return execution.execute(new AddUrlParamHttpDecorator(request, paramName, paramValue), body);
    }
    
    private static final class AddUrlParamHttpDecorator extends HttpRequestDecorator {
        private final String paramName;
        private final String paramValue;
        private AddUrlParamHttpDecorator(HttpRequest request, String paramName, String paramValue) {
            super(request);
            this.paramName = paramName;
            this.paramValue = paramValue;
        }

        @Override
        public URI getURI() {
            return URIBuilder.fromUri(super.getURI().toASCIIString()).queryParam(paramName, paramValue).build();
        }
    }
}

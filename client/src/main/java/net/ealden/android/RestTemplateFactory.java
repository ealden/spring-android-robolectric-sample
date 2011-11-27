package net.ealden.android;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public final class RestTemplateFactory {
    private static RestTemplate restTemplate;

    private RestTemplateFactory() throws Exception {
        throw new IllegalAccessException();
    }

    public static RestTemplate getRestTemplate() {
        if (RestTemplateFactory.restTemplate != null) {
            return restTemplate;
        }

        return createRestTemplate();
    }

    private static RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters());

        return restTemplate;
    }

    private static List<HttpMessageConverter<?>> messageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJacksonHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());

        return messageConverters;
    }

    public static void setRestTemplate(RestTemplate restTemplate) {
        RestTemplateFactory.restTemplate = restTemplate;
    }
}

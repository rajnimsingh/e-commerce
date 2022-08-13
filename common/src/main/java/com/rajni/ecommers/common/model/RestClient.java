package com.rajni.ecommers.common.model;

import com.rajni.ecommers.common.model.request.HttpRequest;
import com.rajni.ecommers.common.model.response.HttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static com.rajni.ecommers.common.utils.EcommerceServiceConstants.*;

@AllArgsConstructor
public final class RestClient {
    private static final HttpHeaders HTTP_HEADERS = new HttpHeaders();

    static {
        HTTP_HEADERS.add(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        HTTP_HEADERS.add(ACCEPT_KEY, ACCEPT_VALUE);
    }

    private RestTemplate restTemplate;

    public HttpResponse get(HttpRequest httpRequest) {
        HttpEntity<String> httpEntity = new HttpEntity<>(HTTP_HEADERS);
        final ResponseEntity<String> responseEntity = restTemplate.exchange(httpRequest.getUri(), HttpMethod.GET, httpEntity, String.class);
        return HttpResponse.builder()
                .body(responseEntity.getBody())
                .httpStatus(responseEntity.getStatusCode())
                .build();
    }

    public HttpResponse post(HttpRequest httpRequest) {
        HttpEntity<String> httpEntity = new HttpEntity<>(HTTP_HEADERS);
        final ResponseEntity<String> responseEntity = restTemplate.exchange(httpRequest.getUri(), HttpMethod.POST, httpEntity, String.class);
        return HttpResponse.builder()
                .body(responseEntity.getBody())
                .httpStatus(responseEntity.getStatusCode())
                .build();
    }
}

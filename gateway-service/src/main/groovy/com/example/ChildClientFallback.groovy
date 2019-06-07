package com.example


import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.server.exceptions.HttpServerException
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Single

@CompileStatic
@Slf4j
@Fallback
class ChildClientFallback implements ChildOperations {

    @Override
    Single<com.example.Response> testFallback() {
        Single.error(new RuntimeException("Response from fallback"))
    }
}

package com.example

import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject


@MicronautTest
class TestControllerSpec extends Specification {

    @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup
    RxHttpClient client

    void setup() {
        client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())
    }


    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/test")

        expect:
        response.status == HttpStatus.OK
    }
}

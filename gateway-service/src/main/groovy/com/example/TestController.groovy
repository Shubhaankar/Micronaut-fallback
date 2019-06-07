package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post
import io.reactivex.Single

import javax.inject.Inject
import javax.xml.ws.Response


@Controller("/gateway")
class TestController {


    @Inject
    ChildClient childClient;

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Post("/testFallback")
    Single<com.example.Response> testFallback() {
        childClient.testFallback()
    }
}
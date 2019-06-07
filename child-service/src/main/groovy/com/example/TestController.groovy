package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post
import io.reactivex.Single

import javax.xml.ws.Response


@Controller("/child")
class TestController {

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }


    @Post("/testFallback")
    Single<com.example.Response> testFallback() {
        throw new RuntimeException("Exception from code")
    }


    @Error
    public MutableHttpResponse<com.example.Response> serviceExceptionHandler(HttpRequest request, Exception exception) {
        return HttpResponse
                .<String> status(HttpStatus.BAD_REQUEST)
                .body(com.example.Response.getErrorResponse(10))
    }
}
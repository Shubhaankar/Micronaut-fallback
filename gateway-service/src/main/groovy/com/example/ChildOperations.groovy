package com.example


import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.reactivex.Single

@Validated
@CompileStatic
interface ChildOperations {

    @Post("/testFallback")
    Single<com.example.Response> testFallback()

}
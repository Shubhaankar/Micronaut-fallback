package com.example

import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientException
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.server.exceptions.HttpServerException
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Retryable
import io.reactivex.Single

@Client(value = "http://localhost:9002", path = "/child")
@Retryable(attempts = "1")
interface ChildClient extends ChildOperations {

}
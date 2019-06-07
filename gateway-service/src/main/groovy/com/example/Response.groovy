package com.example

class Response<T> {

    T data
    int error = 0

    static <T> Response<T> getSuccessResponse(T data) {
        Response<T> response = new Response<>()
        response.data = data
        response.error = 0
        return response
    }

    static Response<Void> getErrorResponse(int error) {
        Response<Void> response = new Response<>()
        response.data = null
        response.error = error
        return response
    }
}

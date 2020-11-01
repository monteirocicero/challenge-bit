package com.orecic.controller
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class ChallengeBitTest {

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testGetOrder() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/item?begindate=01-10-2016&finaldate=03-10-2016")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
    }

}
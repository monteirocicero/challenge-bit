package com.orecic.infraestructure

import com.orecic.domain.data.Order
import io.micronaut.context.annotation.Primary
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpRequest.GET
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Primary
class OrderAPIClientImpl : OrderAPIClient {


    @Client("http://www.mocky.io")
    @Inject lateinit var httpClient: RxHttpClient

    override fun getItens(): List<Order> {
        var response: Flowable<Map<*, *>> = httpClient.retrieve(
                GET<Any>("/v2/5817803a1000007d01cc7fc9"), Argument.of(Map::class.java))

        

        println(response.firstElement())
        return emptyList()
    }
}
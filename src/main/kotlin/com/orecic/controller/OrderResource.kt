package com.orecic.controller

import com.orecic.infraestructure.external.OrderClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/api")
class OrderResource {

    @Inject
    lateinit var orderClient: OrderClient

    @Get("order")
    @Produces(MediaType.APPLICATION_JSON)
    internal fun getOrder(): MutableHttpResponse<Any> {

        return HttpResponse.ok(orderClient.fetchOrders())
    }
}
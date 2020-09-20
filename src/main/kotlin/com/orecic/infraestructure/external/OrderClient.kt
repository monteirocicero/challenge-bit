package com.orecic.infraestructure.external

import com.orecic.domain.data.Order
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable

@Client(OrderClientConfiguration.ORDER_URL)
interface OrderClient {

    @Get(OrderClientConfiguration.ORDER_URI)
    fun fetchOrders(): Flowable<Order>
}
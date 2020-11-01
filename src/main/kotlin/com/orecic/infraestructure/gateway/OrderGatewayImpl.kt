package com.orecic.infraestructure.gateway

import com.orecic.domain.data.Order
import com.orecic.infraestructure.external.OrderClient
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class OrderGatewayImpl : OrderGateway {

    @Inject
    lateinit var orderClient: OrderClient

    override fun getOrders(): Flowable<Order> {
        return orderClient.fetchOrders()
    }
}
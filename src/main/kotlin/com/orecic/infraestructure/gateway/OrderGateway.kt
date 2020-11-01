package com.orecic.infraestructure.gateway

import com.orecic.domain.data.Order
import io.reactivex.Flowable

interface OrderGateway {
    fun getOrders(): Flowable<Order>
}
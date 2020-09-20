package com.orecic.infraestructure

import com.orecic.domain.data.Order

interface OrderAPIClient {
    fun getItens(): List<Order>
}
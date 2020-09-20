package com.orecic.infraestructure

import com.orecic.domain.data.Order
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class OrderClientTest {

    @Inject
    lateinit var orderAPIClient: OrderAPIClient

    @Test
    fun shouldGetOrdersWithSuccess() {
        // given

        // when

        val orders : List<Order> = orderAPIClient.getItens()

        // then
        Assertions.assertNotNull(orders)
        Assertions.assertTrue(orders.isNotEmpty())

    }
}
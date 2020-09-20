package com.orecic.usecase

import com.orecic.domain.OrderUseCase
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import javax.inject.Inject

@MicronautTest
class OrderUseCaseTest {

    @Inject
    lateinit var orderUseCase: OrderUseCase

    @Test
    fun shoudGetItemWithSucess() {
        // given
        val beginDate = LocalDate.of(2016,10,5)
        val finalDate = LocalDate.of(2016,10,10)

        // when
        val ordersOnDate = orderUseCase.getItemByDate(beginDate, finalDate)

        // when
        Assertions.assertTrue(ordersOnDate.isNotEmpty())
        Assertions.assertTrue(ordersOnDate.size == 10)
    }

}
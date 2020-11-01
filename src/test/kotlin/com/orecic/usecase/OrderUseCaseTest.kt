package com.orecic.usecase

import com.orecic.domain.usecase.OrderUseCase
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
    fun shouldGetItemWithSucess() {
        // given
        val beginDate = LocalDate.of(2016,10,1)
        val finalDate = LocalDate.of(2016,10,3)

        // when
        val ordersOnDate = orderUseCase.getItemByDate(beginDate, finalDate)

        // when
        Assertions.assertTrue(ordersOnDate.isNotEmpty())
        Assertions.assertTrue(ordersOnDate.size == 3)
    }

    @Test
    fun shouldGetItemWithSucessWhenRangeIsBeforeInitInterval() {
        // given
        val beginDate = LocalDate.of(2016,9,1)
        val finalDate = LocalDate.of(2016,10,3)

        // when
        val ordersOnDate = orderUseCase.getItemByDate(beginDate, finalDate)

        // when
        Assertions.assertTrue(ordersOnDate.isNotEmpty())
        Assertions.assertTrue(ordersOnDate.size == 3)
    }

    @Test
    fun shouldNotGetItemWithSucess() {
        // given
        val beginDate = LocalDate.of(2016,8,1)
        val finalDate = LocalDate.of(2016,9,1)

        // when
        val ordersOnDate = orderUseCase.getItemByDate(beginDate, finalDate)

        // when
        Assertions.assertTrue(ordersOnDate.isEmpty())

    }

}
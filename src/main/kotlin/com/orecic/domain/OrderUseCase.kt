package com.orecic.domain

import com.orecic.domain.data.Order
import java.time.LocalDate

interface OrderUseCase {
    fun getItemByDate(beginDate: LocalDate, finalDate: LocalDate): List<Order>
}
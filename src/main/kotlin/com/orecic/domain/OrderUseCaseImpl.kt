package com.orecic.domain

import com.orecic.domain.data.Order
import com.orecic.infraestructure.external.OrderClient
import org.slf4j.LoggerFactory
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class OrderUseCaseImpl : OrderUseCase {

    @Inject
    lateinit var orderClient: OrderClient

     override fun getItemByDate(beginDate: LocalDate, finalDate: LocalDate): List<Order> {
        logger.info("m=getItemByDate beginDate={} finalDate={}", beginDate, finalDate)

        val orders = orderClient.fetchOrders()

        val list: MutableList<Order> = mutableListOf()
        orders.blockingForEach{
            if (it.dateFormatted()?.let { it1 -> validateRangeOfDate(beginDate, finalDate, it1) }!!) {
                list.add(it)
            }
        }

        return list
    }

    private fun validateRangeOfDate(beginDate: LocalDate, finalDate: LocalDate, dateOfItem: LocalDate): Boolean {
        return dateOfItem in beginDate..finalDate
    }



    //2016-10-01T14:30:37.040Z
    companion object {
        private val logger = LoggerFactory.getLogger(OrderUseCaseImpl::class.java)
    }
}
package com.orecic.controller

import com.orecic.domain.usecase.OrderUseCase
import com.orecic.infraestructure.adapter.DateConverter
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import javax.inject.Inject


@Controller("/api")
class OrderResource {

    @Inject
    lateinit var orderUseCase: OrderUseCase

    @Get("item")
    @Produces(MediaType.APPLICATION_JSON)
    internal fun getOrder(@QueryValue("begindate") begindate: String, @QueryValue("finaldate") finaldate: String): MutableHttpResponse<Any> {

        return HttpResponse.ok(DateConverter.convertStringToLocalDate(begindate)?.let {
            DateConverter.convertStringToLocalDate(finaldate)?.let { end ->
                orderUseCase.getItemByDate(it,
                        end)
            }
        })
    }


}
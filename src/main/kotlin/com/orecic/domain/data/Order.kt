package com.orecic.domain.data

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


data class Order(val name: String, val code: String,
            val date: String,val dimension: Dimension) {

    fun dateFormatted(): LocalDate? {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val parsedDate: Date = dateFormat.parse(date)
        return convertToLocalDateViaInstant(parsedDate)
    }

    private fun convertToLocalDateViaInstant(dateToConvert: Date): LocalDate? {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
    }
}

package com.orecic.infraestructure.adapter

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateConverter {

    companion object {
        fun convertStringToLocalDate(dateToConvert: String): LocalDate? {
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            return LocalDate.parse(dateToConvert, formatter)
        }
    }


}
package com.example.primeiroapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate{

    val dateFormaterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate.parse(brazilDate, dateFormaterFromBrazil)

    return localDateFormat

}
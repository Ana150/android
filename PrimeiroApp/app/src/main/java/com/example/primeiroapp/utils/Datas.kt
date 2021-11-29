package com.example.primeiroapp.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate{

    val dateFormaterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate.parse(brazilDate, dateFormaterFromBrazil)

    return localDateFormat

}

fun getDataAtualBrasil(): String{

    val hoje = LocalDate.now()

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataBrasil = hoje.format(formatter)

    return dataBrasil
}

fun calcularIdade(dataNascimento: String): Int{
    Log.i("xxxx", dataNascimento)
    //Obter a data atual
    val hoje = LocalDate.now()

    //converter data de nascimento em local date
    //extrair a data em array
    val nascimentoArray = dataNascimento.split("-").toTypedArray()
    val nascimento = LocalDate.of(
        nascimentoArray[0].toInt(),
        nascimentoArray[1].toInt(),
        nascimentoArray[2].toInt())

    //obter a idade
    val idade = Period.between(nascimento, hoje).years

    return idade
}
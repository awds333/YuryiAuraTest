package com.yuryi.aura.test.presentation.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

fun LocalDate.format(): String =
    "${dayOfMonth.digits()}/${monthNumber.digits()}/${year.digits(4)}"

fun LocalTime.format(): String =
    "${hour.digits()}:${minute.digits()}:${second.digits()}"

fun LocalDateTime.format(): String =
    "${date.format()} ${time.format()}"

private fun Int.digits(count: Int = 2): String =
    toString().padStart(count, '0')

package com.example.simbirsoft.core.domain.models

import java.util.Calendar

data class Note(
    val id: Int,
    val calendarStart: Calendar,
    val calendarFinish: Calendar,
    val name: String,
    val description: String
)

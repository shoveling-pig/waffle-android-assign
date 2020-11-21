package com.example.seminarmanager.api

data class Seminar(
    val id: Long,
    val name: String,
    val capacity: Int,
    val count: Int,
    val time: String,
    val online: String,
    val instructors: List<User>,
    val participants: List<User>
)

data class SimpleSeminar(
    val id: Long,
    val name: String,
    val instructors: List<User>,
    val participant_count: String
)

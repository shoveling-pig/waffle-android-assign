package com.example.seminarmanager.api

data class User(
    val id: Long,
    val username: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val role: String,
    val participant: ParticipantProfile,
    val instructor: InstructorProfile,
    val token: String
)

data class ParticipantProfile(
    val id: Long,
    val university: String,
    val accepted: Boolean,
    val seminars: List<Seminar>
)

data class InstructorProfile(
    val id: Long,
    val company: String,
    val year: Int,
    val seminars: List<Seminar>
)
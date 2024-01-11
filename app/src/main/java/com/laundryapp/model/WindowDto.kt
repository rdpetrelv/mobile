package com.laundryapp.model



data class WindowDto(
    val id: Long,
    val name: String,
    val roomName: String,
    val roomId: Long,
    val windowStatus: WindowStatus
)

enum class WindowStatus { OPENED, CLOSED}
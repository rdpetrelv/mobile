package com.laundryapp.service

import com.laundryapp.model.SensorDto
import com.laundryapp.model.WindowDto
import com.laundryapp.model.WindowStatus

object RoomService {
    val ROOMS_NAME = listOf("Room EF 6.10", "Hall", "Room EF 7.10")

    // Fake windows
    val WINDOWS: List<WindowDto> = listOf(
        WindowDto(
            id = 1,
            name = "Entry Window",
            roomId = 1,
            roomName = ROOMS_NAME[0],
            windowStatus = WindowStatus.CLOSED
        ),
        WindowDto(
            id = 2,
            name = "Back Window",
            roomId = 1,
            roomName = ROOMS_NAME[0],
            windowStatus = WindowStatus.CLOSED
        ),
        WindowDto(
            id = 3,
            name = "Sliding door",
            roomId = 2,
            roomName = ROOMS_NAME[1],
            windowStatus = WindowStatus.OPENED
        ),
        WindowDto(
            id = 4,
            name = "Window 1",
            roomId = 3,
            roomName = ROOMS_NAME[2],
            windowStatus = WindowStatus.OPENED
        ),
        WindowDto(
            id = 5,
            name = "Window 2",
            roomId = 3,
            roomName = ROOMS_NAME[2],
            windowStatus = WindowStatus.CLOSED
        )
    )

    // Fake rooms
    val ROOMS: List<SensorDto> = listOf(
        SensorDto(1, "Room EF 6.10", 18.2, 20.0, WINDOWS.filter { it.roomId == 1L },100000,"notworking",false,"ac",0),
        SensorDto(2, "Hall", 18.2, 18.0, WINDOWS.filter { it.roomId == 2L }, 100000,"notworking" ,false,"0",0),
        SensorDto(3, "Room EF 7.10", 21.2, 20.0, WINDOWS.filter { it.roomId == 3L }, 100000,"notworking",false,"0",0)
    )
}
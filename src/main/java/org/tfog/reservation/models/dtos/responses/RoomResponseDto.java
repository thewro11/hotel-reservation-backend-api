package org.tfog.reservation.models.dtos.responses;

public record RoomResponseDto(
  String roomNumber,
  int maxGuestAmount
) { }

package org.tfog.reservation.models.dtos.requests;

public record CheckInRequestDto(
  String guestName,
  int stayDay
) { }

package org.tfog.reservation.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.tfog.reservation.models.Room;
import org.tfog.reservation.models.dtos.requests.CheckInRequestDto;
import org.tfog.reservation.models.dtos.responses.RoomResponseDto;
import org.tfog.reservation.services.RoomService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/rooms")
public class RoomController {

  private final RoomService roomService;

  RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public List<Room> getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/{roomNumber}")
  public Room getRoom(@PathVariable String roomNumber) {
    return roomService.getRoom(roomNumber);
  }

  @PostMapping
  public Room createNewRoom(@RequestBody Room room) {
    return roomService.updateRoom(room);
  }

  @PutMapping
  public Room updateRoom(@RequestBody Room room) {
    return roomService.updateRoom(room);
  }

  @DeleteMapping("/{roomNumber}")
  public void deleteRoom(@PathVariable String roomNumber) {
    roomService.deleteRoom(roomNumber);
  }

  @PostMapping("/check-in/{roomNumber}")
  public void checkIn(@PathVariable String roomNumber, @RequestBody CheckInRequestDto checkInRequestDto) throws Exception {
    String guestName = checkInRequestDto.guestName();
    int stayDay = checkInRequestDto.stayDay();
    roomService.checkIn(roomNumber, guestName, stayDay);
  }

  @PostMapping("/check-out/{roomNumber}")
  public void checkOut(@RequestBody String roomNumber) throws Exception {
    roomService.checkOut(roomNumber);
  }

  @PostMapping("/maintenance/complete/{roomNumber}")
  public void completeMaintenance(@PathVariable String roomNumber) throws Exception {
    roomService.completeMaintenance(roomNumber);
  }

  @GetMapping("/available")
  public List<RoomResponseDto> getAvailableRooms() {
      return roomService.getAvailableRooms();
  }

}

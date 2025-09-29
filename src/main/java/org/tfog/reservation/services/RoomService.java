package org.tfog.reservation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tfog.reservation.models.Room;
import org.tfog.reservation.models.dtos.responses.RoomResponseDto;
import org.tfog.reservation.models.enums.RoomStatus;
import org.tfog.reservation.repositories.RoomRepository;

@Service
public class RoomService {

  private final RoomRepository roomRepository;

  RoomService(RoomRepository roomRepository) {
      this.roomRepository = roomRepository;
  }

  public List<Room> getRooms() {
    return roomRepository.findAll();
  }

  public List<RoomResponseDto> getAvailableRooms() {
    return roomRepository.findByRoomStatusEquals(RoomStatus.AVAILABLE).parallelStream().map(room -> room.toResponseDto()).toList();
  }

  public Room getRoom(String roomNumber) {
    return roomRepository.findById(roomNumber).get();
  }

  public Room updateRoom(Room updatedRoom) {
    return roomRepository.save(updatedRoom);
  }

  public void deleteRoom(String roomNumber) {
    roomRepository.deleteById(roomNumber);
  }

  public void checkIn(String roomNumber, String guestName, int stayDay) throws Exception {
    Room room = getRoom(roomNumber);
    room.checkIn(guestName, stayDay);
    roomRepository.save(room);
  }

  public void checkOut(String roomNumber) throws Exception {
    Room room = getRoom(roomNumber);
    room.checkOut();
    roomRepository.save(room);
  }

  public void completeMaintenance(String roomNumber) throws Exception {
    Room room = getRoom(roomNumber);
    room.completeMaintenance();
    roomRepository.save(room);
  }

}

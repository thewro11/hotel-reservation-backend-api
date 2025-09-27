package org.tfog.reservation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tfog.reservation.models.Room;
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

  public Room getRoom(String roomNumber) {
    return roomRepository.findById(roomNumber).get();
  }

  public Room createNewRoom(Room room) {
    return updateRoom(room);
  }

  public Room updateRoom(Room updatedRoom) {
    return roomRepository.save(updatedRoom);
  }

  public void deleteRoom(String roomNumber) {
    roomRepository.deleteById(roomNumber);
  }

}

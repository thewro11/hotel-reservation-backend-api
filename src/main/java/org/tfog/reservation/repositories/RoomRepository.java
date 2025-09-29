package org.tfog.reservation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tfog.reservation.models.Room;
import org.tfog.reservation.models.enums.RoomStatus;

public interface RoomRepository extends JpaRepository<Room, String> {
  List<Room> findByRoomStatusEquals(RoomStatus roomStatus);
}

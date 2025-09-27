package org.tfog.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tfog.reservation.models.Room;

public interface RoomRepository extends JpaRepository<Room, String> {
  
}

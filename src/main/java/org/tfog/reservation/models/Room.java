package org.tfog.reservation.models;

import java.time.LocalDateTime;

import org.tfog.reservation.models.dtos.responses.RoomResponseDto;
import org.tfog.reservation.models.enums.RoomStatus;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

  @Id
  private String roomNumber;

  @Nonnull
  private RoomStatus roomStatus;

  @Nonnull
  private int maxGuestAmount;

  private LocalDateTime checkInDateTime;

  private String guestName;

  private int stayDay;

  public RoomResponseDto toResponseDto() {
    return new RoomResponseDto(this.roomNumber, this.maxGuestAmount);
  }

  public void checkIn(String guestName, int stayDay) throws Exception {
    if (guestName == null) {
      throw new Exception("guestName must not be null.");
    }
    if (stayDay <= 0) {
      throw new Exception("stayDay must be greater than 0.");
    }
    this.roomStatus = RoomStatus.OCCUPIED;
    this.guestName = guestName;
    this.checkInDateTime = LocalDateTime.now();
    this.stayDay = stayDay;
  }

  public void checkOut() throws Exception {
    if (this.roomStatus.equals(RoomStatus.AVAILABLE)) {
      throw new Exception("Room status must not be available in order to check out.");
    }
    this.roomStatus = RoomStatus.MAINTENANCE;
    this.guestName = null;
    this.checkInDateTime = null;
    this.stayDay = 0;
  }

  public void completeMaintenance() throws Exception {
    if (this.roomStatus.equals(RoomStatus.OCCUPIED)) {
      throw new Exception("Room status must not be occupied to complete maintenance.");
    }
    this.roomStatus = RoomStatus.AVAILABLE;
  }

}

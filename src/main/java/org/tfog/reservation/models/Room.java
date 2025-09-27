package org.tfog.reservation.models;

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

}

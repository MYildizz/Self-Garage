package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parking_owner_information")
public class ParkingOwnerInformation extends BaseUserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;


@Table(name="driver_information")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverInformation extends BaseUserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="car_plate",length = 100,unique = true,nullable = true)
    private String carPlate;
}

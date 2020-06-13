package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parkingOwner_creditCard_information")
public class ParkingOwnerCreditCardInformation extends BaseCreditCardInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

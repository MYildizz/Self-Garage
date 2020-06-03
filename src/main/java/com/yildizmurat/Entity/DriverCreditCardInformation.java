package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="driver_creditCard_information")
public class DriverCreditCardInformation  extends BaseCreditCardInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

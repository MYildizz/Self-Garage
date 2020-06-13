package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rental_requests")
public class RentalRequests extends BaseUserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="district",length =30)
    private String district;
    @Column(name="province",length =30)
    private String province;
    @Column(name="address")
    private String address;
}

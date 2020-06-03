package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="rental_requests")
public class RentalRequests extends BaseUserInformation {

    @Column(name="district",length =30)
    private String district;
    @Column(name="province",length =30)
    private String province;
    @Column(name="address")
    private String address;
}

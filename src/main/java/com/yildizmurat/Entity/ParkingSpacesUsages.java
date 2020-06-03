package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="parking_spaces_usages")
public class ParkingSpacesUsages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nameID",length =20,unique = true)
    private String nameId;
    @Column(name="ownerId",length =20)
    private String ownerId;
    @Column(name="driverId",length =20)
    private String driverId;
    @Column(name="entry")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entry;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="exit")
    private Date exit;
    @Column(name="totalTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date totalTime;
    @Column(name="price")
    private Double price;
    @Column(name="district",length =30)
    private String district;
    @Column(name="province",length =30)
    private String province;
    @Column(name="address")
    private String address;
}

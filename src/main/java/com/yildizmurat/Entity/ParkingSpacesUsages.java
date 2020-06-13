package com.yildizmurat.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name="departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;

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

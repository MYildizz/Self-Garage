package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="parking_spaces")
public class ParkingSpaces {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nameID",length =20,unique = true)
    private String nameId;
    @Column(name="ownerId",length =20)
    private String ownerId;
    @Column(name="latitude",length =50)
    private String latitude;
    @Column(name="longitude",length =50)
    private String longitude;
    @Column(name="parkStatus",length =10)
    @Enumerated(EnumType.STRING)
    private ParkStatus parkStatus;
    @Column(name="district",length =30)
    private String district;
    @Column(name="province",length =30)
    private String province;
    @Column(name="address")
    private String address;

}

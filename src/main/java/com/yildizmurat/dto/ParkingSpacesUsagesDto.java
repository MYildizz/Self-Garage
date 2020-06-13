package com.yildizmurat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpacesUsagesDto {

    private String nameId;
    private String ownerId;
    private String driverId;
    private Date entry;
    private Date exit;
    private Date totalTime;
    private Double price;
    private String district;
    private String province;
    private String address;
}

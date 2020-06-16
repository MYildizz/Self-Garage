package com.yildizmurat.dto;

import com.yildizmurat.entity.ParkStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpacesDto {

    private String nameId;
    private String ownerId;
    private String latitude;
    private String longitude;
    private ParkStatus parkStatus;
    private String district;
    private String province;
    private String address;
}

package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingOwnerInformation;
import com.yildizmurat.dto.ParkingOwnerInformationDto;

public interface ParkingOwnerInformationService {

    ParkingOwnerInformationDto save(ParkingOwnerInformationDto parkingOwnerInformation);
    ParkingOwnerInformationDto getById(Long id);
    Boolean delete(ParkingOwnerInformationDto parkingOwnerInformation);
}

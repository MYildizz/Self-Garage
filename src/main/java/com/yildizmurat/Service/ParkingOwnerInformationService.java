package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingOwnerInformation;

public interface ParkingOwnerInformationService {

    ParkingOwnerInformation save(ParkingOwnerInformation parkingOwnerInformation);
    ParkingOwnerInformation getById(Long id);
    Boolean delete(ParkingOwnerInformation parkingOwnerInformation);
}

package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingSpacesUsages;

public interface ParkingSpacesUsagesService {

    ParkingSpacesUsages save(ParkingSpacesUsages parkingSpacesUsages);
    ParkingSpacesUsages getById(Long id);
    Boolean delete(ParkingSpacesUsages parkingSpacesUsages);

}

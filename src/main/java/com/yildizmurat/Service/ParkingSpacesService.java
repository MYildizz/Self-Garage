package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingSpaces;

public interface ParkingSpacesService {

    ParkingSpaces save(ParkingSpaces parkingSpaces);
    ParkingSpaces getById(Long id);
    Boolean delete(ParkingSpaces parkingSpaces);
}

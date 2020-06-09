package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingSpaces;
import com.yildizmurat.dto.ParkingSpacesDto;

public interface ParkingSpacesService {

    ParkingSpacesDto save(ParkingSpacesDto parkingSpaces);
    ParkingSpacesDto getById(Long id);
    Boolean delete(ParkingSpacesDto parkingSpaces);
}

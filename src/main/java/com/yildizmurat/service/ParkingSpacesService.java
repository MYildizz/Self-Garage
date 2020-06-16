package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesDto;

public interface ParkingSpacesService {

    ParkingSpacesDto save(ParkingSpacesDto parkingSpaces);
    ParkingSpacesDto getById(Long id);
    ParkingSpacesDto update(Long id, ParkingSpacesDto parkingSpacesDto);
    Boolean delete(Long id);
}

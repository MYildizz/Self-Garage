package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;

public interface ParkingSpacesUsagesService {

    ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsages);
    ParkingSpacesUsagesDto getById(Long id);
    ParkingSpacesUsagesDto update(Long id,  ParkingSpacesUsagesDto parkingSpacesUsagesDto);
    Boolean delete(Long id);;

}

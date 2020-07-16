package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;

import java.util.List;

public interface ParkingSpacesUsagesService {

    ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsages);
    ParkingSpacesUsagesDto getById(Long id);
    ParkingSpacesUsagesDto update(Long id,  ParkingSpacesUsagesDto parkingSpacesUsagesDto);
    List<ParkingSpacesUsagesDto> getByDriver(String driverId);
    List<ParkingSpacesUsagesDto> getByOwner(String ownerId);

    Boolean delete(Long id);

}

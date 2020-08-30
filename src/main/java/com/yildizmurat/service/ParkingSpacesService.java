package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.ParkingSpaces;

import java.util.List;

public interface ParkingSpacesService {

    ParkingSpacesDto save(ParkingSpacesDto parkingSpaces);
    ParkingSpacesDto getById(Long id);
    ParkingSpacesDto update(Long id, ParkingSpacesDto parkingSpacesDto);


    Boolean delete(Long id);
    Boolean updateByParkId(String parkId, ParkStatus parkStatus);
    List<ParkingSpacesDto> getAllByIdOwner(String IdOwner);
    List<ParkingSpacesDto> getAllByParkStatusOpen();
    List<ParkingSpacesDto> getAllByParkStatusBusy();
    Boolean updateParkStatus(String nameId,String ownerId,ParkStatus parkStatus);
}

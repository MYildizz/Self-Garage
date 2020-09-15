package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.UsageStatus;

import java.text.ParseException;
import java.util.List;

public interface ParkingSpacesUsagesService {

    ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsages) throws ParseException;
    ParkingSpacesUsagesDto getById(Long id);
    ParkingSpacesUsagesDto update(Long id,  ParkingSpacesUsagesDto parkingSpacesUsagesDto);
    List<ParkingSpacesUsagesDto> getByDriver(String driverId);
    List<ParkingSpacesUsagesDto> getByOwner(String ownerId);
    ParkingSpacesUsagesDto getByDriverAndUsageStatus(String Driver);
    Boolean updateByDriverAndUsageStatus(String Driver,UsageStatus usageStatus);
    Boolean delete(Long id);
    void check10minute(String driverId,String parkId);
}

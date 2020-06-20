package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;

public interface ParkingOwnerInformationService {

    ParkingOwnerInformationDto save(ParkingOwnerInformationDto parkingOwnerInformation);
    ParkingOwnerInformationDto getById(Long id);
    ParkingOwnerInformationDto update(Long id, ParkingOwnerInformationDto parkingOwnerInformationDto);
    Boolean delete(Long id);
    Boolean userExist(String userId);
    Boolean mailExist(String e_mail);
    Boolean checkPassword(String password);
}

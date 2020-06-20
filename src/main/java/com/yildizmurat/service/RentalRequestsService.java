package com.yildizmurat.service;

import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.dto.RentalRequestsDto;

public interface RentalRequestsService {

    RentalRequestsDto save(RentalRequestsDto rentalRequestsDto);
    RentalRequestsDto getById(Long id);
    RentalRequestsDto update(Long id, RentalRequestsDto RentalRequestsDto);
    Boolean delete(Long id);
    Boolean userExist(String userId);
    Boolean mailExist(String e_mail);
    Boolean checkPassword(String password);
}

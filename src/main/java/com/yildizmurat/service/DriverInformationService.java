package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.entity.DriverInformation;

import java.util.List;

public interface DriverInformationService {

    DriverInformationDto save(DriverInformationDto driverInformation);
    DriverInformationDto getById(Long id);
    DriverInformationDto update(Long id,DriverInformationDto driverInformationDto);
    Boolean delete(Long id);
    Boolean userExist(String userId);
    Boolean mailExist(String e_mail);
    Boolean checkPassword(String password);
    DriverInformationDto getByIdName(String IdName);

}

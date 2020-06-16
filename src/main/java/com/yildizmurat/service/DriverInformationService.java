package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;

public interface DriverInformationService {

    DriverInformationDto save(DriverInformationDto driverInformation);
    DriverInformationDto getById(Long id);
    DriverInformationDto update(Long id,DriverInformationDto driverInformationDto);
    Boolean delete(Long id);
}

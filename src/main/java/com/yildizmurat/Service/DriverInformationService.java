package com.yildizmurat.Service;

import com.yildizmurat.Entity.DriverInformation;
import com.yildizmurat.dto.DriverInformationDto;

public interface DriverInformationService {

    DriverInformationDto save(DriverInformationDto driverInformation);
    DriverInformationDto getById(Long id);
    Boolean delete(DriverInformationDto driverInformation);
}

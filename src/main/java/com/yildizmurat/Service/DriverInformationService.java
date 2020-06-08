package com.yildizmurat.Service;

import com.yildizmurat.Entity.DriverInformation;

public interface DriverInformationService {

    DriverInformation save(DriverInformation driverInformation);
    DriverInformation getById(Long id);
    Boolean delete(DriverInformation driverInformation);
}

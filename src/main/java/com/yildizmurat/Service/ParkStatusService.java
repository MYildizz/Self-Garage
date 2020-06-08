package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkStatus;

public interface ParkStatusService {
    ParkStatus save(ParkStatus parkStatus);
    ParkStatus getById(Long id);
    Boolean delete(ParkStatus parkStatus);

}

package com.yildizmurat.Service;

import com.yildizmurat.Entity.RentalRequests;
import com.yildizmurat.dto.RentalRequestsDto;

public interface RentalRequestsService {

    RentalRequestsDto save(RentalRequestsDto rentalRequests);
    RentalRequestsDto getById(Long id);
    Boolean delete(RentalRequestsDto rentalRequests);
}

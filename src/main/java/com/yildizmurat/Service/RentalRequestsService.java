package com.yildizmurat.Service;

import com.yildizmurat.Entity.RentalRequests;

public interface RentalRequestsService {

    RentalRequests save(RentalRequests rentalRequests);
    RentalRequests getById(Long id);
    Boolean delete(RentalRequests rentalRequests);
}

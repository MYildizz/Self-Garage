package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.RentalRequests;
import com.yildizmurat.Repository.RentalRequestsRepository;
import com.yildizmurat.Service.RentalRequestsService;
import org.springframework.stereotype.Service;

@Service
public class RentalRequestsImpl implements RentalRequestsService {

    private final RentalRequestsRepository rentalRequestsRepository;

    public RentalRequestsImpl(RentalRequestsRepository rentalRequestsRepository) {
        this.rentalRequestsRepository = rentalRequestsRepository;
    }

    @Override
    public RentalRequests save(RentalRequests rentalRequests) {
        return rentalRequestsRepository.save(rentalRequests);
    }

    @Override
    public RentalRequests getById(Long id) {
        return rentalRequestsRepository.getOne(id);
    }

    @Override
    public Boolean delete(RentalRequests rentalRequests) {
        rentalRequestsRepository.delete(rentalRequests);
        return Boolean.TRUE;
    }
}

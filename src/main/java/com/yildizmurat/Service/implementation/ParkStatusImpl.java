package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkStatus;
import com.yildizmurat.Repository.ParkStatusRepository;
import com.yildizmurat.Service.ParkStatusService;
import org.springframework.stereotype.Service;

@Service
public class ParkStatusImpl implements ParkStatusService {

    private final ParkStatusRepository parkStatusRepository;

    public ParkStatusImpl(ParkStatusRepository parkStatusRepository) {
        this.parkStatusRepository = parkStatusRepository;
    }

    @Override
    public ParkStatus save(ParkStatus parkStatus) {
        return parkStatusRepository.save(parkStatus);
    }

    @Override
    public ParkStatus getById(Long id) {
        return parkStatusRepository.getOne(id);
    }

    @Override
    public Boolean delete(ParkStatus parkStatus) {
        parkStatusRepository.delete(parkStatus);
        return Boolean.TRUE;
    }
}

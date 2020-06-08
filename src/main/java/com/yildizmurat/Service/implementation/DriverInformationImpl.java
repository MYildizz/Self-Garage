package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.DriverInformation;
import com.yildizmurat.Repository.DriverInformationRepository;
import com.yildizmurat.Service.DriverInformationService;
import org.springframework.stereotype.Service;

@Service
public class DriverInformationImpl implements DriverInformationService {

    private final DriverInformationRepository driverInformationRepository;

    public DriverInformationImpl(DriverInformationRepository driverInformationRepository){
        this.driverInformationRepository=driverInformationRepository;
    }

    @Override
    public DriverInformation save(DriverInformation driverInformation) {
        return driverInformationRepository.save(driverInformation);
    }

    @Override
    public DriverInformation getById(Long id) {
        return driverInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(DriverInformation driverInformation) {
        driverInformationRepository.delete(driverInformation);
        return Boolean.TRUE;
    }
}

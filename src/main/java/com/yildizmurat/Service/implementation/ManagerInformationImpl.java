package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ManagerInformation;
import com.yildizmurat.Repository.ManagerInformationRepository;
import com.yildizmurat.Service.ManagerInformationService;
import org.springframework.stereotype.Service;

@Service
public class ManagerInformationImpl implements ManagerInformationService {

    private final ManagerInformationRepository managerInformationRepository;

    public ManagerInformationImpl(ManagerInformationRepository managerInformationRepository) {
        this.managerInformationRepository = managerInformationRepository;
    }

    @Override
    public ManagerInformation save(ManagerInformation managerInformation) {
        return managerInformationRepository.save(managerInformation);
    }

    @Override
    public ManagerInformation getById(Long id) {
        return managerInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(ManagerInformation managerInformation) {

        managerInformationRepository.delete(managerInformation);
        return Boolean.TRUE;
    }
}

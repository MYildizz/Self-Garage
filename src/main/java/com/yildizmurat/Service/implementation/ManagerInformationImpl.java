package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ManagerInformation;
import com.yildizmurat.Entity.ManagerInformation;
import com.yildizmurat.Repository.ManagerInformationRepository;
import com.yildizmurat.Repository.ManagerInformationRepository;
import com.yildizmurat.Service.ManagerInformationService;
import com.yildizmurat.dto.ManagerInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ManagerInformationImpl implements ManagerInformationService {

    private final ManagerInformationRepository managerInformationRepository;
    private final ModelMapper modelMapper;

    public ManagerInformationImpl(ManagerInformationRepository managerInformationRepository, ModelMapper modelMapper) {
        this.managerInformationRepository = managerInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManagerInformationDto save(ManagerInformationDto managerInformationDto) {
        ManagerInformation managerInformation=  modelMapper.map(managerInformationDto,ManagerInformation.class);
        managerInformation= managerInformationRepository.save(managerInformation);

        return modelMapper.map(managerInformation,ManagerInformationDto.class);
    }

    @Override
    public ManagerInformationDto getById(Long id) {
        ManagerInformation managerInformation = managerInformationRepository.getOne(id);
        return modelMapper.map(managerInformation,ManagerInformationDto.class);
    }

    @Override
    public Boolean delete(ManagerInformationDto managerInformationDto) {
        ManagerInformation managerInformation=  modelMapper.map(managerInformationDto,ManagerInformation.class);
        managerInformationRepository.delete(managerInformation);
        return Boolean.TRUE;
    }
}

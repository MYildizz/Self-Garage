package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ManagerInformationDto;
import com.yildizmurat.entity.ManagerInformation;
import com.yildizmurat.entity.ManagerInformation;
import com.yildizmurat.repository.ManagerInformationRepository;
import com.yildizmurat.service.ManagerInformationService;
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
    public ManagerInformationDto update(Long id, ManagerInformationDto managerInformationDto) {

        ManagerInformation checkDriver = managerInformationRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        ManagerInformation managerInformation = modelMapper.map(managerInformationDto,ManagerInformation.class);
        managerInformation= managerInformationRepository.save(managerInformation);

        return modelMapper.map(managerInformation,ManagerInformationDto.class);

    }

    @Override
    public Boolean delete(Long id) {
        managerInformationRepository.deleteById(id);
        return Boolean.TRUE;
    }
}

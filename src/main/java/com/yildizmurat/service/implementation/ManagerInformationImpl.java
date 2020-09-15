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

        try{
            ManagerInformation managerInformation=  modelMapper.map(managerInformationDto,ManagerInformation.class);
            managerInformation= managerInformationRepository.save(managerInformation);
            return modelMapper.map(managerInformation,ManagerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ManagerInformationDto getById(Long id) {

        try{
            ManagerInformation managerInformation = managerInformationRepository.getOne(id);
            return modelMapper.map(managerInformation,ManagerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ManagerInformationDto update(Long id, ManagerInformationDto managerInformationDto) {

        try{
            ManagerInformation checkDriver = managerInformationRepository.getOne(id);

            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exit " + id);
            ManagerInformation managerInformation = modelMapper.map(managerInformationDto,ManagerInformation.class);
            managerInformation= managerInformationRepository.save(managerInformation);

            return modelMapper.map(managerInformation,ManagerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Boolean userExist(String userId) {
        try{
            return managerInformationRepository.existsManagerInformationByIdName(userId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean mailExist(String e_mail) {
        try{
            return managerInformationRepository.existsManagerInformationByIdName(e_mail);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean checkPassword(String password) {
        try{
            return managerInformationRepository.existsManagerInformationByPassword(password);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean delete(Long id) {
        try{
            managerInformationRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

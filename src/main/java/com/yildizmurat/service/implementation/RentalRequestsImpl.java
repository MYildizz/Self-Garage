package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.dto.RentalRequestsDto;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.RentalRequests;
import com.yildizmurat.entity.RentalRequests;
import com.yildizmurat.repository.RentalRequestsRepository;
import com.yildizmurat.service.RentalRequestsService;
import com.yildizmurat.dto.RentalRequestsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RentalRequestsImpl implements RentalRequestsService {

    private final RentalRequestsRepository rentalRequestsRepository;
    private final ModelMapper modelMapper;


    public RentalRequestsImpl(RentalRequestsRepository rentalRequestsRepository, ModelMapper modelMapper) {
        this.rentalRequestsRepository = rentalRequestsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RentalRequestsDto save(RentalRequestsDto rentalRequestsDto) {

        try{
            RentalRequests rentalRequests=  modelMapper.map(rentalRequestsDto,RentalRequests.class);
            rentalRequests= rentalRequestsRepository.save(rentalRequests);

            return modelMapper.map(rentalRequests,RentalRequestsDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public RentalRequestsDto getById(Long id) {

        try{
            RentalRequests rentalRequests = rentalRequestsRepository.getOne(id);
            return modelMapper.map(rentalRequests,RentalRequestsDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public RentalRequestsDto update(Long id, RentalRequestsDto rentalRequestsDto) {

        try{
            RentalRequests checkDriver = rentalRequestsRepository.getOne(id);

            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exit " + id);
            RentalRequests rentalRequests = modelMapper.map(rentalRequestsDto,RentalRequests.class);
            rentalRequests= rentalRequestsRepository.save(rentalRequests);

            return modelMapper.map(rentalRequests,RentalRequestsDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }


    @Override
    public Boolean delete(Long id) {

        try{
            rentalRequestsRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean userExist(String userId) {
        try{
            return rentalRequestsRepository.existsRentalRequestsByIdName(userId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean mailExist(String e_mail) {

        try{
            return rentalRequestsRepository.existsRentalRequestsByMail(e_mail);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean checkPassword(String password) {

        try{
            return rentalRequestsRepository.existsRentalRequestsByPassword(password);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

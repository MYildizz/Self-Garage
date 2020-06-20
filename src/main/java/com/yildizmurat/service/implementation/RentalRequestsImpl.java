package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.RentalRequestsDto;
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
        RentalRequests rentalRequests=  modelMapper.map(rentalRequestsDto,RentalRequests.class);
        rentalRequests= rentalRequestsRepository.save(rentalRequests);

        return modelMapper.map(rentalRequests,RentalRequestsDto.class);
    }

    @Override
    public RentalRequestsDto getById(Long id) {
        RentalRequests rentalRequests = rentalRequestsRepository.getOne(id);
        return modelMapper.map(rentalRequests,RentalRequestsDto.class);
    }

    @Override
    public RentalRequestsDto update(Long id, RentalRequestsDto rentalRequestsDto) {

        RentalRequests checkDriver = rentalRequestsRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        RentalRequests rentalRequests = modelMapper.map(rentalRequestsDto,RentalRequests.class);
        rentalRequests= rentalRequestsRepository.save(rentalRequests);

        return modelMapper.map(rentalRequests,RentalRequestsDto.class);

    }


    @Override
    public Boolean delete(Long id) {
        rentalRequestsRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean userExist(String userId) {
        return rentalRequestsRepository.existsRentalRequestsByIdName(userId);
    }

    @Override
    public Boolean mailExist(String e_mail) {
        return rentalRequestsRepository.existsRentalRequestsByMail(e_mail);
    }

    @Override
    public Boolean checkPassword(String password) {
        return rentalRequestsRepository.existsRentalRequestsByPassword(password);
    }
}

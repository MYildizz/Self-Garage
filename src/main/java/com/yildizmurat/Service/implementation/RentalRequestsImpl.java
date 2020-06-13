package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.RentalRequests;
import com.yildizmurat.Entity.RentalRequests;
import com.yildizmurat.Repository.RentalRequestsRepository;
import com.yildizmurat.Repository.RentalRequestsRepository;
import com.yildizmurat.Service.RentalRequestsService;
import com.yildizmurat.dto.RentalRequestsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RentalRequestsImpl implements RentalRequestsService {

    private final RentalRequestsRepository rentalRequestsRepository;
    private final ModelMapper modelMapper;

    public RentalRequestsImpl() {
        this.rentalRequestsRepository=null;
        this.modelMapper=null;
    }

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
    public Boolean delete(RentalRequestsDto rentalRequestsDto) {
        RentalRequests rentalRequests=  modelMapper.map(rentalRequestsDto,RentalRequests.class);
        rentalRequestsRepository.delete(rentalRequests);
        return Boolean.TRUE;
    }
}

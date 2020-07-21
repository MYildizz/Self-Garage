package com.yildizmurat.api;


import com.yildizmurat.dto.DriverCreditCardInformationDto;
import com.yildizmurat.service.implementation.DriverCreditCardInformationImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DriverCreditCardInformation")
public class DriverCreditCardInformationApi {

    private final DriverCreditCardInformationImpl driverCreditCardInformationImpl;


    public DriverCreditCardInformationApi(DriverCreditCardInformationImpl driverCreditCardInformationImpl) {
        this.driverCreditCardInformationImpl = driverCreditCardInformationImpl;
    }

    @GetMapping("/getParkingSpacesUsagesDriver/{id}")
    public List<DriverCreditCardInformationDto> getParkingSpacesUsagesDriver(@PathVariable("id") String id){
        List<DriverCreditCardInformationDto> info =driverCreditCardInformationImpl.getDriverCreditCardInformation(id);
        return info;
    }

}

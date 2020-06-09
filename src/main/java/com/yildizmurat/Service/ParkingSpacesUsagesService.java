package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingSpacesUsages;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;

public interface ParkingSpacesUsagesService {

    ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsages);
    ParkingSpacesUsagesDto getById(Long id);
    Boolean delete(ParkingSpacesUsagesDto parkingSpacesUsages);

}

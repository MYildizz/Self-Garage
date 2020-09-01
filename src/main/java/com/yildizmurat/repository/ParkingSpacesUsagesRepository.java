package com.yildizmurat.repository;


import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.UsageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ParkingSpacesUsagesRepository extends JpaRepository<ParkingSpacesUsages,Long> {

    List<ParkingSpacesUsages> getAllByDriver(String Driver);
    List<ParkingSpacesUsages> getAllByOwner(String Owner);
    ParkingSpacesUsages getByDriverAndDeparture(String Driver, String Departure);
    ParkingSpacesUsages getByDriverAndUsageStatus(String Driver,UsageStatus usageStatus);
}

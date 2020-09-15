package com.yildizmurat.repository;


import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.UsageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ParkingSpacesUsagesRepository extends JpaRepository<ParkingSpacesUsages,Long> {

    List<ParkingSpacesUsages> getAllByDriver(String Driver);
    List<ParkingSpacesUsages> getAllByOwner(String Owner);
    ParkingSpacesUsages getByDriverAndDeparture(String Driver, String Departure);
    ParkingSpacesUsages getByDriverAndUsageStatus(String Driver,UsageStatus usageStatus);
/*
    @Transactional
    @Modifying
    @Query(value= " CREATE EVENT dakikaKontrolu \n" +
            "ON SCHEDULE at CURRENT_TIMESTAMP + INTERVAL 1 MINUTE" +
            "" +
            "\n" +
            "UPDATE parking_spaces_usages SET status='FINISH' where driver= :driverId,status='REZERVE' ",nativeQuery=true)
    int chek10minute( @Param("driverId") String driverId);
    */
}

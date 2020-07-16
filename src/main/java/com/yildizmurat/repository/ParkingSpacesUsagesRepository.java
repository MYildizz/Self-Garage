package com.yildizmurat.repository;


import com.yildizmurat.entity.ParkingSpacesUsages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpacesUsagesRepository extends JpaRepository<ParkingSpacesUsages,Long> {

    List<ParkingSpacesUsages> getAllByDriver(String Driver);
    List<ParkingSpacesUsages> getAllByOwner(String Owner);

}

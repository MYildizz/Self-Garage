package com.yildizmurat.repository;

import com.yildizmurat.entity.ParkingSpacesUsages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpacesUsagesRepository extends JpaRepository<ParkingSpacesUsages,Long> {
}

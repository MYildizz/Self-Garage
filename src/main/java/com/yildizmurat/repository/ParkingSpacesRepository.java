package com.yildizmurat.repository;

import com.yildizmurat.entity.ParkingSpaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpacesRepository extends JpaRepository<ParkingSpaces,Long> {
}

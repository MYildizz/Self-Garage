package com.yildizmurat.Repository;

import com.yildizmurat.Entity.ParkingSpaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpacesRepository extends JpaRepository<ParkingSpaces,Long> {
}

package com.yildizmurat.repository;

import com.yildizmurat.entity.ParkingOwnerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOwnerInformationRepository extends JpaRepository<ParkingOwnerInformation,Long> {
}

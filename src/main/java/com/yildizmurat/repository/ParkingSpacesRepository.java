package com.yildizmurat.repository;

import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.ParkingSpaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpacesRepository extends JpaRepository<ParkingSpaces,Long> {

    ParkingSpaces getByIdName(String IdName);
    List<ParkingSpaces> getAllByIdOwner(String IdOwner);
    List<ParkingSpaces> getAllByParkStatus(ParkStatus ParkStatus);
    ParkingSpaces getByIdNameAndIdOwner(String IdName,String IdOwner);

}

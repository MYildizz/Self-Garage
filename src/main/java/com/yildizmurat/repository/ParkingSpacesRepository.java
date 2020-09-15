package com.yildizmurat.repository;

import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.ParkingSpaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParkingSpacesRepository extends JpaRepository<ParkingSpaces,Long> {

    ParkingSpaces getByIdName(String IdName);
    List<ParkingSpaces> getAllByIdOwner(String IdOwner);
    List<ParkingSpaces> getAllByParkStatus(ParkStatus ParkStatus);
    ParkingSpaces getByIdNameAndIdOwner(String IdName,String IdOwner);

    @Transactional
    @Modifying
    @Query(value= " CREATE EVENT güncelle\n" +
            "ON SCHEDULE at :date \n" +
            "DO\n" +
            "UPDATE parking_spaces SET park_status='OPEN' where nameid= :parkId ",nativeQuery=true)
    int createEventOpen(@Param("date") String date,@Param("parkId") String parkId);

    @Transactional
    @Modifying
    @Query(value= " CREATE EVENT güncelle\n" +
            "ON SCHEDULE at :date \n" +
            "DO\n" +
            "UPDATE parking_spaces SET park_status='CLOSED' where nameid= :parkId ",nativeQuery=true)
    int createEventClose(@Param("date") String date,@Param("parkId") String parkId);

}

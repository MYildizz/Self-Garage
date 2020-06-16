package com.yildizmurat.repository;

import com.yildizmurat.entity.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverInformationRepository extends JpaRepository<DriverInformation,Long>{

 //  List<DriverInformation> getDriverInformationByCarPlate(String CarPlate);

}

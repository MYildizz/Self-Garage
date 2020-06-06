package com.yildizmurat.Repository;

import com.yildizmurat.Entity.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverInformationRepository extends JpaRepository<DriverInformation,Long> {

    List<DriverInformation> getDriverInformationByCarPlate(String CarPlate);

}

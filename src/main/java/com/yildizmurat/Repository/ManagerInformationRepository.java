package com.yildizmurat.Repository;

import com.yildizmurat.Entity.ManagerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerInformationRepository extends JpaRepository<ManagerInformation,Long> {
}

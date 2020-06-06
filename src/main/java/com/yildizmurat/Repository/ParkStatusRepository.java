package com.yildizmurat.Repository;

import com.yildizmurat.Entity.ParkStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkStatusRepository extends JpaRepository<ParkStatus,Long> {
}

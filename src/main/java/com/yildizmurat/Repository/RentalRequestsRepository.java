package com.yildizmurat.Repository;

import com.yildizmurat.Entity.RentalRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRequestsRepository extends JpaRepository<RentalRequests,Long> {
}

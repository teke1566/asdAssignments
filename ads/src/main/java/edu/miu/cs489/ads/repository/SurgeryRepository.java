package edu.miu.cs489.ads.repository;

import edu.miu.cs489.ads.model.Address;
import edu.miu.cs489.ads.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery,Long> {

    List<Surgery> findByAddress(Address address);
}

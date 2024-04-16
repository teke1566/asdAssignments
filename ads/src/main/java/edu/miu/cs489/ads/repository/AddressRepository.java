package edu.miu.cs489.ads.repository;

import edu.miu.cs489.ads.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("SELECT DISTINCT a FROM Address a LEFT JOIN FETCH a.patient ORDER BY a.city ASC")
    List<Address> findAllWithPatientsOrderByCityAsc();
}

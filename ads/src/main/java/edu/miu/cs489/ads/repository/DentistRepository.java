package edu.miu.cs489.ads.repository;

import edu.miu.cs489.ads.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist,Long> {
}

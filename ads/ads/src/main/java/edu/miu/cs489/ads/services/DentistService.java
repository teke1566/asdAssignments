package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Appointment;
import edu.miu.cs489.ads.model.Dentist;
import edu.miu.cs489.ads.repository.DentistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DentistService {
    private final DentistRepository dentistRepository;
    @Autowired
    public DentistService(DentistRepository dentistRepository){
        this.dentistRepository=dentistRepository;
    }
    public List<Dentist> getAllDentist(){
        return dentistRepository.findAll();
    }
    public Optional<Dentist> getDentistById(Long id){
        return dentistRepository.findById(id);
    }
    public Dentist createDentist (Dentist dentist){
        return dentistRepository.save(dentist);
    }
    public Dentist updateDentist(Long id,Dentist updateDentist){
        Dentist dentist= dentistRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid dentist id" +id));
        dentist.setEmail(updateDentist.getEmail());
        dentist.setFirstName(updateDentist.getFirstName());
        dentist.setLastName(updateDentist.getLastName());
        dentist.setSpecialization(updateDentist.getSpecialization());
        return dentistRepository.save(dentist);
    }

  public void deleteDentist(Long id){
      dentistRepository.deleteById(id);
  }

}

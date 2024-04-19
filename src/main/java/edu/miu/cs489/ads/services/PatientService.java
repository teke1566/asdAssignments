package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Address;
import edu.miu.cs489.ads.model.Patient;
import edu.miu.cs489.ads.model.Surgery;
import edu.miu.cs489.ads.repository.AddressRepository;
import edu.miu.cs489.ads.repository.PatientRepository;
import edu.miu.cs489.ads.repository.SurgeryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository,  AddressRepository addressRepository){
        this.patientRepository=patientRepository;
        this.addressRepository = addressRepository;
    }
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
    @Transactional
    public void deletePatientById(Long id){
        patientRepository.deleteById(id);

    }

    public List<Patient> searchByFnameLname(String searchString){
        return patientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchString,searchString);
    }

    public Patient createPatient(Patient patient) {
        // Ensure that the address is in the managed state
        if (patient.getAddress() != null && patient.getAddress().getId() != null) {
            Address managedAddress = addressRepository.findById(patient.getAddress().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + patient.getAddress().getId()));
            patient.setAddress(managedAddress);
        }

        // Save the patient
        return patientRepository.save(patient);
    }
    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }
    public Patient patientUpdate(Long id,Patient updatePatient){
        Patient patients=patientRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found" +id));
        patients.setEmail(updatePatient.getEmail());
        patients.setFirstName(updatePatient.getFirstName());
        patients.setLastName(updatePatient.getLastName());
        patients.setDate_of_birth(updatePatient.getDate_of_birth());
        return patientRepository.save(patients);
    }
}

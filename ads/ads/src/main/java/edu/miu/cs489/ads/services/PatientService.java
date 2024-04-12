package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Patient;
import edu.miu.cs489.ads.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
    public void deletePatientById(Long id){
        patientRepository.deleteById(id);

    }
    public Patient createPatient(Patient patient){
        return  patientRepository.save(patient);
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

package edu.miu.cs489.ads.controller;

import edu.miu.cs489.ads.model.Patient;
import edu.miu.cs489.ads.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/patient/")
public class PatientController {
    private PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patientList=patientService.patientList();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Optional<Patient> patientById=patientService.getPatientById(id);
        return patientById.map(value->new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient patient1=patientService.createPatient(patient);
        return new ResponseEntity<>(patient1,HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatePatients){
        Patient updatePatient=patientService.patientUpdate(id,updatePatients);
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        patientService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatientByName(@PathVariable String searchString){
        List<Patient> patientList=patientService.searchByFnameLname(searchString);
        return new ResponseEntity<>(patientList,HttpStatus.OK);
    }
}

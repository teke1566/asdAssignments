package edu.miu.cs489.ads.controller;

import edu.miu.cs489.ads.model.Dentist;
import edu.miu.cs489.ads.services.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private final DentistService dentistService;
    public DentistController(DentistService dentistService){
        this.dentistService=dentistService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Dentist>> getAllDentist(){
        List<Dentist> dentists=dentistService.getAllDentist();
        return new ResponseEntity<>(dentists, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getDentistById(@PathVariable Long id){
        Optional<Dentist> dentist=dentistService.getDentistById(id);
        return  dentist.map(value->new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Dentist> createdentist(@RequestBody Dentist dentist){
        Dentist createdentist=dentistService.createDentist(dentist);
        return new ResponseEntity<>(createdentist,HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable Long id,@RequestBody Dentist dentistUpdate){
        Dentist updatedentist=dentistService.updateDentist(id,dentistUpdate);
        return new ResponseEntity<>(updatedentist,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Dentist> deleteDentist(@PathVariable Long id){
        dentistService.deleteDentist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

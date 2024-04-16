package edu.miu.cs489.ads.controller;

import edu.miu.cs489.ads.model.Patient;
import edu.miu.cs489.ads.model.Surgery;
import edu.miu.cs489.ads.services.SurgeryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surgery")
public class SurgeryController {
    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }
    @GetMapping
    public ResponseEntity<List<Surgery>> getAllSurgery(){
        List<Surgery> surgeryList=surgeryService.findAllSurgery();
        return new ResponseEntity<>(surgeryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Surgery> getById(@PathVariable Long id){
        Optional<Surgery> surgery=surgeryService.findById(id);
        return surgery.map(value->new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Surgery> createSurgery(@RequestBody Surgery surgery){
        Surgery surgery1=surgeryService.createSurgery(surgery);
        return new ResponseEntity<>(surgery,HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Surgery> updateSurgery(@PathVariable Long id, @RequestBody Surgery updateSurgery){
        Surgery surgery=surgeryService.updateSurgery(id,updateSurgery);
        return new ResponseEntity<>(surgery,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Surgery> deleteSurgery(@PathVariable Long id){
        surgeryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

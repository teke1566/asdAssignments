package edu.miu.cs489.ads.controller;

import edu.miu.cs489.ads.model.Address;
import edu.miu.cs489.ads.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> addresses=addressService.getAllAddress();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        Optional<Address> getAddress=addressService.getAddressById(id);
        return getAddress.map((value->new ResponseEntity<>(value,HttpStatus.OK))).orElseGet(()->new ResponseEntity<>(HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<Address> creatAddress(@RequestBody Address address){
        Address address1=addressService.createAddress(address);
        return  new ResponseEntity<>(address,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id,@RequestBody Address address){
        Address address1=addressService.updateAddress(id,address);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deletemapping (@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

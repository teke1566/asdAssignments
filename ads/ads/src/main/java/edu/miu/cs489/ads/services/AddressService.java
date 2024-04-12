package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Address;
import edu.miu.cs489.ads.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressService{
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
    public Optional<Address> getAddressById(Long id){
        return addressRepository.findById(id);
    }
    public Address createAddress(Address address){
        Address address1=addressRepository.save(address);
        return address;
    }
    public Address updateAddress(Long id,Address updateaddress){
        Address address1=addressRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not Found"+id));
        address1.setCity(updateaddress.getCity());
        address1.setStreet((updateaddress.getStreet()));
        address1.setZipCode(updateaddress.getZipCode());

        return addressRepository.save(address1);
    }
    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }
}
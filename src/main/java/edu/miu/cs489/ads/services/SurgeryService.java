package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Surgery;
import edu.miu.cs489.ads.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;
    public SurgeryService(SurgeryRepository surgeryRepository){
        this.surgeryRepository=surgeryRepository;
    }
    public List<Surgery> findAllSurgery(){
        return surgeryRepository.findAll();
    }
    public Optional<Surgery> findById(Long id){
        return  surgeryRepository.findById(id);
    }
    public  Surgery createSurgery(Surgery surgery){
        return surgeryRepository.save(surgery);
    }
    public Surgery updateSurgery(Long id ,Surgery surgery){
        Surgery surgery1=surgeryRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not Found" +id));
        surgery1.setName(surgery.getName());
        surgery1.setAddress(surgery.getAddress());
        surgery1.setAppointmentList(surgery.getAppointmentList());
        return surgeryRepository.save(surgery1);
    }
    public void deleteById(Long id){
        surgeryRepository.deleteById(id);

    }

}

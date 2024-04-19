package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.Appointment;
import edu.miu.cs489.ads.model.Dentist;
import edu.miu.cs489.ads.repository.AppointmentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));

        appointment.setPatient(updatedAppointment.getPatient());
        appointment.setDentist(updatedAppointment.getDentist());
        appointment.setSurgery(updatedAppointment.getSurgery());
        appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        appointment.setStatus(updatedAppointment.getStatus());

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    @Transactional
    public void saveDentistAndAppointment(Dentist dentist, Appointment appointment) {
        Dentist persistedDentist = entityManager.merge(dentist);
        appointment.setDentist(persistedDentist);

        entityManager.persist(appointment);
    }
}

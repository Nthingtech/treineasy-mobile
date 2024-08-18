package br.com.nthing.prescription;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;


@ApplicationScoped
public class PrescriptionService implements IPrescriptionService {

    @Inject
    PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    public Prescription createPrescription(Prescription newPrescription) {
            prescriptionRepository.persist(newPrescription);
            return newPrescription;
    }
    @Override
    public void updatePrescription(Prescription prescription) {
        prescriptionRepository.updatePrescritption(prescription);
    }


    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }


    @Override
    public List<Prescription> listAll() {
        return prescriptionRepository.listAll();
    }

    @Override
    public List<Prescription> searchByKeywordPrescription(String keypresc) {
        return prescriptionRepository.findKeywordPrescription(keypresc);
    }


}

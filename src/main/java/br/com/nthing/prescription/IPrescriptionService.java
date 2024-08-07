package br.com.nthing.prescription;

import java.util.List;

public interface IPrescriptionService {

    Prescription findById(Long id);

    Prescription createPrescription(Prescription newPrescription);

    void updatePrescription(Prescription prescription);

    void deletePrescription(Long idSequence);

    List<Prescription> listAll();


    List<Prescription> searchByKeywordPrescription(String keypresc);

}

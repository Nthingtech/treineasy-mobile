package br.com.nthing.prescription;

import java.util.List;

public interface IPrescriptionService {

    Prescription findById(Long id);

    Prescription createPrescription(Prescription newPrescription);

    void updatePrescription(Prescription prescription);

    void deletePrescription(Long idSequence);

    void totalPrescription(Prescription prescription);

    List<Prescription> listAll();
}

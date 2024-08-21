package br.com.nthing.prescription;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PrescriptionMapper {

    Prescription toEntityPrescription(PrescriptionDTO prescriptionDTO);

    PrescriptionDTO toDtoPrescription(Prescription prescription);

    List<Prescription> toEntityListPrescription(List<PrescriptionDTO> prescriptionDTOList);

    List<PrescriptionDTO> toDtoListPrescription(List<Prescription> prescription);


}

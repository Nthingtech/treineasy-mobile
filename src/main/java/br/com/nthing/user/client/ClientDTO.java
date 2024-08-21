package br.com.nthing.user.client;

import br.com.nthing.prescription.PrescriptionDTO;
import br.com.nthing.user.AddressDTO;
import br.com.nthing.user.Gender;
import br.com.nthing.user.PhoneDTO;
import br.com.nthing.user.UserNameDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record ClientDTO (Long id, String instagram, UserNameDTO name, LocalDate birthday, Integer age, String cpf, AddressDTO address, PhoneDTO phone,
                         String email, Gender gender, LocalDateTime dtRegister, Set<PrescriptionDTO> prescriptions) {


}

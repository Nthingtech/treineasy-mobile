package br.com.nthing.prescription;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrescriptionRepository implements PanacheRepository<Prescription> {
}

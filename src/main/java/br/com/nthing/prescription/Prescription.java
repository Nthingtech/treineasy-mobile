package br.com.nthing.prescription;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prescription")
    private Long id;

    @Column(name = "name_prescription", length = 20, nullable = false)
    private String namePrescription;

    @Column(name = "conclude_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
    private LocalDateTime concludedAt;

    @CreationTimestamp
    @Column(name = "start_prescription", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
    private LocalDateTime startPrescription;

    @Column(name = "total_prescription", nullable = false)
    private Integer totalPrescription;

    @Column(name ="completed_workouts" )
    private Integer completedWorkouts;

    public Prescription() {
    }

    public Prescription(Long id, String namePrescription, LocalDateTime concludedAt, LocalDateTime startPrescription, Integer totalPrescription, Integer completedWorkouts) {
        this.id = id;
        this.namePrescription = namePrescription;
        this.concludedAt = concludedAt;
        this.startPrescription = startPrescription;
        this.totalPrescription = totalPrescription;
        this.completedWorkouts = completedWorkouts;
    }
}

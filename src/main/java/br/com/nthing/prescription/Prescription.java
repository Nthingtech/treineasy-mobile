package br.com.nthing.prescription;

import br.com.nthing.training.Training;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tbl_prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prescription")
    private Long id;

    @Column(name = "name_prescription", length = 20)
    private String namePrescription;

    @Column(name = "conclude_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime concludedAt;

    @CreationTimestamp
    @Column(name = "start_prescription", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime startPrescription;

    @UpdateTimestamp
    @Column(name = "update_prescription", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updatePrescription;//TODO DELETE

    @Column(name = "total_prescription")
    private Integer totalPrescription;

    @Column(name ="completed_workouts" )
    private Integer completedWorkouts;


    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("prescription")
    private Set<Training> trainings = new HashSet<>();


    public Prescription() {

    }

    public Prescription(Long id, String namePrescription, LocalDateTime concludedAt, LocalDateTime startPrescription, LocalDateTime updatePrescription, Integer totalPrescription, Integer completedWorkouts) {
        this.id = id;
        this.namePrescription = namePrescription;
        this.concludedAt = concludedAt;
        this.startPrescription = startPrescription;
        this.updatePrescription = updatePrescription;
        this.totalPrescription = totalPrescription;
        this.completedWorkouts = completedWorkouts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePrescription() {
        return namePrescription;
    }

    public void setNamePrescription(String namePrescription) {
        this.namePrescription = namePrescription;
    }

    public LocalDateTime getConcludedAt() {
        return concludedAt;
    }

    public void setConcludedAt(LocalDateTime concludedAt) {
        this.concludedAt = concludedAt;
    }

    public LocalDateTime getStartPrescription() {
        return startPrescription;
    }

    public void setStartPrescription(LocalDateTime startPrescription) {
        this.startPrescription = startPrescription;
    }

    public LocalDateTime getUpdatePrescription() {
        return updatePrescription;
    }

    public void setUpdatePrescription(LocalDateTime updatePrescription) {
        this.updatePrescription = updatePrescription;
    }

    public Integer getTotalPrescription() {
        return totalPrescription = trainings.stream()
                .mapToInt(Training::getTotalTraining)
                .sum();
    }

    public void setTotalPrescription(Integer totalPrescription) {
        this.totalPrescription = totalPrescription;
    }

    public Integer getCompletedWorkouts() {
        return completedWorkouts;
    }

    public void setCompletedWorkouts(Integer completedWorkouts) {
        this.completedWorkouts = completedWorkouts;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", namePrescription='" + namePrescription + '\'' +
                ", concludedAt=" + concludedAt +
                ", startPrescription=" + startPrescription +
                ", updatePrescription=" + updatePrescription +
                ", totalPrescription=" + totalPrescription +
                ", completedWorkouts=" + completedWorkouts +
                ", trainings=" + trainings +
                '}';
    }
}

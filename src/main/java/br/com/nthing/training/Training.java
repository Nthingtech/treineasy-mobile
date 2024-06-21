package br.com.nthing.training;

import br.com.nthing.item.ExerciseItem;
import br.com.nthing.prescription.Prescription;
import br.com.nthing.training.enums.TrainingStatus;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "tbl_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_training")
    private Long id;

    @Column(name = "name_training", length = 30)
    private String nameTraining;

    @Column(name = "total_training")
    private Integer totalTraining;

    @Column(name = "dt_concluded", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime concludedAt;

    @Column(name = "status")
    private TrainingStatus status;


    @Column(name = "tt_concluded_training")
    private Integer totalConcludedTraining;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonbTransient
    private List<ExerciseItem> itens;

    @ManyToOne
    @JoinColumn(name = "tbl_prescription_id_prescription")
    private Prescription prescription;


    public Training() {
    }

    public Training(Long id, String nameTraining, Integer totalTraining, LocalDateTime concludedAt
            , TrainingStatus status, Integer totalConcludedTraining, Prescription prescription) {
        this.id = id;
        this.nameTraining = nameTraining;
        this.totalTraining = totalTraining;
        this.concludedAt = concludedAt;
        this.status = status;
        this.totalConcludedTraining = totalConcludedTraining;
        this.prescription = prescription;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTraining() {
        return nameTraining;
    }

    public void setNameTraining(String nameTraining) {
        this.nameTraining = nameTraining;
    }

    public Integer getTotalTraining() {
        return totalTraining;
    }

    public void setTotalTraining(Integer totalTraining) {
        this.totalTraining = totalTraining;
    }

    public LocalDateTime getConcludedAt() {
        return concludedAt;
    }

    public void setConcludedAt(LocalDateTime concludedAt) {
        this.concludedAt = concludedAt;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }

    public Integer getTotalConcludedTraining() {
        return totalConcludedTraining;
    }

    public void setTotalConcludedTraining(Integer totalConcludedTraining) {
        this.totalConcludedTraining = totalConcludedTraining;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public List<ExerciseItem> getItens() {
        return itens;
    }

    public void setItens(List<ExerciseItem> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", nameTraining='" + nameTraining + '\'' +
                ", totalTraining=" + totalTraining +
                ", concludedAt=" + concludedAt +
                ", status=" + status +
                ", totalConcludedTraining=" + totalConcludedTraining +
                ", itens=" + itens +
                '}';
    }
}

package br.com.nthing.training;

import br.com.nthing.training.enums.TrainingStatus;
import br.com.nthing.item.ExerciseItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "tbl_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_training")
    private Long id;

    @Column(name = "name_training", length = 30, nullable = false)
    private String nameTraining;

    @Column(name = "total_training", nullable = false)
    private Long totalTraining;

    @Column(name = "dt_concluded", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
    private LocalDate concludedAt;

    @Column(name = "status")
    private TrainingStatus status;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<ExerciseItem> itens;


    public Training() {
    }

    public Training(Long id, String nameTraining, Long totalTraining, LocalDate concludedAt, TrainingStatus status) {
        this.id = id;
        this.nameTraining = nameTraining;
        this.totalTraining = totalTraining;
        this.concludedAt = concludedAt;
        this.status = status;
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

    public Long getTotalTraining() {
        return totalTraining;
    }

    public void setTotalTraining(Long totalTraining) {
        this.totalTraining = totalTraining;
    }

    public LocalDate getConcludedAt() {
        return concludedAt;
    }

    public void setConcludedAt(LocalDate concludedAt) {
        this.concludedAt = concludedAt;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
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
                ", itens=" + itens +
                '}';
    }


}

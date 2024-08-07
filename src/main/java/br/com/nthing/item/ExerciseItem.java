package br.com.nthing.item;

import br.com.nthing.exercise.Exercise;
import br.com.nthing.training.Training;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tbl_exerciseitem")
public class ExerciseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sequence")
    private Long idSequence;

    @Column(name = "series_number")
    private Integer seriesNumber;

    @Column(name = "measurement_type")
    private Integer measurementType;

    @Column(name = "rest")
    private Integer rest;

    @Column(name = "concluded")
    private Integer concluded;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "tbl_training_id_training")
    @JsonIgnoreProperties("itens")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "tbl_exercise_id_exercise")
    private Exercise exercise;

    public ExerciseItem() {
    }

    public ExerciseItem(Long idSequence, Integer seriesNumber, Integer measurementType, Integer rest,
                        Integer concluded, String note, Training training, Exercise exercise) {
        this.idSequence = idSequence;
        this.seriesNumber = seriesNumber;
        this.measurementType = measurementType;
        this.rest = rest;
        this.concluded = concluded;
        this.note = note;
        this.training = training;
        this.exercise = exercise;
    }

    public Long getIdSequence() {
        return idSequence;
    }

    public void setIdSequence(Long idSequence) {
        this.idSequence = idSequence;
    }

    public Integer getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(Integer seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public Integer getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Integer measurementType) {
        this.measurementType = measurementType;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    public Integer getConcluded() {
        return concluded;
    }

    public void setConcluded(Integer concluded) {
        this.concluded = concluded;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseItem that = (ExerciseItem) o;
        return Objects.equals(idSequence, that.idSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSequence);
    }

    @Override
    public String toString() {
        return "ExerciseItem{" +
                "idSequence=" + idSequence +
                ", seriesNumber=" + seriesNumber +
                ", measurementType=" + measurementType +
                ", rest=" + rest +
                ", concluded=" + concluded +
                ", note='" + note + '\'' +
                ", training=" + training +
                ", exercise=" + exercise +
                '}';
    }
}

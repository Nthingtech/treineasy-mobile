package br.com.nthing.exercise;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table( name = "tbl_exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_exercise")
    private Long id;

    @Column(name = "name_exercise", length = 45, nullable = false)
    private String exercise;

    @Column(name = "machine_number", nullable = false)
    private Long  machineNumber;

    @Column(name = "muscle_group", length = 20, nullable = false)
    private String muscleGroup;

    @Column(name = "video_uri")
    private String videoUri;


    public Exercise() {
    }

    public Exercise(Long id, String exercise, Long machineNumber, String muscleGroup, String videoUri) {
        this.id = id;
        this.exercise = exercise;
        this.machineNumber = machineNumber;
        this.muscleGroup = muscleGroup;
        this.videoUri = videoUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Long getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(Long machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", exercise='" + exercise + '\'' +
                ", machineNumber=" + machineNumber +
                ", muscleGroup='" + muscleGroup + '\'' +
                ", videoUri='" + videoUri + '\'' +
                '}';
    }
}

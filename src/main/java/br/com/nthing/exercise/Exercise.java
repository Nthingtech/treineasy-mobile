package br.com.nthing.exercise;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Exercise extends PanacheEntity {
    /** PanacheEntity add Id */
    private String exercise;
    private Long  machineNumber;
    private String muscleGroup;
    private String videoUri;


    public Exercise() {
    }

    public Exercise(String exercise, Long machineNumber, String muscleGroup, String videoUri) {
        this.exercise = exercise;
        this.machineNumber = machineNumber;
        this.muscleGroup = muscleGroup;
        this.videoUri = videoUri;
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
        Exercise exercise1 = (Exercise) o;
        return Objects.equals(exercise, exercise1.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exercise);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exercise='" + exercise + '\'' +
                ", machineNumber=" + machineNumber +
                ", muscleGroup='" + muscleGroup + '\'' +
                ", videoUri='" + videoUri + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}

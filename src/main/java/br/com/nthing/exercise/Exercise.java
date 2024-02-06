package br.com.nthing.exercise;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table( name = "tbl_exercise")
@ApplicationScoped
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_exercise")
    private Long id;

    @Column(name = "name_exercise", length = 45)
    private String exercise;

    @Column(name = "machine_number")
    private Integer  machineNumber;

    @Column(name = "muscle_group", length = 20)
    private String muscleGroup;

    @Column(name = "video_uri")
    private String videoUri;

    public Exercise() {
    }

    public Exercise(Long id, String exercise, Integer machineNumber, String muscleGroup, String videoUri) {
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

    public Integer getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(Integer machineNumber) {
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

    /*public List<ExerciseItem> getItens() {
        return itens;
    }

    public void setItens(List<ExerciseItem> itens) {
        this.itens = itens;
    }*/

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

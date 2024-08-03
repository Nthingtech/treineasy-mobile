package br.com.nthing;

import java.util.Objects;

public class Pessoa {
    private Long id;
    private String name;
    private Integer amountTraining;
    private Integer sumListTrainingAmount;

    public Pessoa(Long id, String name, Integer amountTraining, Integer sumListTrainingAmount) {
        this.id = id;
        this.name = name;
        this.amountTraining = amountTraining;
        this.sumListTrainingAmount = sumListTrainingAmount;
    }

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountTraining() {
        return amountTraining;
    }

    public void setAmountTraining(Integer amountTraining) {
        this.amountTraining = amountTraining;
    }

    public Integer getSumListTrainingAmount() {
        return sumListTrainingAmount;
    }

    public void setSumListTrainingAmount(Integer sumListTrainingAmount) {
        this.sumListTrainingAmount = sumListTrainingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(name, pessoa.name) && Objects.equals(amountTraining, pessoa.amountTraining) && Objects.equals(sumListTrainingAmount, pessoa.sumListTrainingAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountTraining, sumListTrainingAmount);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountTraining=" + amountTraining +
                ", sumListTrainingAmount=" + sumListTrainingAmount +
                '}';
    }
}

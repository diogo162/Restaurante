package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;


@Entity
public class Entregador extends Funcionario{
    @NotNull
    private int cnh;
    @NotNull
    private String veiculo;
    @NotNull
    private float horas;
    @NotNull
    private float salario_hora;

    public Entregador(String cpf, String nome) {
        super(cpf, nome);
    }

    public Entregador() {

    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public float getSalario_hora() {
        return salario_hora;
    }

    public void setSalario_hora(float salario_hora) {
        this.salario_hora = salario_hora;
    }
}

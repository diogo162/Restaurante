package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{
    @NotNull
    private String cargo;
    private float salario;

    public Funcionario(String cpf, String nome, int telefone_celular, float salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone_celular = telefone_celular;
        this.salario = salario;
    }

    public Funcionario() {
        super();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}

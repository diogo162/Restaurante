package org.example;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
@Entity
public class Pessoa {
    @NotNull
    private String nome;
    @Id
    @NotNull
    private String cpf;
    private int telefone_celular;
    @NotNull
    private String endereco;


    public Pessoa() {
        //O Hibernate necessita de um construtor sem parametros
    }


    public Pessoa(String cpf, String nome) {
        super();
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}

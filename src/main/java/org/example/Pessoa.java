package org.example;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.List;

import javax.persistence.*;

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


    @ManyToMany
    @JoinTable(name = "usuario_has_endereco", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
            @JoinColumn(name = "endereco_id") })
    private Endereco[] enderecos;


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

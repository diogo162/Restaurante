package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity
public class Gerente extends Funcionario{
    @NotNull
    private String senha;

    public Gerente(String cpf, String nome) {
        super(cpf, nome);
    }

    public Gerente() {
        super();
    }


    public boolean verificarSenha(String senha) {
        if (this.senha == senha){
            return true;
        }else{
            return false;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

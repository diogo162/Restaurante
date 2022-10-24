package org.example;


import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    private int id_endereco;
    private String bairro;
    private String rua;
    private String numero;
    private String apnum;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getApnum() {
        return apnum;
    }

    public void setApnum(String Apnum) {
        this.apnum = apnum;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
}

package model;

import java.sql.Date;
import java.sql.Timestamp;

public class ClientModel {

    private Integer id;
    private String nome;
    private String email;
    private Date dataNasc;
    private String rg;
    private String cpf;
    private String celular;
    private String nomeMae;
    private String nomePai;

    private Timestamp dataCadastrada;

    public ClientModel() {
    }

    public ClientModel(String nome, String email, Date dataNasc, String rg, String cpf, String celular, String nomeMae, String nomePai) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.cpf = cpf;
        this.celular = celular;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

    public ClientModel(String nome, String email, Date dataNasc, String rg, String cpf, String celular, String nomeMae, String nomePai, Timestamp dataCadastrada) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.cpf = cpf;
        this.celular = celular;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.dataCadastrada = dataCadastrada;
    }

    public ClientModel(Integer id, String nome, String email, Date dataNasc, String rg, String cpf, String celular, String nomeMae, String nomePai, Timestamp dataCadastrada) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.cpf = cpf;
        this.celular = celular;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.dataCadastrada = dataCadastrada;
    }

    public Timestamp getDataCadastrada() {
        return dataCadastrada;
    }

    public void setDataCadastrada(Timestamp dataCadastrada) {
        this.dataCadastrada = dataCadastrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}

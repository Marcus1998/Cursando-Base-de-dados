/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roberta
 */
@Entity
public class Instituicao extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="razao_social", nullable=false, columnDefinition = "text", length = 40)
    private String razaoSocial;
    
    @Column(name="nome_fantazia", nullable=false, columnDefinition = "text", length = 100)
    private String nomeFantazia;
    
    @Column(name="cnpj", nullable=false, columnDefinition = "text", length = 18)
    private String cnpj;
    
    @Column(name="data_criaçao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="email", nullable=false, columnDefinition = "text", length = 100)
    private String email;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="id_instituicao")
    private List<Curso> cursos = new LinkedList<>();
    
    public Instituicao() {
    }

    public Instituicao(String razaoSocial, String nomeFantazia, String cnpj, Date dataCriacao, String email, String nome, String senha) {
        super(nome, senha);
        this.razaoSocial = razaoSocial;
        this.nomeFantazia = nomeFantazia;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.email = email;
    }

    public Instituicao(String razaoSocial, String nomeFantazia, String cnpj, Date dataCriacao, String email, Long id, String nome, String senha, List<Curso> cursos) {
        super(id, nome, senha);
        this.razaoSocial = razaoSocial;
        this.nomeFantazia = nomeFantazia;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.email = email;
        this.cursos=cursos;
    }

    public Instituicao(String razaoSocial, String nomeFantazia, String cnpj, Date dataCriacao, String email, String nome, String senha, List<Curso> cursos) {
        super(nome, senha);
        this.razaoSocial = razaoSocial;
        this.nomeFantazia = nomeFantazia;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.email = email;
        this.cursos=cursos;
    }
    
    
    
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantazia() {
        return nomeFantazia;
    }

    public void setNomeFantazia(String nomeFantazia) {
        this.nomeFantazia = nomeFantazia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    @Override
    public String toString() {
        return "Instituicao{" + "razaoSocial=" + razaoSocial + ", nomeFantazia=" + nomeFantazia + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao + ", email=" + email + '}';
    }

    
    
}

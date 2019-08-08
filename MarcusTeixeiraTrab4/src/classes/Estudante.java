/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Estudante extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name="nome_completo", nullable=false, columnDefinition = "text", length = 60)
    private String nomeCompleto;
    
    @Column(name="cpf", nullable=false, columnDefinition = "text", length = 14)
    private String cpf;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name="email", nullable=false, columnDefinition = "text", length = 100)
    private String email;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable( name="matricula_estudante_curso",joinColumns={@JoinColumn(name="id_Estudante")}, inverseJoinColumns={@JoinColumn(name="id_curso")})
    private List<Curso> cursos;

    public Estudante() {
    }

    public Estudante(String nomeCompleto, String cpf, Date dataNascimento, String email, String nome, String senha) {
        super(nome, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Estudante(String nomeCompleto, String cpf, Date dataNascimento, String email, Long id, String nome, String senha) {
        super(id, nome, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Estudante(String nomeCompleto, String cpf, Date dataNascimento, String email, List<Curso> cursos, Long id, String nome, String senha) {
        super(id, nome, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cursos = cursos;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return "Estudante{" + "nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + '}';
    }

    
    
}

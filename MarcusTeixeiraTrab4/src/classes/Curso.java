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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roberta
 */
@Entity
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nome_curso", nullable=false, columnDefinition = "text", length = 20)
    private String nome;
    
    @Column(name="url_imagem", nullable=false, columnDefinition = "text", length = 255)
    private String imagem;
    
    //Eu fiz a ecolha da classe Date, porque não será feita a manipulação da data nesse atributo
    //e foi escolhido o TIMESTAMP para que os usuarios saibam exatamente a data e o horário em
    //que foram feitas atualizações permitindo que saibam se tem algo de diferente no curso
    //que precisam fazer ou até mesmo se algum erro aontado por eles foi arrumado
    @Column(name="ultima_atualizacao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao;
    
    @Column(name="condicao_curso", nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name="descricao", nullable=false, columnDefinition = "text", length = 255)
    private String descricao;
    
    @Column(name="conteudo_programatico", nullable=false, columnDefinition = "text", length = 255)
    private String conteudoProgramatico;
    
    @Column(name="horas", nullable=false)
    private int horas;
    
    @OneToMany (mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="id_aula")
    private List<Aula> aulas = new LinkedList<>();
    
    @ManyToMany(mappedBy="cursos")
    private List<Estudante> estudantes;

    public Curso() {
    }
    
    public Curso(String nome, String imagem, Date ultimaAtualizacao, Status status, String descricao, String conteudoProgramatico, int horas) {
        this.nome = nome;
        this.imagem = imagem;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.status = status;
        this.descricao = descricao;
        this.conteudoProgramatico = conteudoProgramatico;
        this.horas = horas;
    }

    public Curso(Long id, String nome, String imagem, Date ultimaAtualizacao, Status status, String descricao, String conteudoProgramatico, int horas) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.status = status;
        this.descricao = descricao;
        this.conteudoProgramatico = conteudoProgramatico;
        this.horas = horas;
    }

    public Curso(String nome, String imagem, Date ultimaAtualizacao, Status status, String descricao, String conteudoProgramatico, int horas, List<Aula> aulas) {
        this.nome = nome;
        this.imagem = imagem;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.status = status;
        this.descricao = descricao;
        this.conteudoProgramatico = conteudoProgramatico;
        this.horas = horas;
        this.aulas = aulas;
    }
    
    public Curso(Long id,String nome, String imagem, Date ultimaAtualizacao, Status status, String descricao, String conteudoProgramatico, int horas, List<Aula> aulas) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.status = status;
        this.descricao = descricao;
        this.conteudoProgramatico = conteudoProgramatico;
        this.horas = horas;
        this.aulas = aulas;
    }

    public Curso(Long id, String nome, Date ultimaAtualizacao, Status status, String descricao, String conteudoProgramatico, int horas, List<Aula> aulas, List<Estudante> estudantes) {
        this.id = id;
        this.nome = nome;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.status = status;
        this.descricao = descricao;
        this.conteudoProgramatico = conteudoProgramatico;
        this.horas = horas;
        this.aulas = aulas;
        this.estudantes = estudantes;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudoProgramatico() {
        return conteudoProgramatico;
    }

    public void setConteudoProgramatico(String conteudoProgramatico) {
        this.conteudoProgramatico = conteudoProgramatico;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    

    

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", imagem=" + imagem + ", ultimaAtualizacao=" + ultimaAtualizacao + ", status=" + status + ", descricao=" + descricao + ", conteudoProgramatico=" + conteudoProgramatico + ", horas=" + horas + '}';
    }

}

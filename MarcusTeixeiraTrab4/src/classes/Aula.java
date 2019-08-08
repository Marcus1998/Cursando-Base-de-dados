/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Roberta
 */
@Entity
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titulo", nullable=false, columnDefinition = "text", length = 60)
    private String titulo;
    @Column(name="Url_video", nullable=false, columnDefinition = "text", length = 150)
    private String urlVideo;
    @Column(name="ordem", nullable=false)
    private int ordem;
    
    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso curso;

    @OneToOne (cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn (name="id_exercicio")
    private Exercicio exercicio;

    public Aula() {
    }

    public Aula(String titulo, String urlVideo, int ordem) {
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
    }

    public Aula(Long id, String titulo, String urlVideo, int ordem) {
        this.id = id;
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
    }

    public Aula(Long id, String titulo, String urlVideo, int ordem, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
        this.curso = curso;
    }

    public Aula(String titulo, String urlVideo, int ordem, Curso curso) {
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
        this.curso = curso;
    }

    public Aula(String titulo, String urlVideo, int ordem, Curso curso, Exercicio exercicio) {
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
        this.curso = curso;
        this.exercicio = exercicio;
    }

    public Aula(Long id, String titulo, String urlVideo, int ordem, Curso curso, Exercicio exercicio) {
        this.id = id;
        this.titulo = titulo;
        this.urlVideo = urlVideo;
        this.ordem = ordem;
        this.curso = curso;
        this.exercicio = exercicio;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", titulo=" + titulo + ", urlVideo=" + urlVideo + ", ordem=" + ordem + ", curso=" + curso + ", exercicio=" + exercicio + '}';
    }

    
    
}

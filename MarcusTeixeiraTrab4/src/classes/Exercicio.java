/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_exercicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="url_imagem", nullable=false, columnDefinition = "text", length = 150)
    private String imagem;
    
    @Column(name="pergunta", nullable=false, columnDefinition = "text", length = 100)
    private String pergunta;
    
    @Column(name="resposta_certa", nullable=false, columnDefinition = "text", length = 200)
    private String certa;
    @Column(name="alternativa1", nullable=false, columnDefinition = "text", length = 200)
    private String alternativa1;
    @Column(name="alternativa2", nullable=false, columnDefinition = "text", length = 200)
    private String alternativa2;
    @Column(name="alternativa3", nullable=false, columnDefinition = "text", length = 200)
    private String alternativa3;
    @Column(name="alternativa4", nullable=false, columnDefinition = "text", length = 200)
    private String alternativa4;

    public Exercicio() {
    }

    public Exercicio(Long id, String imagem, String pergunta, String certa, String alternativa1, String alternativa2, String alternativa3, String alternativa4) {
        this.id = id;
        this.imagem = imagem;
        this.pergunta = pergunta;
        this.certa = certa;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
    }

    public Exercicio(String imagem, String pergunta, String certa, String alternativa1, String alternativa2, String alternativa3, String alternativa4) {
        this.imagem = imagem;
        this.pergunta = pergunta;
        this.certa = certa;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getCerta() {
        return certa;
    }

    public void setCerta(String certa) {
        this.certa = certa;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
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
        if (!(object instanceof Exercicio)) {
            return false;
        }
        Exercicio other = (Exercicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exercicio{" + "id=" + id + ", imagem=" + imagem + ", pergunta=" + pergunta + ", certa=" + certa + ", alternativa1=" + alternativa1 + ", alternativa2=" + alternativa2 + ", alternativa3=" + alternativa3 + ", alternativa4=" + alternativa4 + '}';
    }

    
    
}

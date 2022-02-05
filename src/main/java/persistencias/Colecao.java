/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Juan
 */
@Entity
@Inheritance(strategy = InheritanceType. TABLE_PER_CLASS)
public abstract class Colecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 1024)
    private String titulo;
    private String descricao;
    private String imagem;
    private List<Recurso> recurso;
/*-----------gets--------1*/
    public String getId() {
        return titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public List<Recurso> getRecursos() {
        if(recurso.isEmpty()!=false){
         Comparator<Recurso> RecursosTituloComparator
      = Comparator.comparing(Recurso::getTitulo);
        Collections.sort(recurso, RecursosTituloComparator);}
        
        return recurso;
    }
    
/*-----------sets--------*/
    public void setId(String titulo) {
        this.titulo = titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setRecursos(List<Recurso> recursos) {
        if(recurso.isEmpty()!=false){
         Comparator<Recurso> RecursosTituloComparator
      = Comparator.comparing(Recurso::getTitulo);
        Collections.sort(recurso, RecursosTituloComparator);}
        
        this.recurso = recursos;
    }
    
/*-----------------------*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titulo != null ? titulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colecao)) {
            return false;
        }
        Colecao other = (Colecao) object;
        if ((this.titulo == null && other.titulo != null) || (this.titulo != null && !this.titulo.equals(other.titulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencias.coelcaoJPA[ id=" + titulo + " ]";
    }
    
}

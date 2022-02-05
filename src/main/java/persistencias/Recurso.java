/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Juan
 */
@Entity
public class Recurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String chaves;
    @Column(length = 1024)
    private String titulo;
    @Column(length = 4096)
    private String descricao;
    private String link;
    private String imagem;
    private String data_criacao;
    private String data_registro;
    private List<Autor> autores;

/*----------------Gets---------------------------------------------------------*/

    public Long getId() {
        return id;
    }
    
    
    public String getChaves() {
        return chaves;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }

    public String getImagem() {
        return imagem;
    }
    
    public Date getData_criacao() throws ParseException {
        DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        return format.parse(data_criacao);
    }
//
    public Date getData_registro() throws ParseException {
        DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        return format.parse(data_registro);
    }

    public List<Autor> getAutores() {
        Comparator<Autor> AutorNameComparator
      = Comparator.comparing(Autor::getNome);
        Collections.sort(autores, AutorNameComparator);
        return autores;
    }
    
/*----------------Sets---------------------------------------------------------*/

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setChaves(String chaves) {
        this.chaves = chaves;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setData_criacao(Date data_criacao) {
        DateFormat dateFormat = new  SimpleDateFormat("yyy/MM/dd");
        this.data_criacao = dateFormat.format(data_criacao);
    }

    public void setData_registro(String data_registro) {
         DateFormat dateFormat = new  SimpleDateFormat("yyy/MM/dd");
        this.data_registro = dateFormat.format(data_registro);
    }

    public void setAutores(List<Autor> autores) {
        Comparator<Autor> AutorNameComparator
      = Comparator.comparing(Autor::getNome);
        Collections.sort(autores, AutorNameComparator);
        this.autores = autores;
    }

    
/*-------------------------------------------------------------------------*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chaves != null ? chaves.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.chaves == null && other.chaves != null) || (this.chaves != null && !this.chaves.equals(other.chaves))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencias.recurso[ id=" + chaves + " ]";
    }
    
}

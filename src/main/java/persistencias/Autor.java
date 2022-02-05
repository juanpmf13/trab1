/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Juan
 */
@Entity
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    @Column(length=64)
    private String nome;
    @Column(length=64)
    private String sobrenome;
    @Column(length=256)
    private String afiliacao;
    private String orcid;
    @Transient
    private String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
    @Transient
    private Pattern pattern = Pattern.compile(regx);  
/*-----------gets--------*/
    public String getEmail() {
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false){
            return null;
        }
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public String getOrcid() {
        if(orcid.matches("\\d\\d\\d\\d-\\d\\d\\d\\d-\\d\\d\\d\\d")==true) {
            return orcid;
        } 
        else {
            return null;
        }
    }
    
/*-----------sets--------*/
    public void setEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false){
            this.email= null;
        }
        else{
            this.email = email;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public void setOrcid(String orcid) {
        if(orcid.matches("\\d\\d\\d\\d-\\d\\d\\d\\d-\\d\\d\\d\\d")==true) {
            this.orcid=orcid;
        } 
        this.orcid=null;
    }
    
/*------------------------*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencias.autoresJPA[ id=" + email + " ]";
    }
    
}

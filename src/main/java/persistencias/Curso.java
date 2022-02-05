/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;

/**
 *
 * @author Juan
 */
@Entity
public class Curso extends Colecao {
    private String datadeRegistro;
/*---------------gets---------------*/
    


    public String getDatadeRegistro() {
        DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        return format.format(datadeRegistro);
    }
/*---------------sets---------------*/

    public void setDatadeRegistro(String datadeRegistro) {
         DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        this.datadeRegistro = format.format(datadeRegistro);
    }
    
}

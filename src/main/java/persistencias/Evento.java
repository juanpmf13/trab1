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
public class Evento extends Colecao  {
    private String datadeInicio;
    private String datadeFim;
/*---------------gets------------*/
    public String getDatadeInicio() {
         DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        return format.format(datadeInicio);
    }

    public String getDatadeFim() {
         DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        return format.format(datadeFim);
    }
/*---------------sets------------*/

    public void setDatadeInicio(String datadeInicio) {
         DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        this.datadeInicio = format.format(datadeInicio);
    }

    public void setDatadeFim(String datadeFim) {
         DateFormat format = new  SimpleDateFormat("yyy/MM/dd");
        this.datadeFim = format.format(datadeFim);
    }
    
}

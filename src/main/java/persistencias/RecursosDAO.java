/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface RecursosDAO {
    void salva(Recurso e);

    Recurso recupera(Long id);

    List<Recurso> buscaSobrenome(String snome);

    List<Recurso> buscaTudo();
}

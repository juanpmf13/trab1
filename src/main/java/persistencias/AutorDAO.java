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
public interface AutorDAO {
    
    void salva(Autor e);

    Recurso recupera(Long id);

    List<Autor> buscaSobrenome(Autor snome);

    List<Autor> buscaTudo();
}

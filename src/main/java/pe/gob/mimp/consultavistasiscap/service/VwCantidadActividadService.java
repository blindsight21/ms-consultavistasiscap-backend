/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service;

import java.util.List;
import pe.gob.mimp.consultavistasiscap.bean.FindAllByFieldBean;
import pe.gob.mimp.consultavistasiscap.bean.VwCantidadActividadBean;

/**
 *
 * @author Omar
 */
public interface VwCantidadActividadService {

    List<VwCantidadActividadBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;
    
}

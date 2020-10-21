/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadBean;

/**
 *
 * @author Omar
 */
public interface VwActividadService {

    List<VwActividadBean> findAll() throws Exception;

    List<VwActividadBean> obtenerActividadesDepartamento(BigDecimal nidDepartamento) throws Exception;

}

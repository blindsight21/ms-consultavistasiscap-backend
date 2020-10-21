/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service;

import java.util.List;
import pe.gob.mimp.consultavistasiscap.bean.FindByParamBean;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadCalendarioBean;

/**
 *
 * @author Omar
 */
public interface VwActividadCalendarioService {

    List<VwActividadCalendarioBean> loadVwActividadCalendarioList(FindByParamBean findByParamBean) throws Exception;
    
}

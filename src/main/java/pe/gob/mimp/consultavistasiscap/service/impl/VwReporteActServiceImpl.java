/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.repository.vwreporteactividad.VwReporteActRepository;
import pe.gob.mimp.consultavistasiscap.bean.FindByParamBean;
import pe.gob.mimp.consultavistasiscap.bean.VwReporteActividadBean;
import pe.gob.mimp.consultavistasiscap.converter.VwReporteActividadCast;
import pe.gob.mimp.consultavistasiscap.util.Util;
import pe.gob.mimp.consultavistasiscap.service.VwReporteActService;
import pe.gob.mimp.siscap.model.VwReporteActividad;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class VwReporteActServiceImpl implements VwReporteActService {

    @Autowired
    private VwReporteActRepository vwReporteActRepository;

    @Override
    public List<VwReporteActividadBean> loadVwReporteActList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<VwReporteActividad> vwReporteActList = vwReporteActRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(vwReporteActList)) {

            return vwReporteActList.stream().map(vwReporteActividad -> {
                return VwReporteActividadCast.castVwReporteActividadToVwReporteActividadBean(vwReporteActividad);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<VwReporteActividadBean> findAll() throws Exception {
        List<VwReporteActividad> vwReporteActList = vwReporteActRepository.findAll();

        if (!Util.esListaVacia(vwReporteActList)) {
            return vwReporteActList.stream().map(vwReporteActividad -> {
                return VwReporteActividadCast.castVwReporteActividadToVwReporteActividadBean(vwReporteActividad);
            }).collect(Collectors.toList());
        }

        return null;
    }
}

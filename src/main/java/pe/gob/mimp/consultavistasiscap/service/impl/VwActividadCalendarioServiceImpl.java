/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.VwActividadCalendario;
import pe.gob.mimp.siscap.repository.vwactividadcalendario.VwActividadCalRepository;
import pe.gob.mimp.consultavistasiscap.bean.FindByParamBean;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadCalendarioBean;
import pe.gob.mimp.consultavistasiscap.converter.VwActividadCalendarioCast;
import pe.gob.mimp.consultavistasiscap.util.Util;
import pe.gob.mimp.consultavistasiscap.service.VwActividadCalendarioService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class VwActividadCalendarioServiceImpl implements VwActividadCalendarioService {

    @Autowired
    private VwActividadCalRepository vwActividadCalRepository;

    @Override
    public List<VwActividadCalendarioBean> loadVwActividadCalendarioList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<VwActividadCalendario> vwActividadCalList = vwActividadCalRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(vwActividadCalList)) {

            return vwActividadCalList.stream().map(vwActividadCal -> {
                return VwActividadCalendarioCast.castVwActividadCalendarioToVwActividadCalendarioBean(vwActividadCal);
            }).collect(Collectors.toList());
        }

        return null;
    }

}

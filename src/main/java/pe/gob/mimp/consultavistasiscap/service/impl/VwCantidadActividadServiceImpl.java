/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.consultavistasiscap.bean.FindAllByFieldBean;
import pe.gob.mimp.siscap.repository.vwcantidadactividad.VwCantidadActRepository;
import pe.gob.mimp.consultavistasiscap.bean.VwCantidadActividadBean;
import pe.gob.mimp.consultavistasiscap.converter.VwCantidadActividadCast;
import pe.gob.mimp.consultavistasiscap.util.Util;
import pe.gob.mimp.consultavistasiscap.service.VwCantidadActividadService;
import pe.gob.mimp.siscap.model.VwCantidadActividad;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class VwCantidadActividadServiceImpl implements VwCantidadActividadService {

    @Autowired
    private VwCantidadActRepository vwCantidadActividadRepository;

    @Override
    public List<VwCantidadActividadBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        if (findAllByFieldBean == null) {
            return null;
        }

        List<VwCantidadActividad> vwCantidadActividadList = vwCantidadActividadRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (!Util.esListaVacia(vwCantidadActividadList)) {

            return vwCantidadActividadList.stream().map(vwCantidadActividad -> {
                return VwCantidadActividadCast.castVwCantidadActividadToVwCantidadActividadBean(vwCantidadActividad);
            }).collect(Collectors.toList());
        }
        return null;
    }

}

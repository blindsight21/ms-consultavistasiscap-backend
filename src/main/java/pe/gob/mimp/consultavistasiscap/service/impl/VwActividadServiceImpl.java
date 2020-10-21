/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadBean;
import pe.gob.mimp.consultavistasiscap.converter.VwActividadCast;
import pe.gob.mimp.consultavistasiscap.service.VwActividadService;
import pe.gob.mimp.consultavistasiscap.util.Util;
import pe.gob.mimp.siscap.model.VwActividad;
import pe.gob.mimp.siscap.repository.vwactividad.VwActividadRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class VwActividadServiceImpl implements VwActividadService {

    @Autowired
    private VwActividadRepository vwActividadRepository;

    @Override
    public List<VwActividadBean> findAll() throws Exception {

        List<VwActividad> listVwActividad = vwActividadRepository.findAll();

        if (Util.esListaVacia(listVwActividad)) {
            return null;
        }

        return listVwActividad.stream().map(vwActividad -> {
            return VwActividadCast.castVwActividadToVwActividadBean(vwActividad);
        }).collect(Collectors.toList());
    }

    @Override
    public List<VwActividadBean> obtenerActividadesDepartamento(BigDecimal nidDepartamento) throws Exception {

        if (nidDepartamento == null) {
            return null;
        }

        List<VwActividad> listVwActividad = vwActividadRepository.obtenerActividadDepartamento(nidDepartamento);

        if (Util.esListaVacia(listVwActividad)) {
            return null;
        }

        return listVwActividad.stream().map(vwActividad -> {
            return VwActividadCast.castVwActividadToVwActividadBean(vwActividad);
        }).collect(Collectors.toList());

    }

}

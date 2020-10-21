/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.ws.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.mimp.consultavistasiscap.bean.ResponseData;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadBean;
import pe.gob.mimp.consultavistasiscap.service.VwActividadService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/vwactividad")
public class VwActividadController {

    @Autowired
    private VwActividadService vwActividadService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<ResponseData<?>> findAll() throws Exception {

        List<VwActividadBean> vwActividadCalList = vwActividadService.findAll();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(vwActividadCalList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerActividadesDepartamento/{nidDepartamento}")
    public ResponseEntity<ResponseData<?>> obtenerActividadesDepartamento(@PathVariable("nidDepartamento") BigDecimal nidDepartamento) throws Exception {

        List<VwActividadBean> vwActividadCalList = vwActividadService.obtenerActividadesDepartamento(nidDepartamento);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(vwActividadCalList);

        return ResponseEntity.ok(response);

    }

}

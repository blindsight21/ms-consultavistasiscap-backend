/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.ws.rest;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.consultavistasiscap.bean.FindByParamBean;

import pe.gob.mimp.consultavistasiscap.bean.ResponseData;
import pe.gob.mimp.consultavistasiscap.bean.VwActividadCalendarioBean;
import pe.gob.mimp.consultavistasiscap.service.VwActividadCalendarioService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/vwactividadcalendario")
public class VwActividadCalendarioController {

    @Autowired
    private VwActividadCalendarioService vwActividadCalService;

    @PostMapping(value = "/loadVwActividadCalendarioList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadVwActividadCalendarioList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<VwActividadCalendarioBean> vwActividadCalList = vwActividadCalService.loadVwActividadCalendarioList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(vwActividadCalList);

        return ResponseEntity.ok(response);

    }

}

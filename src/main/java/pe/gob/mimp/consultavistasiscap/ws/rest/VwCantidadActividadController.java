/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.consultavistasiscap.ws.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.consultavistasiscap.bean.FindAllByFieldBean;
import pe.gob.mimp.consultavistasiscap.bean.ResponseData;
import pe.gob.mimp.consultavistasiscap.bean.VwCantidadActividadBean;
import pe.gob.mimp.consultavistasiscap.service.VwCantidadActividadService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/vwcantidadactividad")
public class VwCantidadActividadController {

    @Autowired
    private VwCantidadActividadService vwCantidadActividadService;

    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<VwCantidadActividadBean> vwCantidadActividadList = vwCantidadActividadService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(vwCantidadActividadList);

        return ResponseEntity.ok(response);

    }
}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ParametroRestController {

    @Autowired
    private ParametroService parametroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Parametro>> getParametros() {
        return ResponseEntity.ok(
                this.parametroService.listar());
    }

    @PostMapping("/editar")
    public ResponseEntity<DetalleResponse> updParametro(@RequestBody ParametroInsert parametroInsert) {
        return ResponseEntity.ok(
                this.parametroService.editar(parametroInsert));
    }

    @PostMapping("/agregar")
    public ResponseEntity<DetalleResponse> insParametro(@RequestBody ParametroInsert parametroInsert) {
        return ResponseEntity.ok(
                this.parametroService.agregar(parametroInsert));
    }

}
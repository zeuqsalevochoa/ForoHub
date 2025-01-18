package com.alura.foro.controller;


import com.alura.foro.domain.DatosActualizarTopico;
import com.alura.foro.domain.DatosRegistroTopico;
import com.alura.foro.domain.Topico;
import com.alura.foro.domain.TopicoRepository;
import com.alura.foro.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosTopico){
        var detalleRegistro = service.registrar(datosTopico);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleRegistro);
    }

    @GetMapping
    public ResponseEntity<Page<Topico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(service.listar(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopico(@PathVariable Long id){
        var topicoEncontrado = service.buscar(id);
        return ResponseEntity.ok(topicoEncontrado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosTopico){
        var datosActualizados = service.actualizar(id, datosTopico);
        return ResponseEntity.ok(datosActualizados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

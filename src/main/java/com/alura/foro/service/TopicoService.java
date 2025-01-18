package com.alura.foro.service;

import com.alura.foro.domain.DatosActualizarTopico;
import com.alura.foro.domain.DatosRegistroTopico;
import com.alura.foro.domain.Topico;
import com.alura.foro.domain.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico registrar(DatosRegistroTopico datosRegistro){
        var topico = repository.findByTituloAndMensaje(datosRegistro.titulo(), datosRegistro.mensaje());
        if(topico != null){
            throw new ValidacionExcepcion("Ya existe un tópico con el mismo titulo y mensaje, intente con otro");
        }

        var topicoNuevo = new Topico(datosRegistro);
        repository.save(topicoNuevo);
        return topicoNuevo;
    }

    public Page<Topico> listar(Pageable paginacion){
        return repository.findAll(paginacion);
    }

    public Topico buscar(Long id) {
        if (id == null){
            throw new ValidacionExcepcion("Debes de ingresar un id");
        }
        var topicoEncontrado = repository.findById(id);

        if (topicoEncontrado.isEmpty()){
            throw new ValidacionExcepcion("No se encontró un tópico con el id: " + id);
        } else {
            return topicoEncontrado.get();
        }
    }

    public Topico actualizar(Long id, DatosActualizarTopico datosTopico) {
        if (id == null){
            throw new ValidacionExcepcion("Debes de ingresar un id");
        }

        var topicoEncontrado = repository.findById(id);
        if (topicoEncontrado.isEmpty()){
            throw new ValidacionExcepcion("Debes de ingresar un id válido");
        }

        var topico = repository.findByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje());
        if(topico != null){
            throw new ValidacionExcepcion("Ya existe un tópico con el mismo titulo y mensaje, intente con otro");
        }

        topicoEncontrado.get().actualizarTopico(datosTopico);
        return topicoEncontrado.get();

    }

    public void eliminar(Long id) {
        if (id == null){
            throw new ValidacionExcepcion("Debes de ingresar un id");
        }
        var topicoEncontrado = repository.findById(id);

        if (topicoEncontrado.isEmpty()) {
            throw new ValidacionExcepcion("No se encuentra un tópico con el id: " + id);
        } else {
            repository.delete(topicoEncontrado.get());
        }
    }
}

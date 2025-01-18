package com.alura.foro.service;

public class ValidacionExcepcion extends RuntimeException {
    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }
}

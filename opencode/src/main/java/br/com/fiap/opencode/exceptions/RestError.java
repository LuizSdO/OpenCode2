package br.com.fiap.opencode.exceptions;


public record RestError (
        int cod,
        String message
) {}


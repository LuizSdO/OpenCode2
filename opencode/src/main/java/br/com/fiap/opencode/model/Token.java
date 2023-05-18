package br.com.fiap.opencode.model;

public record Token(
        String token,
        String type,
        String prefix
) {}

package org.example.api.rest.model;

public record User(
        long id,
        String name,
        String email
) {
}

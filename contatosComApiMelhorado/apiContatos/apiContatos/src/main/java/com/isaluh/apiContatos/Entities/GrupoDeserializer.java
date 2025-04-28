package com.isaluh.apiContatos.Entities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GrupoDeserializer extends JsonDeserializer<Grupo> {

    @Override
    public Grupo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String grupoIdValue = p.getText();
        Integer grupoId = null;
        try {
            grupoId = Integer.parseInt(grupoIdValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Grupo grupo = new Grupo();
        grupo.setId(grupoId);
        return grupo;
    }
}


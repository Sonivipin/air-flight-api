package com.mycompany.air.model;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

  @Override
  public LocalDate deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
                  throws IOException, JsonProcessingException {
    return LocalDate.parse(jsonParser.getText());
  }
}
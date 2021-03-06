package com.mycompany.air.model;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  @Override
  public LocalDateTime deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
                  throws IOException, JsonProcessingException {
    return LocalDateTime.parse(jsonParser.getText());
  }
}
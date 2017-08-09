package com.mycompany.air.model;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  @Override
  public void serialize(final LocalDateTime localDateTime, final JsonGenerator jsonGenerator,
                  final SerializerProvider serializerProvider)
                  throws IOException, JsonProcessingException {
    jsonGenerator.writeString(localDateTime.toLocalDate().toString());
  }
}

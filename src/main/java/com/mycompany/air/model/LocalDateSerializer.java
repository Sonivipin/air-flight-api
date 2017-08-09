package com.mycompany.air.model;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer  extends JsonSerializer<LocalDate> {

  @Override
  public void serialize(final LocalDate localDate, final JsonGenerator jsonGenerator,
                  final SerializerProvider serializerProvider)
                  throws IOException, JsonProcessingException {
    jsonGenerator.writeString(localDate.toString());
  }

}

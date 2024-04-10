package jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;

public class JacksonStreamingWriteExample {
  public static void main(String[] args) throws IOException {
    JsonFactory factory = new JsonFactory();
    File file = new File("output.json");

    try (JsonGenerator generator = factory.createGenerator(file, JsonEncoding.UTF8)) {
      generator.writeStartObject(); // початок об'єкта
      generator.writeStringField("name", "John Doe");
      generator.writeNumberField("age", 30);
      generator.writeBooleanField("verified", false);
      generator.writeEndObject(); // кінець об'єкта
    }
  }
}

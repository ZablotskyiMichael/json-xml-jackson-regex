package jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class JacksonStreamingReadExample {
  public static void main(String[] args) throws IOException {
    JsonFactory factory = new JsonFactory();
    File file = new File("output.json");

    try (JsonParser parser = factory.createParser(file)) {
      while (parser.nextToken() != JsonToken.END_OBJECT) {
        String fieldName = parser.getCurrentName();
        if (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
          parser.nextToken();// переходимо до значення
          System.out.println(fieldName + ": " + parser.getText());
        }
      }
    }
  }
}

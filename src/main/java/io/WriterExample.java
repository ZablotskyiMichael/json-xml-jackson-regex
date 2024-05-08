package io;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.BookStatistics;
import model.BookStatisticsItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Приклад запису вхідного потоку з консолі в файл.
 */
public class WriterExample {

  private static final XmlMapper xmlMapper = new XmlMapper();
  {xmlMapper.enable(
      SerializationFeature.INDENT_OUTPUT);
  }
  public static void main(String[] args) throws IOException {
    BookStatisticsItem bookStatisticsItem1 = new BookStatisticsItem("1", "1c");
    BookStatisticsItem bookStatisticsItem2 = new BookStatisticsItem("2", "2c");
    BookStatistics bookStatistics = new BookStatistics(List.of(bookStatisticsItem1, bookStatisticsItem2));

    xmlMapper.writeValue(new FileOutputStream("test.xml"), bookStatistics);
  }
}

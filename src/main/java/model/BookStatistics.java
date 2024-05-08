package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JacksonXmlRootElement(localName="stats")
public class BookStatistics {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(namespace = "item")
  List<BookStatisticsItem> items = new ArrayList<>();

  public BookStatistics(List<BookStatisticsItem> items) {
    this.items = items;
  }
}

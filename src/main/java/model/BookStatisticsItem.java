package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class BookStatisticsItem {
  private String value;
  private String count;

  public BookStatisticsItem(String value, String count) {
    this.value = value;
    this.count = count;
  }
}

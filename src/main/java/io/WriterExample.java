package io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Приклад запису вхідного потоку з консолі в файл.
 */
public class WriterExample {
  public static void main(String[] args) throws IOException {
    // Створюємо буферізований символьний вхідний потік
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // Використовуємо клас PrintWriter для виведення
    try (PrintWriter out = new PrintWriter(new FileWriter("out.txt"))) {
      while (true) {
        String s = in.readLine();
        if ("stop".equals(s))  // за словом stop зупинка
          break;
        out.println(s);
      }
    }

  }
}

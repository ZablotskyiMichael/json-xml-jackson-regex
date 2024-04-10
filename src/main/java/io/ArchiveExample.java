package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Приклад архівування/розархівування двох файлів.
 */
public class ArchiveExample {
  public static void main(String[] args) throws IOException {
    zip();
//    unzip();
  }

  private static void zip() throws IOException {
    try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream("archive.zip"))) {
      pack(Paths.get("111.txt"), out);
      pack(Paths.get("222.txt"), out);
    }
  }

  static void pack(Path source, ZipOutputStream out) throws IOException {
    // присвоїти ім’я файлу в архіві
    out.putNextEntry(new ZipEntry(source.getFileName().toString()));
    // передати файл в потік архіву
    Files.copy(source, out);
  }

  private static void unzip() throws IOException {
    try (ZipInputStream in = new ZipInputStream(new FileInputStream("archive.zip"))) {
      ZipEntry entry;
      while ((entry = in.getNextEntry()) != null) {
        Path target = Paths.get("unz_" + entry.getName());
        Files.copy(in, target);
      }
    }
  }

}

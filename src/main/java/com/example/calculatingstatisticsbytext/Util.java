package com.example.calculatingstatisticsbytext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Util {

  static String fileNameReader(String number, BufferedReader reader) {
    StringBuilder fileName = new StringBuilder();
    while (fileName.toString().trim().isEmpty()) {
      fileName.delete(0, fileName.toString().length());
      try {
        System.out.print("Введите название " + number + " файла: ");
        fileName.append(reader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (!fileName.toString().endsWith(".txt")) {
      fileName.append(".txt");
    }
    return fileName.toString();
  }

  static String getFilePath(String fileName) {
    String sep = File.separator;
    return sep + "Users" + sep + System.getProperty("user.name") + sep + "Desktop" + sep + fileName;
  }

  static void fileScanner(File file, StringBuilder stringBuilder) {
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        stringBuilder.append(scanner.nextLine()).append(" ");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  static Map<String, Integer> textAnalysis(String[] words, String[] templates) {
    Map<String, Integer> resultMap = new HashMap<>();

    for (String w : words) {
      for (String t : templates) {
        resultMap.putIfAbsent(t, 0);
        StringBuilder temp = new StringBuilder(t);

        if (t.startsWith("\"") && t.endsWith("\"")) {
          if (w.contains(temp.substring(1, t.length() - 1))) {
            resultMap.computeIfPresent(t, (k, v) -> v = v + 1);
          }
        } else {
          int charPairs = 0;
          while (temp.toString().length() != 0) {
            int charCount = 0;
            if (w.contains(temp.subSequence(0, 1))) {
              for (Character c : w.toCharArray()) {
                if (c.equals(temp.charAt(0))) {
                  charCount++;
                }
              }
              if (charCount >= Integer.parseInt(temp.subSequence(1, 2).toString())) {
                charPairs++;
              } else {
                break;
              }
            }
            temp.delete(0, 2);
          }
          if (charPairs == t.length() / 2) {
            resultMap.computeIfPresent(t, (k, v) -> v = v + 1);
          }
        }
      }
    }
    return resultMap;
  }

  static void fileWriter(String outputFileName, String[] templates,
      Map<String, Integer> resultMap) {
    try (FileWriter writer = new FileWriter(outputFileName, false)) {
      for (String k : templates) {
        writer.write(k + " " + resultMap.get(k) + "\n");
      }
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

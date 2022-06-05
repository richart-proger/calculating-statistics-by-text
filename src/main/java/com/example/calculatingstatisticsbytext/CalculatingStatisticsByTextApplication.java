package com.example.calculatingstatisticsbytext;

import static com.example.calculatingstatisticsbytext.Util.fileNameReader;
import static com.example.calculatingstatisticsbytext.Util.fileScanner;
import static com.example.calculatingstatisticsbytext.Util.fileWriter;
import static com.example.calculatingstatisticsbytext.Util.getFilePath;
import static com.example.calculatingstatisticsbytext.Util.textAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatingStatisticsByTextApplication {

  private static final Logger log = LoggerFactory
      .getLogger(CalculatingStatisticsByTextApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CalculatingStatisticsByTextApplication.class, args);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String fileName1 = fileNameReader("первого", reader);
      String fileName2 = fileNameReader("второго", reader);
      String fileName3 = fileNameReader("третьего", reader);

      StringBuilder fileText = new StringBuilder();
      File fileWithText = new File(getFilePath(fileName1));
      fileScanner(fileWithText, fileText);

      StringBuilder fileTemplate = new StringBuilder();
      File fileWithTemplates = new File(getFilePath(fileName2));
      fileScanner(fileWithTemplates, fileTemplate);

      String[] words = fileText.toString().split(" ");
      String[] templates = fileTemplate.toString().split(" ");
      Map<String, Integer> resultMap = textAnalysis(words, templates);

      String outputFileName = getFilePath(fileName3);
      fileWriter(outputFileName, templates, resultMap);
    } catch (IOException e) {
      log.info(e.getMessage());
    }
  }
}

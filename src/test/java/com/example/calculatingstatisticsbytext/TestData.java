package com.example.calculatingstatisticsbytext;

import java.util.HashMap;
import java.util.Map;

class TestData {

  private static final String TEXT_FROM_TEST_FILE = "Отец мой Андрей Петрович Гринев в молодости своей служил при графе Минихе и вышел в отставку премьер-майором в 17.. году.";
  static final String[] WORDS_ARRAY = TEXT_FROM_TEST_FILE.split(" ");
  private static final String TEXT_FROM_TEMPLATES_FILE = "о2 т1о1 \"ми\" ф2 11 \"йо\" й1о1";
  static final String[] TEMPLATES_ARRAY = TEXT_FROM_TEMPLATES_FILE.split(" ");

  private static Map<String, Integer> RESULT_MAP = new HashMap<>();

  static Map<String, Integer> getResultMap() {
    RESULT_MAP.put("о2", 2);
    RESULT_MAP.put("т1о1", 3);
    RESULT_MAP.put("\"ми\"", 0);
    RESULT_MAP.put("ф2", 0);
    RESULT_MAP.put("11", 1);
    RESULT_MAP.put("\"йо\"", 1);
    RESULT_MAP.put("й1о1", 3);
    return RESULT_MAP;
  }
}

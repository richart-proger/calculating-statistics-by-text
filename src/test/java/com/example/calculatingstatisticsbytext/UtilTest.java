package com.example.calculatingstatisticsbytext;

import static com.example.calculatingstatisticsbytext.TestData.TEMPLATES_ARRAY;
import static com.example.calculatingstatisticsbytext.TestData.WORDS_ARRAY;
import static com.example.calculatingstatisticsbytext.TestData.getResultMap;
import static com.example.calculatingstatisticsbytext.Util.textAnalysis;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class UtilTest {

  @Test
  void textAnalysisTest() {
    Map<String, Integer> resultMap = textAnalysis(WORDS_ARRAY, TEMPLATES_ARRAY);
    assertThat(resultMap).isNotEmpty();
    assertThat(getResultMap()).hasSameSizeAs(resultMap);

    for (Map.Entry<String, Integer> testElms : resultMap.entrySet()) {
      String k = testElms.getKey();
      assertThat(getResultMap()).containsKey(k);
      assertThat(resultMap).containsKey(k);
      assertThat(resultMap.get(k)).isEqualTo(resultMap.get(k));
    }
  }
}

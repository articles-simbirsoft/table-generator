package utils;

import models.TestCase;
import org.testng.util.Strings;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static enums.Status.getColorName;
import static enums.Status.getColorValue;
import static java.lang.String.format;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;
import static utils.FileReader.getFilesInFolder;
import static utils.FileReader.getTestCasesDataInFolder;

/**
 * Методы для формирования html кода таблицы
 */
public class TableGenerator implements ConfluenceForm {

    private static int testNumber = 0;

    /**
     * Формирует html код таблицы
     *
     * @param testCasesPath путь к папке с json файлами отчета
     * @param link ссылка на прогон в CI
     * @param name название прогона
     * @return строка с html кодом таблицы
     * @throws IOException ошибка доступа к данным
     */
    public static String createTableBody(String testCasesPath, String link, String name) throws IOException {

        List<Path> filesPath = getFilesInFolder(testCasesPath);
        List<TestCase> tests = getTestCasesDataInFolder(filesPath);

        List<TestCase> notPassed = tests.stream()
                .sorted(Comparator.comparing(TestCase::getStatus)
                        .thenComparing(TestCase::getEpic, nullsFirst(naturalOrder()))
                        .thenComparing(TestCase::getFeature, nullsFirst(naturalOrder()))
                        .thenComparing(TestCase::getStory, nullsFirst(naturalOrder()))
                        .thenComparing(TestCase::getName, nullsFirst(naturalOrder()))).collect(Collectors.toList());

        String lines = createTableLines(notPassed);

        return (format(TABLE_HEADER, name, link, link) + lines + TABLE_TAIL).replace("\"", "\\\"");
    }

    /**
     * Формирует строки таблицы в Confluence
     *
     * @param testsCases список упавших тестов
     * @return html код строк таблицы
     */
    private static String createTableLines(List<TestCase> testsCases) {
        StringBuilder result = new StringBuilder();
        String colorValue = "";

        for (TestCase test : testsCases) {
            colorValue = getColorValue(test.getStatus());

            result.append(
                    format(
                            TABLE_LINE,
                            ++testNumber,
                            Strings.isNotNullAndNotEmpty(test.getEpic()) ? test.getEpic() : " ",
                            Strings.isNotNullAndNotEmpty(test.getFeature()) ? test.getFeature() : " ",
                            Strings.isNotNullAndNotEmpty(test.getStory()) ? test.getStory() : " ",
                            colorValue,
                            getColorName(test.getStatus()),
                            colorValue,
                            test.getName()
                    )
            );
        }

        return result.toString();
    }
}

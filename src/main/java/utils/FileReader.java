package utils;

import com.google.gson.Gson;
import models.TestCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Методы для работы с файлами
 */
public class FileReader {

    /**
     * Получает список названий файлов в папке
     *
     * @param path путь к папке с файлами
     * @return список названий файлов
     * @throws IOException ошибка доступа к данным
     */
    public static List<Path> getFilesInFolder(String path) throws IOException {
        return Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    /**
     * Получает данные из json файла
     *
     * @param path путь к папке с файлами
     * @return данные из json файла
     */
    public static TestCase readTestCasesJson(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            String text = stream.reduce("", String::concat);
            return new Gson().fromJson(text, TestCase.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Получает данные по всем упавшим
     *
     * @param paths путь к папке с файлами
     * @return список с данными по упавшим тестам
     */
    public static List<TestCase> getTestCasesDataInFolder(List<Path> paths) {
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase;

        for (Path path : paths) {
            testCase = readTestCasesJson(path.toString());

            if (!testCase.getStatus().equals("passed") ) {
                testCase.initLabels();
                testCases.add(testCase);
            }
        }

        return testCases;
    }
}

package utils;

import io.restassured.RestAssured;

import static java.lang.String.format;

/**
 * Методы для работы с api
 */
public class RequestExecutor {

    /**
     * Получает версию таблицы в Confluence
     *
     * @param url адрес страницы
     * @param login логин от учетки Confluence
     * @param password пароль от учетки Confluence
     * @return номер следующей версии страницы
     */
    public static int getNextPageVersion(String url, String login, String password) {
        int result = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(login, password)
                .get(url)
                .jsonPath().get("version.number");

        return result + 1;
    }

    /**
     * Создает таблицу в Confluence
     *
     * @param url адрес страницы
     * @param login логин от учетки Confluence
     * @param password пароль от учетки Confluence
     * @param table html код таблицы
     * @param title Название страницы
     * @param pageVersion Версия страницы
     */
    public static void createConfluenceTable(String url, String login, String password, String table, String title, int pageVersion) {
        String TABLE_BODY = "{\n" +
                "    \"body\": {\n" +
                "        \"storage\": {\n" +
                "                        \"value\": \"%s\",\n" +
                "            \"representation\": \"storage\"\n" +
                "        }\n" +
                "    },\n" +
                "\n" +
                "    \"type\": \"page\",\n" +
                "    \"title\": \"%s\",\n" +
                "\n" +
                "    \"version\": {\n" +
                "        \"number\": \"%s\"\n" +
                "        }\n" +
                "}";

        RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(login, password)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .body(format(TABLE_BODY, table, title, pageVersion))
                .when()
                .put(url)
                .then()
                .statusCode(200);
    }
}

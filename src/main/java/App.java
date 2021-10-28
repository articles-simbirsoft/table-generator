import utils.RequestExecutor;
import java.io.IOException;
import java.util.Scanner;

import static utils.TableGenerator.createTableBody;

public class App {

    public static void main(String[] args) throws IOException {

        //Путь до папки с отчетом
        String PATH = "C:\\Users\\User\\Desktop\\allure-report\\data\\test-cases";
        //Название страницы в Confluence
        String TITLE = "Генератор таблиц iOS";
        //Название таблицы
        String NAME = ": \"№1 Смоук 1.01\"";
        //Ссылка на отчет в CI
        String LINK = "Отчет в CI";
        //Запрос для получения номера текущей версии страницы в Confluence
        String URL_GET = "https://***.ru/rest/api/content/123456789?expand=version";
        //Запрос для создания таблицы в Confluence
        String URL_POST = "https://***.ru/rest/api/content/123456789/";

        System.out.println("Для подключения к учетной записи Confluence");
        Scanner in = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = in.nextLine();

        System.out.print("Введите пароль: ");
        String password = in.nextLine();

        RequestExecutor.createConfluenceTable(
                URL_POST,
                login,
                password,
                createTableBody(PATH, LINK, NAME),
                TITLE,
                RequestExecutor.getNextPageVersion(URL_GET, login, password)
        );
    }
}

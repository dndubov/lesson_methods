import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // ANSI-коды для цветов
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Integer year = null; // Изначально год не задан

        // Если год не указан в коде, запрашиваем его у пользователя
        if (year == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(YELLOW + "Задача 1: Введите год: " + RESET);
            year = scanner.nextInt();
        }

        checkLeapYear(year);

        // Ввод для второй задачи (определение версии приложения)
        Scanner scanner = new Scanner(System.in);
        System.out.print(YELLOW + "Задача 2: Введите тип операционной системы (0 — iOS, 1 — Android): " + RESET);
        int osType = scanner.nextInt();

        System.out.print(YELLOW + "Задача 2: Введите год выпуска устройства: " + RESET);
        int deviceYear = scanner.nextInt();

        suggestAppVersion(osType, deviceYear);

        // Ввод для задачи с доставкой
        System.out.print(YELLOW + "Задача 3: Введите расстояние для доставки (км): " + RESET);
        int deliveryDistance = scanner.nextInt();

        int deliveryDays = calculateDeliveryDays(deliveryDistance);
        if (deliveryDays > 0) {
            System.out.println(GREEN + "Задача 3: Потребуется дней: " + deliveryDays + RESET);
        } else {
            System.out.println(RED + "Задача 3: Доставка недоступна на указанное расстояние." + RESET);
        }

        scanner.close();
    }

    // Проверка на високосный год
    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(CYAN + "Задача 1: " + year + " — високосный год" + RESET);
        } else {
            System.out.println(CYAN + "Задача 1: " + year + " — невисокосный год" + RESET);
        }
    }

    // Определение версии приложения
    public static void suggestAppVersion(int osType, int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        String version = (deviceYear < currentYear) ? "облегченную версию" : "обычную версию";
        String os = (osType == 0) ? "iOS" : "Android";

        System.out.println(CYAN + "Задача 2: Установите " + version + " приложения для " + os + " по ссылке" + RESET);
    }

    // Рассчёт дней доставки
    public static int calculateDeliveryDays(int distance) {
        if (distance > 100) {
            return -1; // Доставка невозможна
        }
        int days = 1; // Базовые сутки
        if (distance > 20) days++;
        if (distance > 60) days++;
        return days;
    }
}

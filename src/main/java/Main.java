import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Программа запустилась");
        logger.log("Просим пользователя ввести входные данные для списка");
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int sizeList = scanner.nextInt();
        logger.log("Просим ввести значение меньше которого нужно отфильтровать");
        System.out.println("Введите верхнюю границу для значений: ");
        int upperBound = scanner.nextInt();
        addList(list, sizeList, upperBound);
        for (Integer i : list) {
            System.out.print(i + "  ");
        }

        System.out.println("Введите порог для фильтра: ");
        int meaningFilter = scanner.nextInt();

        Filter filter = new Filter(meaningFilter);
        logger.log("Получаем отфильтрованный список");
        List<Integer> result = filter.filterOut(list);
        System.out.print("Отфильтрованный список: ");
        for (Integer i : result) {
            System.out.print(i + "  ");
        }
        System.out.println();
        logger.log("Завершение программы");
    }

    public static List<Integer> addList(List<Integer> list, int sizeList, int bound) {
        Logger.getInstance().log("Получаем список");
        for (int i = 0; i < sizeList; i++) {
            list.add(new Random().nextInt(bound));
        }
        return list;
    }
}

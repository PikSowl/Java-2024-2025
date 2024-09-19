import java.util.Scanner;
public class Laboratory {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Привет, здесь хранятся лабораторные по Java "
                           + "Мазалова Константина, 3ПМ 1ИП \n");
        laboratory();
    }

    public static void laboratory() {
        System.out.print("""
                Выберете лабораторную из предложенных (цифрой)
                1. Сиракузская последовательность\s
                2. Сумма ряда\s
                3. Ищем клад (Не выполнено)\s
                4. Логистический максимин (Не выполнено)\s
                5. Дважды четное число (Не выполнено)
                """);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                lab1();
                break;
            case 2:
                lab2();
                break;
            default:
                System.out.println("Некоректный ввод");
                laboratory();
                break;
        }
    }

    public static void lab1() {
        System.out.println("Сиракузская последовательность");
        System.out.println("Введите натуральное число");
        int base = in.nextInt();
        int count = 0;
        int steps = base;

        while (steps != 1) {
            if (steps % 2 == 0){
                steps /= 2;
            }
            else
                steps = steps*3 + 1;
            count++;
        }
        System.out.printf("Число шагов последовательности "
                          + "для %d - %d \n", base, count);
    }

    public static void lab2() {
        System.out.println("Сумма ряда");
        System.out.println("Введите число элементов ряда, затем сами элементы");
        int n = in.nextInt();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1)
                answer += in.nextInt();
            else
                answer -= in.nextInt();
        }

        System.out.printf("Сумма ряда = " + answer);
    }
}
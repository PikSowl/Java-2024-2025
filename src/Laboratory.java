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
                3. Ищем клад\s
                4. Логистический максимин\s
                5. Дважды четное число
                0. Завершить программу
                """);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                lab1();
                break;
            case 2:
                lab2();
                break;
            case 3:
                lab3();
                break;
            case 4:
                lab4();
                break;
            case 5:
                lab5();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Некоректный ввод");
                break;
        }
        laboratory();
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

        System.out.printf("""
                Число шагов последовательности для %d - %d
                
                """, base, count);
    }

    public static void lab2() {
        System.out.println("Ищем клад");
        System.out.println("Введите число элементов ряда, затем сами элементы");
        int n = in.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1)
                sum += in.nextInt();
            else
                sum -= in.nextInt();
        }

        System.out.printf("""
                Сумма ряда =  %d
                
                """, sum);
    }

    public static void lab3() {
        System.out.println("Сумма ряда");
        System.out.println("Введите координаты клада");
        int x = in.nextInt();
        int y = in.nextInt();
        int step;
        int counter = 0;
        System.out.println("Введите карту");
        String direction = in.next();

        while (!direction.equals("стоп")) {
            step = in.nextInt();
            if (!(x == 0 && y==0)) {
                counter++;
                switch (direction) {
                    case "север":
                        x -= step;
                        break;
                    case "юг":
                        x += step;
                        break;
                    case "восток":
                        y -= step;
                        break;
                    case "запад":
                        y += step;
                        break;
                    default:
                        System.out.println("Ошибка ввода, перезапуск программы");
                        lab3();
                        System.exit(0);
                }
                System.out.println(x + " " + y);
            }
            direction = in.next();
        }

        System.out.printf("""
                Минимальное количество выполненых указаний карты = %d
                
                """, counter);
    }

    public static void lab4() {
        System.out.println("Логистический максимин");
        System.out.println("Введите количество дорог");
        int roads = in.nextInt();
        int tunnels;
        int tunnelHeight;
        int minTunnelHeight;
        int truckHeight = 0;
        int roadNumber = 0;

        System.out.println("Введите для каждогой дороги сначала количество "
                          +"тунелей, а затем высоту каждого тунеля [в см]");

        for (int i = 1; i <= roads; i++) {
            tunnels = in.nextInt();
            minTunnelHeight = Integer.MAX_VALUE;
            for (int j = 1; j <= tunnels; j++) {
                tunnelHeight = in.nextInt();
                if (tunnelHeight < minTunnelHeight)
                    minTunnelHeight = tunnelHeight;
            }
            if (minTunnelHeight > truckHeight) {
                truckHeight = minTunnelHeight;
                roadNumber = i;
            }
        }

        System.out.printf("""
                Номер дороги - %d
                Высота грузовика - %d
                
                """, roadNumber, truckHeight);
    }

    static boolean doubleEven(int number){
        int digitSum = number%10 + (number/10)%10 + number/100;
        int digitProd = (number%10) * ((number/10)%10) * (number/100);
        return ((digitSum%2 == 0) || (digitProd %2 == 0));
    }

    public static void lab5() {
        System.out.println("Дважды четное число");
        System.out.println("Введите трехзначное число");
        int number = in.nextInt();

        if(doubleEven(number))
            System.out.printf("""
                Число %d дважды четное, number
                
                """, number);
        else
            System.out.printf("""
                Число %d НЕ дважды четное
                
                """, number);
    }
}
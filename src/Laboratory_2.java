import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Laboratory_2 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Привет, здесь хранятся лабораторные по Java"
                + "(2 часть) Мазалова Константина, 3ПМ 1ИП \n");
        laboratory();
    }

    public static void laboratory() {
        System.out.print("""
                Выберете лабораторную из предложенных (цифрой)
                1. Найти наибольшую подстроку без повторяющихся символов
                2. Объединить два отсортированных массива
                3. Найти максимальную сумму подмассива
                4. Повернуть массив на 90 градусов по часовой стрелке
                5. Найти пару элементов в массиве, с заданной суммой
                6. Найти сумму всех элементов в двумерном массиве
                7. Найти максимум в каждой строке двумерного массива
                8. Повернуть двумерный массив на 90 градусов против ЧС
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
            case 6:
                lab6();
                break;
            case 7:
                lab7();
                break;
            case 8:
                lab8();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Некоректный ввод");
                break;
        }
        laboratory();
    }

    public static String getMaxSubstring(String string) {
        String sub = "";
        int len = 0;
        int maxLen = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (sub.indexOf(c) == -1) {
                sub += c;
                len += 1;
            } else {
                sub = sub.substring(sub.indexOf(c) + 1) + c;
                len = sub.length();
            }

            if (len > maxLen)
                maxLen = len;
        }
        return sub;
    }

    public static void lab1() {
        System.out.println("Задача 1");
        System.out.println("Введите строку без пробелов");
        String string = in.next();


        System.out.printf("""
                Наибольшая подстрока без повтора символов - %s
                
                """, getMaxSubstring(string));
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] answer = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                answer[k] = array1[i];
                i++;
            } else {
                answer[k] = array2[j];
                j++;
            }
            k++;
        }
        if (i < array1.length) {
            System.arraycopy(array1, i, answer, k, (array1.length - i));
        }
        if (j < array2.length) {
            System.arraycopy(array2, j, answer, k, (array2.length - j));
        }
        return answer;
    }

    public static void matrixToConsole(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "\n");
    }

    public static void lab2() {
        System.out.println("Задача 2");
        int[] array1 = new int[] {1, 2, 3, 5, 6, 7, 9, 9, 19, 20};
        int[] array2 = new int[] {1, 4, 5, 8, 10, 11, 13, 18, 23};
        int[] answer = merge(array1, array2);

        System.out.println("Объедененный масив: ");
        matrixToConsole(answer);
    }

    public static int getMaxSubSum(int[] array) {
        int maxSum = 0;
        int sum = 0;

        for (int i : array) {
            sum += i;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }

        return maxSum;
    }

    public static void lab3() {
        System.out.println("Задача 3");
        int[] array1 = new int[] {1, -2, 5, 5, 10, -15, 20, -24, 23, -1};
        System.out.printf("""
                Максимальная сумма подмассива - %s
                
                """, getMaxSubSum(array1));
    }

    public static int[][] rotateClockwise(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                answer[j][matrix.length - 1 -i] = matrix[i][j];

        return answer;
    }

    public static void doubleMatrixToConsole(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++)
                System.out.print(matrix[i][j] + ", ");
            System.out.println(matrix[i][matrix[0].length - 1]);
        }
    }

    public static void lab4() {
        System.out.println("Задача 4");
        int[][] matrix = new int[][] {  {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12}};

        doubleMatrixToConsole(matrix);
        System.out.println("Повернутый на 90 градусов по ЧС масив: ");
        doubleMatrixToConsole(rotateClockwise(matrix));
    }

    public static int[][] rotateCounterClockwise(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                answer[matrix[0].length - 1 - j][i] = matrix[i][j];

        return answer;
    }

    public static int[] getPairBySum(int[] array, int targetSum){
        int[] answer = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer j = indexMap.get(targetSum - array[i]);
            if (j != null) {
                answer[0] = array[i];
                answer[1] = array[j];
                return answer;
            } else {
                indexMap.put(array[i], i);
            }
        }
        return null;
    }

    public static void lab5() {
        System.out.println("Задача 5");
        System.out.println("Введите искомое число");
        int targetSum = in.nextInt();
        int[] array1 = new int[] {10, 2, 35, 13, 77, 10, 2, 4, 0 ,12, 9};

        int[] answer = getPairBySum(array1, targetSum);
        System.out.printf("""
                Пара элеменов масива с суммой %d - %d, %d
                
                """,targetSum, answer[0], answer[1]);
    }

    public static int matrixSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void lab6() {
        System.out.println("Задача 6");
        int[][] matrix = new int[][] {  {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12}};
        System.out.printf("""
                Сумма элементов двумерного масива - %d
                
                """,matrixSum(matrix));
    }

    public static int[] maxInMatrixOfDoubleM(int[][] matrix) {
        int[] answer = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > answer[i])
                    answer[i] = matrix[i][j];
            }
        }
        return answer;
    }

    public static void lab7() {
        System.out.println("Задача 6");
        int[][] matrix = new int[][]{   {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12}};
        System.out.println("Максимальный элемент из каждой строки исходного массива:");
        matrixToConsole(maxInMatrixOfDoubleM(matrix));
    }

    public static void lab8() {
        System.out.println("Задача 8");
        int[][] matrix = new int[][] {  {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12}};

        doubleMatrixToConsole(matrix);
        System.out.println("Повернутый на 90 градусов против ЧС масив: ");
        doubleMatrixToConsole(rotateCounterClockwise(matrix));
    }

}
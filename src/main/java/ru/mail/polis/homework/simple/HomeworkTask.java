package ru.mail.polis.homework.simple;

import java.util.function.ToDoubleFunction;

import static java.lang.Math.*;

public class HomeworkTask {

    /**
     * Нужно численно посчитать интеграл от a до b с шагом delta от функции function
     * Для того, что бы получить значение по Y для точки X, надо просто написать function.applyAsDouble(t)
     * Считаем, что функция определена на всем пространстве от a до b
     */
    public static double calcIntegral(double a, double b, ToDoubleFunction<Double> function, double delta) {
        double sum = 0;
        for (double x = a; x <= b; x += delta) {
            sum += function.applyAsDouble(x) * delta;
        }
        return sum;
    }


    /**
     * Вывести номер максимальной цифры. Счет начинается слева направо,
     * выводим номер первой максимальной цифры (если их несколько)
     */
    public static byte maxNumber(long a) {
        long tmp = a;
        int length = (int) ceil(log10(a));
        int numberIndex = 1;
        int maxNumber = -1;
        for (int i = 1; i <= length; i++) {
            ;
            int number = (int) (tmp / pow(10, length - i));
            if (number > maxNumber) {
                maxNumber = number;
                numberIndex = i;
                if (number == 9) {
                    break;
                }
            }
            tmp %= pow(10, length - i);
        }
        return (byte) numberIndex;
    }


    /**
     * Даны две точки в пространстве (x1, y1) и (x2, y2). Вам нужно найти Y координату третьей точки (x3, y3),
     * которая находится на той же прямой что и первые две.
     */
    public static double lineFunction(int x1, int y1, int x2, int y2, int x3) {
        return ((double) (y2 - y1) * (x3 - x1) / (x2 - x1) + y1);
    }

    /**
     * Даны 4 точки в пространстве A(x1, y1), B(x2, y2), C(x3, y3), D(x4, y4). Найдите площадь выпуклого
     * четырехуголька ABCD.
     */
    public static double square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double s1 = (double) abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        double s2 = (double) abs((x4 - x1) * (y3 - y1) - (x3 - x1) * (y4 - y1)) / 2;
        return s1 + s2;
    }

}

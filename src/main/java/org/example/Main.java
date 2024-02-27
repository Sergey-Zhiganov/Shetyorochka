package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание объекта Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Массив названий компаний
        String[] companies = {"Компания 1", "Компания 2", "Компания 3"};

        // Двумерный массив с названиями компаний и их марками
        String[][] companiesMarks = {
                {companies[0], "Марка 3"},
                {companies[1], "Марка 1"},
                {companies[2], "Марка 2"}
        };

        // Список для хранения данных о клиентах (ФИО, email, телефон, товар, количество)
        ArrayList<Object[]> clients = new ArrayList<>();

        try {
            // Запрос количества заказов у пользователя
            System.out.print("Введите количество заказов: ");
            int orders = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            // Цикл для ввода данных о каждом заказе
            for (int a = 0; a < orders; a++) {
                // Массив для хранения данных о текущем заказе
                Object[] data = new Object[5];

                // Ввод ФИО
                System.out.print("Введите ФИО: ");
                data[0] = scanner.nextLine();

                // Ввод email
                System.out.print("Введите email: ");
                data[1] = scanner.nextLine();

                // Ввод номера телефона
                System.out.print("Введите номер телефона (только цифры): ");
                data[2] = scanner.nextLong();
                scanner.nextLine(); // Очистка буфера

                System.out.println(); // Пустая строка для читабельности

                // Вывод списка компаний и их марок для выбора товара
                int count = 1;
                for (String[] companiesMark : companiesMarks) {
                    System.out.println(count + ") Компания \"" + companiesMark[0] + "\": " + companiesMark[1]);
                    count++;
                }

                // Выбор товара
                System.out.print("Выберите товар: ");
                data[3] = scanner.nextInt() - 1;
                scanner.nextLine(); // Очистка буфера

                // Ввод количества товара
                System.out.print("Введите количество: ");
                data[4] = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                // Добавление данных о заказе в список клиентов
                clients.add(data);
            }

            // Закрытие Scanner после завершения ввода
            scanner.close();

            // Вывод информации о каждом клиенте
            int count = 1;
            for (Object[] client : clients) {
                System.out.println(count + ") ФИО: " + client[0] + "; email: " + client[1] + "; телефон: " + client[2] + "; товар: " + companiesMarks[(int) client[3]][0] + " - " + companiesMarks[(int) client[3]][1] + "; кол-во: " + client[4]);
                count++;
            }
        }
        // Обработка исключения некорректного ввода данных
        catch (InputMismatchException e) {
            System.err.println("Ошибка: " + e);
        }
    }
}

package ru.yandex.praktikum;

public class Praktikum {
    public static void main(String[] args) {
        //Тестируемое имя
        String name = "Борис Петров";
        //Создание экземляра класса Account
        Account account = new Account(name);
        //Запуска метода проверки имени
        account.checkNameToEmboss();
    }
}

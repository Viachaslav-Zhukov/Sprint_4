package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTests {

    private final String name;
    private final boolean expectedResult;

    public AccountTests(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }
    //Тестовые параметры:
    @Parameterized.Parameters(name = "Check the name: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Борис Петров", true}, //Корректное имя
                {"А Б", true}, //Имя из трех символов (граничное значение)
                {"Борис Петровввввввв", true}, //Имя из девятнадцати символов (граничное значение)
                {"А Бв", true}, //Имя из четырех символов (внутреннее граничное значение)
                {"Борис Петроввввввв", true}, //Имя из восемнадцати символов (внутреннее граничное значение)
                {" Борис Петров", false}, //Имя с пробелом в начале
                {"Борис Петров ", false}, //7Имя с пробелом в конце
                {"Ав", false}, //Имя меньше трех символов
                {"Борис Петроввввввввв", false}, //Имя больше девятнадцати символов
                {"", false}, //Пустая строка
                {null, false}, //Имя = null
                {"БорисПетров", false}, //Имя без пробелов
                {"Борис  Петров", false} //Имя с двумя пробелами
        };
    }
    @Test
    @DisplayName("Проверьте имя для банковской карты")
    public void checkTheName() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals("Проверьте корректность работы фильтрации допустимых значений",
                actual, expectedResult);
    }

}

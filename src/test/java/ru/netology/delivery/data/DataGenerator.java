package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Севастополь", "Майкоп", "Уфа", "Улан-Удэ",
                "Горно-Алтайск", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск",
                "Сыктывкар", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск",
                "Абакан", "Грозный", "Чебоксары", "Барнаул", "Краснодар", "Красноярск", "Владивосток", "Ставрополь",
                "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград",
                "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга", "Петропавловск-Камчатский",
                "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Магадан", "Нижний Новгород",
                "Великий Новгород”", "Новосибирск", "Омск", "Оренбург", "Орел", "Пенза", "Пермь", "Псков", "Ростов-на-Дону",
                "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск",
                "Тула", "Тюмень", "Ульяновск", "Челябинск", "Чита", "Ярославль", "Биробиджан", "Нарьян-Мар",
                "Ханты-Мансийск", "Анадырь", "Салехард", "Симферополь", "Севастополь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
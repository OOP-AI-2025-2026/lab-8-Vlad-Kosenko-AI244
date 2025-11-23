package ua.opnu;

public class Main {
    public static void main(String[] args) {

        // Завдання 1
        // 1. Порожнє значення
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        // 2. Заповнене значення
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        // 3. get() на пустому
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Конструктор з null
        try {
            MyOptional<String> broken;
            broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        // Завдання 2
        BookData b1 = new BookData("Java Basics", "Smith", 10, 45.0);  // 4.5
        BookData b2 = new BookData("Advanced Java", "Brown", 5, 25.0); // 5.0
        BookData b3 = new BookData("Algorithms", "Knuth", 3, 12.0);    // 4.0

        BookData[] books = { b1, b2, b3 };
        java.util.Arrays.sort(books); // завдяки Comparable

        System.out.println("Відсортовані книги:");
        for (BookData b : books) {
            System.out.println(b);
        }

        // Завдання 3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // Завдання 4
        String[] words = {"cat", "elephant", "dog", "tiger"};
        String[] longWords = GenericUtils.filter(words, s -> s.length() > 3);

        System.out.println("Слова довші за 3 символи:");
        for (String w : longWords) {
            System.out.println(w);
        }

        // Завдання 5
        Integer[] nums = {1, 2, 3, 5, 8};
        boolean has3 = GenericUtils.contains(nums, 3);
        boolean has4 = GenericUtils.contains(nums, 4);
        System.out.println("Містить 3? " + has3);
        System.out.println("Містить 4? " + has4);

        // Завдання 6
        // Приклади для GenericTwoTuple та GenericThreeTuple
        GenericTwoTuple<String, Integer> userAge =
                new GenericTwoTuple<>("Іван", 20);
        System.out.println("Кортеж 2 елементи: " + userAge);

        GenericThreeTuple<String, Integer, Double> productInfo =
                new GenericThreeTuple<>("Ноутбук", 5, 39999.99);
        System.out.println("Кортеж 3 елементи: " + productInfo);

        // приклад студент + рейтинг + група
        GenericThreeTuple<String, Integer, String> studentTuple =
                new GenericThreeTuple<>("Тарас Шевченко", 91, "АІ-244");
        System.out.println("Студент: " + studentTuple);

    }


}

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        File food = new File("input.txt");
        FileRepository repo = new FileRepository(food);
        List<String> foodArray = repo.getStringList();

        // количество слов в файле
        int foodAmount = foodArray.size();

        // самое длинное слово в файле
        String maxLengthString = longestWord(foodArray);

        // популярный продукт из файла
        String favoriteFood = getFavoriteFood(foodArray);

        System.out.printf("Количество слов в файле: %s\n", foodAmount);
        System.out.printf("Самое длинное слово в файле: %s\n", maxLengthString);
        System.out.printf("Популярный продукт в файле: %s\n", favoriteFood);
    }

    private static String getFavoriteFood(List<String> foodArray) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String f: foodArray){
            if (!hashMap.containsKey(f)) {
                hashMap.put(f, 1);
            }
            else hashMap.put(f, hashMap.get(f) + 1);
        }

        String favoriteFood = foodArray.getFirst();
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            if (entry.getValue() > hashMap.get(favoriteFood)) favoriteFood = entry.getKey();
        }
        return favoriteFood;
    }

    public static String longestWord(List<String> words) {
        return words.stream().max(Comparator.comparingInt(String::length)).get();
    }
}
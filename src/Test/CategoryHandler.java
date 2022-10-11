package Test;

import java.util.HashMap;
import java.util.*;
import java.util.Scanner;


public class CategoryHandler {

    static Scanner scanner = new Scanner(System.in);
    public static List<Category> categoryList = new ArrayList<>(getCategory());



//    public static void SearchCategory(List<Category> categoryList) {
//
////        categoryList.stream()
////                .filter(category -> category.getCategoryName())
////}

    public static void createNewCategory() {
        System.out.println("Insert the name of the new category:");
        categoryList.add(new Category(scanner.nextLine().toUpperCase()));
    }
    public static void listCategories () {
        System.out.println(">Categories<");
        System.out.println("------------");
        categoryList.stream()
                .map(Category::category)
                .sorted()
                .forEach(System.out::println);

        TestMain.backToMenu();

    }

    public static List<Category> getCategory () {
        return List.of(
                new Category("FRUIT"),
                new Category("DAIRY"),
                new Category("CANDY"),
                new Category("BREAD"));
    }


}

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.lang.Integer;

public class Outline {
  public static void main(String... args) { // varargs alternative to String[]
    Integer[] intArray = {1,7,3,4,8,2};
    System.out.println(Arrays.asList(intArray));
    // Arrays.sort(intArray,.......)

    String[] fruitBowl = {"Celmentine", "Pineapple", "Lychee", "Fruit1", "Watermelon", "Apple", "Banana"};

    Arrays.sort(fruitBowl, (f1, f2) -> Integer.compare(f1.length(), f2.length()));
    System.out.println(Arrays.asList(fruitBowl));

    Arrays.sort(fruitBowl, (f1,f2)-> Integer.compare(f2.length(),f1.length()));
    System.out.println(Arrays.asList(fruitBowl));

    Arrays.sort(fruitBowl, (f1,f2) -> Integer.compare(f1.charAt(0), f2.charAt(0)));
    System.out.println(Arrays.asList(fruitBowl));

    Arrays.sort(fruitBowl, (f1,f2) -> {if (f1.contains("e") & !f2.contains("e")) return -1; return 0;});
    System.out.println(Arrays.asList(fruitBowl));

  } 
}

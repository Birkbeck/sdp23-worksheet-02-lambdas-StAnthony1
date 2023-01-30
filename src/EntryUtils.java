import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntryUtils {
    static String betterString(String s1, String s2, TwoStringPredicate f) {
        if (f.better(s1, s2)) return s1;
        return s2;
    }

    static String betterEntry(String s1, String s2, TwoGenericPredicate<String> f) {
        if (f.betterEntry(s1, s2)) return s1;
        return s2;
    }

    //Q5 static method
    static List<String> allMatches(List<String> l, Predicate<String> pred){
        l.removeIf(s -> !pred.f(s));
        return l;
    }
    //Q6 static method (generic)
    static <T> List<T> allMatches2(List<T> l, Predicate<T> pred){
        l.removeIf(s -> !pred.f(s));
        return l;
    }
    //Q7 static method (with String s only) - method refs replace
    static List<String> transformedList(List<String> l, TransformList f){
        l.replaceAll(f::transformer);
        //for (int i = 0; i < l.size(); i++) {
        //            l.set(i, f.transformer(l.get(i)));}
    return l;
    }

    //Q8
    static <T> List<T> transformGenList(List<T> l, GenericTransformList f) {
        for (int i = 0; i < l.size(); i++) {
            l.set(i, (T) f.genTransformer(l.get(i)));
        }
        return l;
    }

    public static void main(String[] args) {

        List<String> greetings = new ArrayList<>(List.of("Hi", "Hello", "G'day", "How do?"
                ,"alright?", "ciao", "Hey", "Hey Jude!" ));

        Integer[] intArray = {1,7,3,4,8,2};
        List<Integer> nums = Arrays.asList(intArray);
        List<Integer> nums1 = new ArrayList<>(List.of(1,7,3,4,8,2));

        TwoGenericPredicate<String> longest = (a, b) -> a.length() >= b.length();
        //System.out.println(betterString("Hi", "Hello", longest));
        System.out.println(betterEntry("Bonjour", "How are you?", longest));

        //Q5
        System.out.println(allMatches(greetings,(s)-> s.contains(" ")));

        //Q6
        System.out.println(allMatches2(greetings,(s)-> s.contains(" ")));

        System.out.println(allMatches2(nums1, (s)-> s%3 == 0));
        //nb didn't work with nums - was this because there is no Collection obj
        // instantiated at nums? This would mean the removeIf method in the static
        // method would have no type context.

        //Q7
        List<String> excitingWords = EntryUtils.transformedList(greetings, s -> s + "!");
        System.out.println(excitingWords);
        List<String> eyeWords = transformedList(greetings, s -> s.replace("i", "eye"));
        List<String> upperCaseWords = transformedList(greetings, String::toUpperCase);

        greetings.add("i");
        //Q8
        List<String> QuestioningWords = EntryUtils.transformGenList(greetings, s -> s + "?");
        System.out.println(QuestioningWords);
        List<String> EyeWords = EntryUtils.transformedList(greetings, s -> s.replace("i", "eye"));
        List<String> UpperCaseWords = EntryUtils.transformedList(greetings, String::toUpperCase);
        System.out.println(EyeWords);
        System.out.println(UpperCaseWords);
    }
}
import java.util.ArrayList;
import java.util.List;

public class EntryUtils {
    static String betterString(String s1, String s2, TwoStringPredicate f) {
        if (f.better(s1, s2)) return s1;
        return s2;
    }

    static String betterEntry(String s1, String s2, TwoGenericPredicate f) {
        if (f.betterEntry(s1, s2)) return s1;
        return s2;
    }

    static List<String> allMatches(List<String> l, Predicate<String> pred){
        l.removeIf(s -> !pred.f(s));
        return l;
    }

    public static void main(String[] args) {

        List<String> greetings = new ArrayList<>(List.of("Hi", "Hello", "G'day", "How do?"
                ,"alright?", "ciao", "Hey", "Hey Jude!" ));

        TwoGenericPredicate<String> longest = (a, b) -> a.length() >= b.length();
        //System.out.println(betterString("Hi", "Hello", longest));
        System.out.println(betterEntry("Bonjour", "How are you?", longest));

        //Q5
        System.out.println(allMatches(greetings,(s)-> s.contains("e")));


    }
}
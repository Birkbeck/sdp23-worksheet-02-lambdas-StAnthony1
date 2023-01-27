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

    //static List<String> allMatches(List<String> l, Predicate<String> pred){
        //l.removeIf(s -> !pred.f(s));
        //return l;
   // }
    static List<T> allMatches(List<T> l, Predicate<T> pred) {
        l.removeIf(s -> !pred.f(s));
        return l;
    } // - for this to work the lambda expression, pred, will have to
    // infer the type of the objects in the list to have access to its
    //methods - i.e. if List<String> you want access to charAt(), contains()

    public static void main(String[] args) {

        List<String> greetings = new ArrayList<>(List.of("Hi", "Hello", "G'day", "How do?"
                ,"alright?", "ciao", "Hey", "Hey Jude!" ));

        TwoGenericPredicate<String> longest = (a, b) -> a.length() >= b.length();
        //System.out.println(betterString("Hi", "Hello", longest));
        System.out.println(betterEntry("Bonjour", "How are you?", longest));

        //Q5
        List<String> wordsWithE = (allMatches(greetings,(s)-> s.contains("e")));
        System.out.println(wordsWithE);

        //6. how do you get the lambda to infer the type of the Objects in the list to have access
        // to that set of methods?
    }
}
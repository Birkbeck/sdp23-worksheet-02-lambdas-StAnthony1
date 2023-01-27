public class EntryUtils {
    static String betterString(String s1, String s2, TwoStringPredicate f) {
        if (f.better(s1, s2)) return s1;
        return s2;
    }

    static String betterEntry(String s1, String s2, TwoGenericPredicate<String> f) {
        if (f.betterEntry(s1, s2)) return s1;
        return s2;
    }

    public static void main(String[] args) {

        TwoGenericPredicate<String> longest = (a, b) -> a.length() >= b.length();
        //System.out.println(betterString("Hi", "Hello", longest));
        System.out.println(betterEntry("Bonjour", "How are you?", longest));


    }
}
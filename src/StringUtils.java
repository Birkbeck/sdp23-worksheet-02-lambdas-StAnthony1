public class StringUtils {
    static String betterString(String s1, String s2, TwoStringPredicate f) {
        if (f.better(s1, s2)) return s1;
        return s2;
    }

    public static void main(String[] args) {

        TwoStringPredicate longest = (a, b) -> a.length() >= b.length();
        System.out.println(betterString("Hi", "Hello", longest));

    }
}
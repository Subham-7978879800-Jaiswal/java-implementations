import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        int ar[] = { 1, 2, 34, 56, 7 };
        Integer arr[] = { 1, 2, 34 };

        IntStream arstream = Arrays.stream(ar); // IDEA -> IntStream
        Stream<Integer> stInt = Arrays.stream(arr); // IDEA -> Stream<Integer>

        // Dont use char Array above
        // we can use Character Array To get Stream<Character>

        char ch[] = { 'a', 'b', 'c' };
        // Arrays.stream(ch) // The method stream(T[]) in the type Arrays is not
        // applicable for the arguments (char[])Java(67108979)

        Character ch1[] = { 'a', 'b', 'c' };
        Stream<Character> xy = Arrays.stream(ch1); 

        String s = "Subham Jaiswal"; 

        List<Character> CharacterStream = s.chars().mapToObj(x -> (char)x).collect(Collectors.toList());

        System.out.println(CharacterStream);


    }

}

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaEightProblems {
    public static void main(String[] args) {
        String ar[]  = {"Subham Jaiswal", "Raj Ratan"};
        var x1 = Arrays.stream(ar).map(x -> x.split(" ")[0]).collect(Collectors.toList()); 
        System.out.println(x1);
    }
}

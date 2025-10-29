import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Integer x = 5; 
        var t = Optional.of(x); 
        System.out.println(t.get());

        // .of
        // .ofNullable
        // .get
        // .isPresent
        // .isAbsent
        // .orElseThrow
    }
}

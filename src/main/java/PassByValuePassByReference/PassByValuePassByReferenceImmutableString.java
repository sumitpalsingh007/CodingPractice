package PassByValuePassByReference;

public class PassByValuePassByReferenceImmutableString {

    public static void main(String[] args) {
        String value = "2";
        modify(value);
        System.out.println(value);
    }

    private static void modify(String input){
        //input = new String("3");
        input = input + "-4";
    }
}

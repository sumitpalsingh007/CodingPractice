package PassByValuePassByReference;

public class PassByValuePassByReferenceMutableStringBuilder {

    public static void main(String[] args) {
        StringBuilder value = new StringBuilder("2");
        modify(value);
        System.out.println(value);
    }

    private static void modify(StringBuilder input){
        //input = new StringBuilder("3");
        input.append("-4");
    }
}

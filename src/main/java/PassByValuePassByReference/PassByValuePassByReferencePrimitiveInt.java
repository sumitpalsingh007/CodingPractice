package PassByValuePassByReference;

public class PassByValuePassByReferencePrimitiveInt {

    public static void main(String[] args) {
        int value = 2;
        modify(value);
        System.out.println(value);
    }

    private static void modify(int input){
        input = 3;
    }
}

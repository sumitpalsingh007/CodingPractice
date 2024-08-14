package arrays;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.print.DocFlavor;

public class RomanToInteger {

    public static int romanToInt(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            Symbol current  = Symbol.fromString(s.substring(i, i+1));
            Symbol next = null;
            if(i + 1 < s.length()){
                next = Symbol.fromString(s.substring(i+1, i+2));
            }
            if(current.subs.contains(next)){
                sum = sum + next.value - current.value;
                i++;
            }else {
                sum = sum + current.value;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int lengthOfLastWord(String s){
        int sum = 0;
        boolean foundFirstWord = false;
        for(int i = s.length() -1; i >= 0; i--){
            String d = s.substring(i,i+1);
            if(!d.equals(" ")){
                sum = sum + 1;
                foundFirstWord = true;
            }
            if(foundFirstWord && d.equals(" ")){
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        //romanToInt("MCMXCIV");
        lengthOfLastWord("luffy is still joyboy");
    }

    private enum Symbol {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        static {
            I.subs = EnumSet.of(V, X);
            V.subs = EnumSet.noneOf(Symbol.class);
            X.subs = EnumSet.of(L, C);
            L.subs = EnumSet.noneOf(Symbol.class);
            C.subs = EnumSet.of(D, M);
            D.subs = EnumSet.noneOf(Symbol.class);
            M.subs = EnumSet.noneOf(Symbol.class);
        }

        private final int value;
        private Set<Symbol> subs;

        Symbol(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Symbol fromValue(int value) {
            for (Symbol symbol : Symbol.values()) {
                if (symbol.getValue() == value) {
                    return symbol;
                }
            }
            throw new IllegalArgumentException("No enum constant with value " + value);
        }

        public static Symbol fromString(String name) {
            try {
                return Symbol.valueOf(name);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("No enum constant with name " + name, e);
            }
        }
    }
}

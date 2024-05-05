import java.util.List;
import java.util.stream.Collectors;

public class MyClass{

    private Integer age;

    public synchronized void setAge(Integer age){
        synchronized (this.age){
            this.age = age;
        }
    }

    public Integer getAge(){
        synchronized (this.age){
            return age;
        }
    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

        List.of(1,2,3,4).stream().forEach(num -> sb.append(" | " + num));
        System.out.println(sb);
    }
}
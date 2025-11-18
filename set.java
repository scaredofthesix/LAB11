import java.util.*;
public class LAB{
    public static void main(String[] arg){
        Set<String> str = new HashSet<>();
        str.add("MAXIMA");
        str.add("SVYAT");
        str.add("DAVID");
        str.add("STEPAN");
        str.add("MARAT");
        Set<String> copy = new HashSet<>(str);
        for (String x : copy){
            if (x.length() % 2 != 0){
                str.remove(x);
            }
        }
        System.out.println(str);
    }
}

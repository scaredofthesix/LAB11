import java.util.*;

class Animal {
    String name;
    int weight;

    Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public void getInfo() {
        System.out.println(name + " - " + weight + " kg");
    }

}
class Activities{
    List<Animal> arr;
    public Activities(List<Animal> arr){
        this.arr = arr;
    }
    public void show(){
        for(int i = 0;i < arr.size();i++){
            arr.get(i).getInfo();
        }
    }
    public void removing(int n){
        arr.remove(n);
    }
    public void update(int n,Animal x){
        arr.set(n,x);
    }
    public void adding(Animal x){
        arr.add(x);
    }
}

public class LAB{
    public static void main(String[] arg) {
        List<Animal> a = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        a.add(new Animal("ЖИРАФ", 500));
        a.add(new Animal("ЛЕВ", 300));
        Activities act = new Activities(a);
        act.removing(0);
        act.update(0,new Animal("ОБЕЗЬЯНА",50));
        act.adding(new Animal("ГОРИЛЛА",500));
        act.show();

    }
}


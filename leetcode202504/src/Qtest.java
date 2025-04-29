import java.util.HashMap;
import java.util.Map;

public class Qtest {
    public static void main(String[] args) {
        Man f=new Man(2,"yyy",null);
        Man man=new Man(3,"ggg",f);
        Map<Integer,Man> map=new HashMap<>();
        map.put(1,man);
        man.name="gyy";
        f.name="tat";
        System.out.println(map.get(1).friend.name);
    }
}
class Man{
    int age;
    String name;
    Man friend;
    public Man(int age,String name,Man friend){
        this.age=age;
        this.name=name;
        this.friend=friend;
    }
}

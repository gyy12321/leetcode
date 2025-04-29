import java.util.HashMap;

class Man {
    String name;
    int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Temp1 {
    public static void main(String[] args) {
        HashMap<Man, String> map = new HashMap<>();

        Man man1 = new Man("John", 30);
        Man man2 = new Man("John", 30);

        map.put(man1, "Engineer");
        map.put(man2, "Doctor");

        System.out.println(map.size());  // 输出：2
        System.out.println(map.get(man1));  // 输出：Engineer
        System.out.println(map.get(man2));  // 输出：Doctor
    }
}
package Demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        DemoStudent student1 = new DemoStudent("Nam",20, "HN");
        DemoStudent student2 = new DemoStudent("Hung",21, "HN");
        DemoStudent student3 = new DemoStudent("Ha",22, "HN");
        Map<Integer, DemoStudent> studentMap = new HashMap<Integer, DemoStudent>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);

        for(Map.Entry<Integer, DemoStudent> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<DemoStudent> students = new HashSet<DemoStudent>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for(DemoStudent student : students){
            System.out.println(student.toString());
        }
    }
}

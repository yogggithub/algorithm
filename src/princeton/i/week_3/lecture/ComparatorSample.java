package princeton.i.week_3.lecture;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSample {
    public static void main(String[] args) {
        Student[] s = new Student[]{
                new Student("A", "3"),
                new Student("B", "2"),
                new Student("C", "1")
        };
        Arrays.sort(s, Student.BY_NAME);
        Arrays.stream(s).forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~");
        Arrays.sort(s, Student.BY_SECTION);
        Arrays.stream(s).forEach(System.out::println);
    }
}

class Student {
    private String name, section;

    public Student(String name, String section) {
        this.name = name;
        this.section = section;
    }

    // comparators for student.class
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", section='" + section + '\'' +
               '}';
    }

    private static class ByName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class BySection implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.section.compareTo(o2.section);
        }
    }
}
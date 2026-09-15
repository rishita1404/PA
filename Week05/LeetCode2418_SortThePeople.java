package Week05;
import java.util.Arrays;
public class LeetCode2418_SortThePeople {
    static class Person {
        String name;
        int height;
        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people, (a, b) -> Integer.compare(b.height, a.height));
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = people[i].name;
        }
        return result;
    }
    public static void main(String[] args) {
        String[] names1 = { "Mary", "John", "Emma" };
        int[] heights1 = { 180, 165, 170 };
        System.out.println("Sorted People: " + Arrays.toString(sortPeople(names1, heights1)));
        String[] names2 = { "Alice", "Bob", "Bob" };
        int[] heights2 = { 155, 185, 150 };
        System.out.println("Sorted People: " + Arrays.toString(sortPeople(names2, heights2)));
    }
}

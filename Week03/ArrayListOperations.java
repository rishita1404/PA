package Week03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ArrayListOperations {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Core ArrayList Operations ===");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");
        list.add(2, "Go");
        System.out.println("After Additions: " + list);
        String first = list.get(0);
        String third = list.get(2);
        System.out.printf("Element at index 0: %s | Element at index 2: %s%n", first, third);
        String oldVal = list.set(1, "Rust");
        System.out.printf("Updated index 1 from '%s' to '%s'%n", oldVal, list.get(1));
        System.out.println("Current List: " + list);
        list.remove(3);
        list.remove("JavaScript");
        System.out.println("After Removals: " + list);
        boolean containsJava = list.contains("Java");
        boolean containsPython = list.contains("Python");
        int indexOfRust = list.indexOf("Rust");
        boolean isEmpty = list.isEmpty();
        int size = list.size();
        System.out.println("Contains 'Java': " + containsJava);
        System.out.println("Contains 'Python': " + containsPython);
        System.out.println("Index of 'Rust': " + indexOfRust);
        System.out.println("List Size: " + size);
        System.out.println("Is Empty: " + isEmpty);
        Collections.sort(list);
        System.out.println("Sorted List: " + list);
        list.clear();
        System.out.println("After clear(): size = " + list.size() + ", isEmpty = " + list.isEmpty());
    }
}

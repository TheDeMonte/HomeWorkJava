import java.util.*;

public class Phonebook{

    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        String[][] contacts = {
            {"Alice", "123456"},
            {"Bob", "789012"},
            {"Alice", "654321"},
            {"Alice", "987654"},
            {"Bob", "345678"}
        };
        for (String[] contact : contacts) {
            String name = contact[0];
            String phone = contact[1];
            phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
        }
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
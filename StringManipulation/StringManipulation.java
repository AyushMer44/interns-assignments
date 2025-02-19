import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        
        // Count words
        String[] words = sentence.trim().split("\\s+");
        int wordCount = words.length;
        
        // Reverse words
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }
        
        // Replace spaces with hyphens
        String modifiedSentence = sentence.replace(" ", "-");
        
        // Output results
        System.out.println("Number of words: " + wordCount);
        System.out.println("Reversed sentence: " + reversedSentence.toString().trim());
        System.out.println("Modified sentence: " + modifiedSentence);
        
        scanner.close();
    }
}
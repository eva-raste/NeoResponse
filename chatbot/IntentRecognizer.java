package chatbot;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.stemmer.PorterStemmer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntentRecognizer {
    private final SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
    private final PorterStemmer stemmer = new PorterStemmer();
    
    private final Set<String> greetingWords = new HashSet<>(Arrays.asList(
        "hello", "hi", "hey", "greet", "hola", "sup", "yo"));
    
    private final Set<String> feelingWords = new HashSet<>(Arrays.asList(
        "how", "are", "you", "feeling", "doing", "feel", "mood"));
    
    private final Set<String> goodbyeWords = new HashSet<>(Arrays.asList(
        "bye", "goodbye", "see", "later", "farewell", "exit", "quit"));
    
    private final Set<String> thanksWords = new HashSet<>(Arrays.asList(
        "thank", "thanks", "appreciate", "grateful"));
    
    private final Set<String> jokeWords = new HashSet<>(Arrays.asList(
        "joke", "funny", "laugh", "humor", "kidding"));
    
    private final Set<String> helpWords = new HashSet<>(Arrays.asList(
        "help", "support", "problem", "issue", "what", "can", "do"));
    
    private final Set<String> timeWords = new HashSet<>(Arrays.asList(
        "time", "clock", "hour", "minute", "current"));
    
    private final Set<String> dateWords = new HashSet<>(Arrays.asList(
        "date", "day", "month", "year", "today"));

    public String detectIntent(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "unknown";
        }
        
        try {
            Set<String> stemSet = Arrays.stream(tokenizer.tokenize(input.toLowerCase()))
                                      .map(stemmer::stem)
                                      .collect(Collectors.toSet());
            
            return determineIntentFromStems(stemSet);
            
        } catch (Exception e) {
            System.err.println("Error processing input: " + input);
            return "unknown";
        }
    }
    
    private String determineIntentFromStems(Set<String> stems) {
        if (containsAny(stems, greetingWords)) {
            return "greeting";
        }
        else if (stems.contains("how") && stems.contains("you")) {
            return "feeling";
        }
        else if (containsAny(stems, goodbyeWords)) {
            return "goodbye";
        }
        else if (containsAny(stems, thanksWords)) {
            return "thanks";
        }
        else if (containsAny(stems, jokeWords)) {
            return "joke";
        }
        else if (containsAny(stems, helpWords) || 
                (stems.contains("what") && stems.contains("do"))) {
            return "help";
        }
        else if (containsAny(stems, timeWords) || 
                (stems.contains("what") && stems.contains("time"))) {
            return "time";
        }
        else if (containsAny(stems, dateWords) || 
                (stems.contains("what") && stems.contains("date"))) {
            return "date";
        }
        else {
            return "unknown";
        }
    }
    
    private boolean containsAny(Set<String> stems, Set<String> words) {
        return words.stream().anyMatch(stems::contains);
    }
}
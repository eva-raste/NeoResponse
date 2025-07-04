package chatbot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ResponseGenerator {
    private final Random random = new Random();
    
    private String[] greetings = {
        "Hello there!",
        "Hi! How can I help you today?",
        "Greetings! What can I do for you?",
        "Hey! Nice to see you.",
        "What's up! How can I assist you?"
    };
    
    private String[] feelingResponses = {
        "I'm doing great! How about you?",
        "I'm just a chatbot, but I'm functioning well!",
        "All systems operational! How can I help you today?",
        "I'm always happy to help. What's on your mind?"
    };
    
    private String[] goodbyeResponses = {
        "Goodbye! Have a wonderful day!",
        "See you later!",
        "Bye! Come back anytime!",
        "Farewell! Until next time!"
    };
    
    private String[] thanksResponses = {
        "You're welcome!",
        "Happy to help!",
        "My pleasure!",
        "No problem at all!"
    };
    
    private String[] jokeResponses = {
        "Why don't scientists trust atoms? Because they make up everything!",
        "Did you hear about the mathematician who's afraid of negative numbers? He'll stop at nothing to avoid them!",
        "Why don't skeletons fight each other? They don't have the guts!",
        "I'm reading a book about anti-gravity. It's impossible to put down!"
    };
    
    private String[] helpResponses = {
        "I can help with general questions, tell you the time/date, tell jokes, and more. Just ask!",
        "I can answer questions, tell jokes, or just chat. What would you like to do?",
        "Need help? I can tell you the time, date, or share a joke. Just ask!"
    };
    
    private String[] timeResponses = {
        "The current time is %s",
        "It's %s right now",
        "My clock shows %s"
    };
    
    private String[] dateResponses = {
        "Today's date is %s",
        "It's %s today",
        "According to my calendar, it's %s"
    };
    
    private String[] unknownResponses = {
        "I'm not sure I understand. Could you try asking differently?",
        "That's an interesting question. I'm still learning though.",
        "Could you rephrase that? I want to make sure I understand."
    };

    public String generateResponse(String intent, String userInput) {
        switch(intent.toLowerCase()) {
            case "greeting":
                return getRandomResponse(greetings);
                
            case "feeling":
                return getRandomResponse(feelingResponses);
                
            case "goodbye":
                return getRandomResponse(goodbyeResponses);
                
            case "thanks":
                return getRandomResponse(thanksResponses);
                
            case "joke":
                return getRandomResponse(jokeResponses);
                
            case "help":
                return getRandomResponse(helpResponses);
                
            case "time":
                String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
                return String.format(getRandomResponse(timeResponses), time);
                
            case "date":
                String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
                return String.format(getRandomResponse(dateResponses), date);
                
            default:
                return getRandomResponse(unknownResponses);
        }
    }
    
    private String getRandomResponse(String[] responses) {
        return responses[random.nextInt(responses.length)];
    }
}
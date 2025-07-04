package chatbot;


import java.util.Scanner;

public class Chatbot {
    private IntentRecognizer intentRecognizer;
    private ResponseGenerator responseGenerator;
    private Scanner scanner;
    
    public Chatbot() {
        this.intentRecognizer = new IntentRecognizer();
        this.responseGenerator = new ResponseGenerator();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("Chatbot: Hello! I'm your intelligent assistant. How can I help you today?");
        System.out.println("Chatbot: Type 'exit' to end our conversation.");
        
        while(true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            
            if(userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }
            
            String intent = intentRecognizer.detectIntent(userInput);
            String response = responseGenerator.generateResponse(intent, userInput);
            
            System.out.println("Chatbot: " + response);
        }
        
        scanner.close();
    }
}
# NeoResponse - Smart Java Response Assistant

**IntelliBot** is a lightweight Java-based command-line assistant capable of understanding user intent and responding with contextually relevant replies. It acts like a mini personal assistant that recognizes simple natural language queries such as asking for jokes, time, date, and can be extended to handle more intelligent responses with ease.

---

##  Features

 **Intent Recognition**  
- Analyzes user input to detect query type using keyword-based NLP-like logic.

 **Smart Responses**  
- Returns witty jokes, current time/date, or fallback responses if the query is ambiguous.

 **Modular Architecture**  
- Clear separation of concerns using classes:
  - `Main.java`: Entry point for user interaction.
  - `IntentRecognizer.java`: Identifies user intent.
  - `ResponseGenerator.java`: Generates appropriate response.
  - `Chatbot.java`: Bridges intent with output.

 **Easily Extendable**  
- Add more intents and responses just by updating logic in the `IntentRecognizer` and `ResponseGenerator`.

 **Great for Beginners & Interviews**  
- Demonstrates clean Java OOP principles and can be a portfolio gem!

---

## Example Interactions

```txt
> What’s the time?
 It's currently 15:32:17

> Tell me a joke
 Why don't scientists trust atoms? Because they make up everything!

> What’s today’s date?
 Today is 03 July 2025

> Can you help me?
 Sorry, I didn't understand that. Can you try again?


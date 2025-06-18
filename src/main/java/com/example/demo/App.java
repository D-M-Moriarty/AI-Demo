package com.example.demo;

/**
 * Main application class for GitHub Copilot demonstration.
 * This class provides a starting point for showcasing Copilot Chat features.
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("Hello, GitHub Copilot!");
        
        // TODO: Add more demonstration code here
        // Perfect place to show Copilot Chat generating code
        
        App app = new App();
        app.greetUser("Developer");
    }
    
    /**
     * Greets a user with a personalized message.
     * @param name The name of the user to greet
     */
    public void greetUser(String name) {
        System.out.println("Welcome to the GitHub Copilot demo, " + name + "!");
    }
}

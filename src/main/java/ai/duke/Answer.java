package ai.duke;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class Answer {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {}
}

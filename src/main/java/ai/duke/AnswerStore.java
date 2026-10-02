package ai.duke;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AnswerStore {

    private final Map<String, String> answers = new ConcurrentHashMap<>();

    public void put(String question, String answer) {
        answers.put(question, answer);
    }

    public String get(String question) {
        return answers.get(question);
    }
}

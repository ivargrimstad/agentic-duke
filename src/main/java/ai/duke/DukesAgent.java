package ai.duke;

import jakarta.ai.agent.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Agent(name ="DukesAgent", description = "Dukes AI Agent")
public class DukesAgent {

    @Inject
    private LargeLanguageModel model;

    @Inject
    private Answer answer;

    @Trigger
    public void analyzeEvent(@Valid Message message) {
        System.out.println("DukesAgent analyzeEvent");
    }

    @Decision
    public Result proceed(Message message) {
        System.out.println("DukesAgent proceed");
        return new Result(true, message);
    }

    @Action
    public void doStuff(Message message) {
        System.out.println("DukesAgent doStuff");
        answer.setMessage(model.query(message.message()));
    }


}

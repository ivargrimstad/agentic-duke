package ai.duke;

import jakarta.ai.agent.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Agent(name ="DukesAgent", description = "Dukes AI Agent")
@ApplicationScoped
public class DukesAgent {

    @Inject
    private LargeLanguageModel model;

    @Inject
    private AnswerStore answerStore;

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
    public Answer doStuff(Message message) {
        System.out.println("DukesAgent doStuff");
        String result = model.query(message.message());
        System.out.println(result);
        return new Answer(result);
    }

    @Outcome
    public void finalizeResponse(Message message, Answer answer) {
        System.out.println("DukesAgent finalizeResponse");
        System.out.println(answer.message()) ;

        answerStore.put(message.message(),answer.message());
    }

}

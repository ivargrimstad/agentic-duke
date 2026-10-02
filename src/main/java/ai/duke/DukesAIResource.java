package ai.duke;

import jakarta.ai.agent.LargeLanguageModel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("ai")
@RequestScoped
public class DukesAIResource {

    @Inject
    private Event<Message> messageEvent;

    @Inject
    private AnswerStore answerSore;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String callAI(@QueryParam("message") String message) {
        System.out.println("DukesAgent callAI");
        messageEvent.fire(new Message(message));

        System.out.println("DukesAgent callAI result= " + answerSore.get(message));
        return answerSore.get(message);
    }
}
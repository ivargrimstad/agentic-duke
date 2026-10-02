/*
 * Copyright (c) 2026 Ivar Grimstad
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package ai.duke;

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
    private DukesStore answerSore;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String callAI(@QueryParam("message") String message) {
        System.out.println("DukesAgent callAI");
        messageEvent.fire(new Message(message));

        System.out.println("DukesAgent callAI result= " + answerSore.get(message));
        return answerSore.get(message);
    }
}
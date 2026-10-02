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
        return new Result(true, "Looks good to me");
    }

    @Action
    public Answer doStuff(Message message) {

        System.out.println("DukesAgent doStuff");
        return new Answer(model.query(message.message()));
    }

    @Outcome
    public void finalizeResponse(Message message, Answer answer) {

        System.out.println("DukesAgent finalizeResponse");
        answerStore.put(message.message(),answer.message());
    }

}

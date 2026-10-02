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

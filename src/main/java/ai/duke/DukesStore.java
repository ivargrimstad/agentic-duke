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
public class DukesStore {

    private final Map<String, String> responses = new ConcurrentHashMap<>();

    public void put(String prompt, String response) {
        responses.put(prompt, response);
    }

    public String get(String message) {
        return responses.get(message);
    }
}

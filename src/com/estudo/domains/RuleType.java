package com.estudo.domains;

import java.util.Arrays;

import static java.lang.String.format;

public enum RuleType {
    REMOVE("rm", "Removes files that match with a regex in a path"),
    RECURSIVE_REMOVE("rmr", "Removes recursively files that match with a regex in a path"),
    ORGANIZE_BY_TYPE("cl", "Classify files in a folder by kind");

    private String command;

    private String description;

    RuleType(String command, String description) {
        this.description = description;
        this.command = command;
    }

    public RuleType getByCommand(final String command) {
        return Arrays.stream(RuleType.values())
                .filter(ruleType -> ruleType.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(format("Rule type by command %s not found", command)));
    }
}

package com.estudo.util;

import java.util.List;

public class MatchPattern {

    public static final String REGEX = "\\*";
    public static final String SPECIAL_CHAR = "*";

    private MatchPattern() {

    }

    public static boolean match(final List<String> patterns, final String name) {
        for (String pattern : patterns) {
            final String patternWithoutSpecialChar = pattern.replaceAll(REGEX, "");
            if (name.equals(pattern)) {
                return true;
            } else if (name.contains(patternWithoutSpecialChar)) {
                return pattern.startsWith(SPECIAL_CHAR) && pattern.endsWith(SPECIAL_CHAR) ||
                        pattern.startsWith(SPECIAL_CHAR) && name.endsWith(patternWithoutSpecialChar) ||
                        pattern.endsWith(SPECIAL_CHAR) && name.startsWith(patternWithoutSpecialChar);
            }
        }
        return false;
    }
}

package com.estudo;

import com.estudo.rules.RemoveRule;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        final File fileDirectory = new File("/Users/douglas.calvancante/Desktop/teste_remove");
        final RemoveRule applyRemoveRule = new RemoveRule();

        applyRemoveRule.run(fileDirectory);
    }
}

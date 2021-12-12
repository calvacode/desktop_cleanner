package com.estudo;

import com.estudo.gateway.imply.FileConfigurationImpl;
import com.estudo.usecases.rules.OrganizeFilesRule;
import com.estudo.usecases.rules.RemoveEmptyDirectoriesRule;
import com.estudo.util.MatchPattern;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final List<String> patternList = new FileConfigurationImpl().get("./resource/organize");

        final File origin = new File("/Users/douglas.calvancante/Downloads");
        final File destiny = new File("/Users/douglas.calvancante/Desktop");

        new OrganizeFilesRule().run(origin, destiny, (fileName) -> MatchPattern.match(patternList, fileName));

        new RemoveEmptyDirectoriesRule().run(origin, (fileName) -> MatchPattern.match(patternList, fileName));
    }
}

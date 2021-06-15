package com.estudo.usecases.rules;

import com.estudo.util.MatchPattern;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

public class RecursivelyRemoveRule implements Rule {

    private static final String CONFIG_NAME = "resource/files_to_remove";

    private final static List<String> patterList = Arrays.asList("");

    @Override
    public void run(final File fileDirectory) {
        if (Objects.nonNull(fileDirectory) && Objects.nonNull(fileDirectory.listFiles())) {
            for (File file : fileDirectory.listFiles()) {
                if (file.isDirectory()) {
                    this.run(new File(file.getAbsolutePath()));
                } else {
                    if (MatchPattern.match(patterList, file.getName())) {
                        file.deleteOnExit();
                        System.out.println(format("%s pattern was remove", file.getName()));
                    }
                }
            }
        }
    }

}


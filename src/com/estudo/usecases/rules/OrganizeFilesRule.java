package com.estudo.usecases.rules;

import com.estudo.util.MatchPattern;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

public class OrganizeFilesRule implements Rule {

    private final List<String> filePattern;

    public OrganizeFilesRule(final List<String> filePattern) {
        this.filePattern = filePattern;
    }

    @Override
    public void run(final File fileDirectory) {
        if (Objects.nonNull(fileDirectory) && Objects.nonNull(fileDirectory.listFiles())) {
            for (File file : fileDirectory.listFiles()) {
                if (file.isDirectory()) {
                    this.run(new File(file.getAbsolutePath()));
                } else if (MatchPattern.match(filePattern, file.getName())) {
                    
                    file.
                    file.renameTo(new File());
                    System.out.println(format("%s pattern was move", file.getName()));
                }
            }
        }
    }

}


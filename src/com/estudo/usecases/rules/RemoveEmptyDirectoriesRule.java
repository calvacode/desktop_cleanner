package com.estudo.usecases.rules;

import java.io.File;
import java.util.Arrays;
import java.util.function.Function;

public class RemoveEmptyDirectoriesRule implements RemoveRule {

    @Override
    public void run(final File fileDirectory, final Function<String, Boolean> match) {
        if (fileDirectory.isDirectory()) {
            Arrays.stream(fileDirectory.listFiles())
                    .filter(file -> !fileDirectory.isHidden())
                    .forEach(directory -> run(directory, match));

            if ( fileDirectory.listFiles().length == 0 || fileDirectory.listFiles().length == 1 && ".DS_Store".equals(fileDirectory.listFiles()[0].getName())){
                fileDirectory.deleteOnExit();
            }
        }

    }
}

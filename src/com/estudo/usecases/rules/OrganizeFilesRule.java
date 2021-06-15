package com.estudo.usecases.rules;

import com.estudo.util.FileExtension;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

import static java.lang.String.format;

public class OrganizeFilesRule implements OrganizeRule {

    public void run(final File origin, final File destiny, Function<String, Boolean> match) {
        if (origin.isDirectory() && destiny.isDirectory()) {
            apply(origin, destiny, match);
        }
    }

    private void apply(final File fileDirectory, final File rootDirectory, Function<String, Boolean> match) {
        if (Objects.nonNull(fileDirectory) && Objects.nonNull(fileDirectory.listFiles())) {
            for (File file : fileDirectory.listFiles()) {
                if (file.isDirectory()) {
                    this.apply(new File(file.getAbsolutePath()), rootDirectory, match);
                } else if (match.apply(file.getName())) {
                    final String fileExtension = getFileExtension(file);
                    if (Arrays.stream(rootDirectory.listFiles()).filter(File::isDirectory).noneMatch(f -> f.getName().equals(fileExtension))){
                        new File(rootDirectory.getAbsolutePath().concat("/").concat(fileExtension)).mkdir();
                    }
                    file.renameTo(new File(rootDirectory.getAbsolutePath().concat("/").concat(fileExtension).concat("/").concat(file.getName())));
                    System.out.println(format("%s pattern was move", file.getName()));
                }
            }
        }

    }

    private String getFileExtension(final File file) {
        try {
            return FileExtension.get(file);
        } catch (InvalidObjectException | FileExtension.UnknownExtensionException e) {
            return "UNKNOWN";
        }
    }

}


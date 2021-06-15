package com.estudo.util;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.Objects;

public class FileExtension {

    private FileExtension(){}

    public static String get(final File file) throws InvalidObjectException, UnknownExtensionException {
        if(Objects.isNull(file)){
            throw new InvalidObjectException("File must not be null");
        } else if(isNotFileWithExplicitExtension(file)){
            throw new UnknownExtensionException();
        }

        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }


    private static boolean isNotFileWithExplicitExtension(File file) {
        return !file.getName().contains(".");
    }

    public static class UnknownExtensionException extends RuntimeException {
        private UnknownExtensionException(){
            super("Unknown extension");
        }

    }
}

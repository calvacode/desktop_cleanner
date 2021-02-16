package com.estudo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadConfig {

    public static List<String> read(final String configName) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(configName);
            BufferedReader bf = new BufferedReader(fileReader);
            lines =  bf.lines().collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

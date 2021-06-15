package com.estudo.gateway.imply;

import com.estudo.gateway.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileConfigurationImpl implements Configuration<String> {

    @Override
    public List<String> get(final String filePath) {

        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bf = new BufferedReader(fileReader);
            lines =  bf.lines().collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

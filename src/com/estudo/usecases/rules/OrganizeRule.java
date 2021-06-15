package com.estudo.usecases.rules;

import java.io.File;
import java.util.function.Function;

public interface OrganizeRule extends Rule {

    void run(File origin, File destiny, Function<String, Boolean> match);
}

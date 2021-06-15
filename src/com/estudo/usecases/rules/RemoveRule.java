package com.estudo.usecases.rules;

import java.io.File;
import java.util.function.Function;

public interface RemoveRule extends Rule {

    void run(final File fileDirectory, Function<String, Boolean> match);

}

package com.estudo.gateway;

import java.util.List;

public interface Configuration<T extends Object> {

    List<T> get(String id);
}

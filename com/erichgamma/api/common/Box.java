package com.erichgamma.api.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box<T> {
    private Map<String, T> box;

    public Box() {
        this.box = new HashMap<>();
    }

    public T put(String k, T v) {
        return box.put(k, v);
    }

    public T get(String k) {
        return box.get(k);
    }

    public int size() {
        return box.size();
    }

    public T remove(String k) {
        return box.remove(k);
    }

    public void clear() {
        box.clear();
    }

    public void put(List<String> keys, Inventory<T> values) {
        box = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            box.put(keys.get(i), values.get(i));
        }
        box.forEach((k, v) -> {
            System.out.printf("%s, %s", k, v);
        });
    }

}

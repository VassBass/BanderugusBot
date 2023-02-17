package com.vassbassapp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionHelper <O> {
    private final List<O> collection;

    public CollectionHelper(Collection<O>collection){
        this.collection = new ArrayList<>(collection);
    }

    public List<O> getRandom(int length) {
        Collections.shuffle(collection);

        if (length >= collection.size()) {
            return collection;
        } else {
            return collection.subList(0, length);
        }
    }
}

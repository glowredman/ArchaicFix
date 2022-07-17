package org.embeddedt.archaicfix.occlusion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RecyclingList<T> {

    private Supplier<T> constructor;

    int nextIndex;
    private List<T> list;

    public RecyclingList(Supplier<T> constructor) {
        this.constructor = constructor;
        this.list = new ArrayList<T>();
    }

    public T get(int i) {
        while(list.size() <= i) {
            list.add(constructor.get());
        }
        return list.get(i);
    }

    public T next() {
        return get(nextIndex++);
    }

    public void reset() {
        nextIndex = 0;
    }

    public List<T> getAsList() {
        return list.subList(0, nextIndex);
    }
}

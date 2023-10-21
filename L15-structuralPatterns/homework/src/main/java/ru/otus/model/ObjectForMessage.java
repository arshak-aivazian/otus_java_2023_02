package ru.otus.model;

import java.util.List;
import java.util.Optional;

public class ObjectForMessage implements Prototype<ObjectForMessage> {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ObjectForMessage{" +
                "data=" + data +
                '}';
    }

    @Override
    public ObjectForMessage copy() {
        var copyObject = new ObjectForMessage();
        var copyData = Optional.ofNullable(data).map(List::copyOf).orElse(null);
        copyObject.setData(copyData);
        return copyObject;
    }
}

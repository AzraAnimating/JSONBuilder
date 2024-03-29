package de.azraanimating.jsonbuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONBuilder {

    private final HashMap<String, String> objects;
    private final ArrayList<String> objectNames;

    public JSONBuilder() {
        this.objects = new HashMap<>();
        this.objectNames = new ArrayList<>();
    }

    public JSONBuilder createObject(String name, String value) {
        if(value.startsWith("{") && value.endsWith("}") || value.startsWith("[") && value.endsWith("]")) {
            this.objects.put(name, value);
        } else {
            this.objects.put(name, "\"" + value + "\"");
        }
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, int value) {
        this.objects.put(name,  Integer.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, long value) {
        this.objects.put(name,  Long.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, double value) {
        this.objects.put(name,  Double.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, float value) {
        this.objects.put(name,  Float.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, short value) {
        this.objects.put(name,  Short.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, byte value) {
        this.objects.put(name,  Byte.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, boolean value) {
        this.objects.put(name,  Boolean.toString(value));
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, JSONBuilder value) {
        this.objects.put(name,  value.build());
        this.objectNames.add(name);
        return this;
    }

    public JSONBuilder createObject(String name, Object value) {
        this.objects.put(name,  value.toString());
        this.objectNames.add(name);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (int i = 0 ; i < this.objectNames.size() ; i++) {
            builder.append("\"").append(this.objectNames.get(i)).append("\"").append(" : ").append(this.objects.get(this.objectNames.get(i)));
            if(i < this.objectNames.size() - 1) {
                builder.append(" , ");
            }
        }
        builder.append(" }");
        return builder.toString();
    }

}

package de.azraanimating.jsonbuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONBuilder {

    private HashMap<String, String> objects;
    private ArrayList<String> objectNames;

    public JSONBuilder() {
        this.objects = new HashMap<>();
        this.objectNames = new ArrayList<>();
    }

    public void createObject(String name, String value) {
        this.objects.put(name, "\"" + value + "\"");
        this.objectNames.add(name);
    }

    public void createObject(String name, int value) {
        this.objects.put(name,  Integer.toString(value));
        this.objectNames.add(name);
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
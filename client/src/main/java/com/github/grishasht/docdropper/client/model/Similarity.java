package com.github.grishasht.docdropper.client.model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Similarity
{
    private final SimpleStringProperty name;
    private final SimpleFloatProperty size;
    private final SimpleStringProperty similarity;

    public Similarity(String name, Float size, Float similarity) {
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleFloatProperty(size);
        this.similarity = new SimpleStringProperty(similarity + "%");
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public float getSize()
    {
        return size.get();
    }

    public void setSize(float size)
    {
        this.size.set(size);
    }

    public String getSimilarity()
    {
        return similarity.get();
    }

    public void setSimilarity(String similarity)
    {
        this.similarity.set(similarity);
    }

}

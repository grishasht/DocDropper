package com.github.grishasht.docdropper.client.model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class File
{
    private final SimpleStringProperty name;
    private final SimpleFloatProperty size;
    private final SimpleStringProperty uploadedDate;
    private final SimpleStringProperty modifiedDate;

    public File(String name, Float size, String uploadedDate, String modifiedDate) {
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleFloatProperty(size);
        this.uploadedDate = new SimpleStringProperty(uploadedDate);
        this.modifiedDate = new SimpleStringProperty(modifiedDate);
    }

    public String getName()
    {
        return name.get();
    }

    public float getSize()
    {
        return size.get();
    }

    public String getUploadedDate()
    {
        return uploadedDate.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public void setSize(float size)
    {
        this.size.set(size);
    }

    public void setUploadedDate(String uploadedDate)
    {
        this.uploadedDate.set(uploadedDate);
    }

    public String getModifiedDate()
    {
        return modifiedDate.get();
    }

    public void setModifiedDate(String modifiedDate)
    {
        this.modifiedDate.set(modifiedDate);
    }
}

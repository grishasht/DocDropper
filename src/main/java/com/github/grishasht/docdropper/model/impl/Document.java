package com.github.grishasht.docdropper.model.impl;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.grishasht.docdropper.model.IDocument;

@Entity
@Table(name = "documents")
public class Document implements IDocument
{
    @Id
    @GeneratedValue
    private Integer id;
    private UUID guid;
    private String name;
    private Long size;
    private String format;
    private Timestamp dateUploaded;
    private Timestamp dateLastModified;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_user")
    private User user;

    public Document()
    {
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public Document setId(Integer id)
    {
        this.id = id;
        return this;
    }

    @Override
    public UUID getGuid()
    {
        return guid;
    }

    @Override
    public Document setGuid(UUID guid)
    {
        this.guid = guid;
        return this;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Document setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public Long getSize()
    {
        return size;
    }

    @Override
    public Document setSize(Long size)
    {
        this.size = size;
        return this;
    }

    @Override
    public String getFormat()
    {
        return format;
    }

    @Override
    public Document setFormat(String format)
    {
        this.format = format;
        return this;
    }

    @Override
    public Timestamp getDateUploaded()
    {
        return dateUploaded;
    }

    @Override
    public Document setDateUploaded(Timestamp dateUploaded)
    {
        this.dateUploaded = dateUploaded;
        return this;
    }

    @Override
    public Timestamp getDateLastModified()
    {
        return dateLastModified;
    }

    @Override
    public Document setDateLastModified(Timestamp dateLastModified)
    {
        this.dateLastModified = dateLastModified;
        return this;
    }

    @Override
    public User getUser()
    {
        return user;
    }

    @Override
    public Document setUser(User user)
    {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Document document = (Document) o;
        return Objects.equals(getId(), document.getId()) &&
                Objects.equals(getGuid(), document.getGuid()) &&
                Objects.equals(getName(), document.getName()) &&
                Objects.equals(getSize(), document.getSize()) &&
                Objects.equals(getFormat(), document.getFormat()) &&
                Objects.equals(getDateUploaded(), document.getDateUploaded()) &&
                Objects.equals(getDateLastModified(), document.getDateLastModified()) &&
                Objects.equals(getUser(), document.getUser());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getGuid(), getName(), getSize(), getFormat(), getDateUploaded(), getDateLastModified(), getUser());
    }

    @Override
    public String toString()
    {
        return "Document:\n" +
                "\tid = " + id + "\n" +
                "\tguid = " + guid + "\n" +
                "\tname = " + name + "\n" +
                "\tsize = " + size + "\n" +
                "\tformat = " + format + "\n" +
                "\tdateUploaded = " + dateUploaded + "\n" +
                "\tdateLastModified = " + dateLastModified + "\n" +
                "\tuser = " + user;
    }
}

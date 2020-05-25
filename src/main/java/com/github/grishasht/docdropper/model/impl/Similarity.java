package com.github.grishasht.docdropper.model.impl;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.grishasht.docdropper.model.ISimilarity;

@Entity
@Table(name = "similarities")
public class Similarity implements ISimilarity
{
    @Id
    @GeneratedValue
    private Integer id;
    private Long idFirstDoc;
    private Long idSecondDoc;
    private Float count;

    public Similarity()
    {
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public Similarity setId(Integer id)
    {
        this.id = id;
        return this;
    }

    @Override
    public Long getIdFirstDoc()
    {
        return idFirstDoc;
    }

    @Override
    public Similarity setIdFirstDoc(Long idFirstDoc)
    {
        this.idFirstDoc = idFirstDoc;
        return this;
    }

    @Override
    public Long getIdSecondDoc()
    {
        return idSecondDoc;
    }

    @Override
    public Similarity setIdSecondDoc(Long idSecondDoc)
    {
        this.idSecondDoc = idSecondDoc;
        return this;
    }

    @Override
    public Float getCount()
    {
        return count;
    }

    @Override
    public Similarity setCount(Float count)
    {
        this.count = count;
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
        Similarity that = (Similarity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIdFirstDoc(), that.getIdFirstDoc()) &&
                Objects.equals(getIdSecondDoc(), that.getIdSecondDoc()) &&
                Objects.equals(getCount(), that.getCount());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getIdFirstDoc(), getIdSecondDoc(), getCount());
    }

    @Override
    public String toString()
    {
        return "Similarity:\n" +
                "\tid = " + id + "\n" +
                "\tidFirstDoc = " + idFirstDoc + "\n" +
                "\tidSecondDoc = " + idSecondDoc + "\n" +
                "\tcount = " + count;
    }
}

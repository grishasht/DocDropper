package com.github.grishasht.docdropper.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "similarities")
public class Similarity
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

    public Integer getId()
    {
        return id;
    }

    public Similarity setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public Long getIdFirstDoc()
    {
        return idFirstDoc;
    }

    public Similarity setIdFirstDoc(Long idFirstDoc)
    {
        this.idFirstDoc = idFirstDoc;
        return this;
    }

    public Long getIdSecondDoc()
    {
        return idSecondDoc;
    }

    public Similarity setIdSecondDoc(Long idSecondDoc)
    {
        this.idSecondDoc = idSecondDoc;
        return this;
    }

    public Float getCount()
    {
        return count;
    }

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

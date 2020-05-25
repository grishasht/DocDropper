package com.github.grishasht.docdropper.model;

import com.github.grishasht.docdropper.model.impl.Similarity;

public interface ISimilarity
{
    Integer getId();

    Similarity setId(Integer id);

    Long getIdFirstDoc();

    Similarity setIdFirstDoc(Long idFirstDoc);

    Long getIdSecondDoc();

    Similarity setIdSecondDoc(Long idSecondDoc);

    Float getCount();

    Similarity setCount(Float count);
}

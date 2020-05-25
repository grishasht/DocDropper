package com.github.grishasht.docdropper.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.github.grishasht.docdropper.model.impl.Document;
import com.github.grishasht.docdropper.model.impl.User;

public interface IDocument
{
    Integer getId();

    Document setId(Integer id);

    UUID getGuid();

    Document setGuid(UUID guid);

    String getName();

    Document setName(String name);

    Long getSize();

    Document setSize(Long size);

    String getFormat();

    Document setFormat(String format);

    Timestamp getDateUploaded();

    Document setDateUploaded(Timestamp dateUploaded);

    Timestamp getDateLastModified();

    Document setDateLastModified(Timestamp dateLastModified);

    User getUser();

    Document setUser(User user);
}

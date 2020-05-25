package com.github.grishasht.docdropper.model;

import java.util.List;
import java.util.UUID;

import com.github.grishasht.docdropper.model.impl.Document;
import com.github.grishasht.docdropper.model.impl.User;

public interface IUser
{

    Integer getId();

    UUID getGuid();

    String getName();

    String getSurname();

    String getLogin();

    String getPassword();

    String getEmail();

    List<Document> getDocumentList();

    User setId(Integer id);

    User setGuid(UUID guid);

    User setName(String name);

    User setSurname(String surname);

    User setLogin(String login);

    User setPassword(String password);

    User setEmail(String email);

    User setDocumentList(List<Document> documents);
}

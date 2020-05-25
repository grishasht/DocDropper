package com.github.grishasht.docdropper.model.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.grishasht.docdropper.model.IUser;

@Entity
@Table(name = "users")
public class User implements IUser
{
    @Id
    @GeneratedValue
    private Integer id;
    private UUID guid;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_user")
    private List<Document> documentList;

    public User(Integer id, UUID guid, String name, String surname, String login, String password, String email) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String name, String surname, String login, String email) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
    }

    public User() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public UUID getGuid() {
        return guid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<Document> getDocumentList()
    {
        return documentList;
    }

    @Override
    public User setId(Integer id)
    {
        this.id = id;
        return this;
    }

    @Override
    public User setGuid(UUID guid)
    {
        this.guid = guid;
        return this;
    }

    @Override
    public User setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public User setSurname(String surname)
    {
        this.surname = surname;
        return this;
    }

    @Override
    public User setLogin(String login)
    {
        this.login = login;
        return this;
    }

    @Override
    public User setPassword(String password)
    {
        this.password = password;
        return this;
    }

    @Override
    public User setEmail(String email)
    {
        this.email = email;
        return this;
    }

    @Override
    public User setDocumentList(List<Document> documents)
    {
        this.documentList = documents;
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
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getGuid(), user.getGuid()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getDocumentList(), user.getDocumentList());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getGuid(), getName(), getSurname(), getLogin(), getPassword(), getEmail(), getDocumentList());
    }

    @Override
    public String toString()
    {
        return "User:\n" +
                "\tid = " + id + "\n" +
                "\tguid = " + guid + "\n" +
                "\tname = " + name + "\n" +
                "\tsurname = " + surname + "\n" +
                "\tlogin = " + login + "\n" +
                "\tdocuments = [" + documentList + "]\n" +
                "\temail = " + email;
    }
}

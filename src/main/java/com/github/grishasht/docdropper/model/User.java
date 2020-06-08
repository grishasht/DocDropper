package com.github.grishasht.docdropper.model;

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

@Entity
@Table(name = "users")
public class User
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
    @JoinColumn(name = "guid_user")
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

    public Integer getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Document> getDocumentList()
    {
        return documentList;
    }

    public User setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public User setGuid(UUID guid)
    {
        this.guid = guid;
        return this;
    }

    public User setName(String name)
    {
        this.name = name;
        return this;
    }

    public User setSurname(String surname)
    {
        this.surname = surname;
        return this;
    }

    public User setLogin(String login)
    {
        this.login = login;
        return this;
    }

    public User setPassword(String password)
    {
        this.password = password;
        return this;
    }

    public User setEmail(String email)
    {
        this.email = email;
        return this;
    }

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

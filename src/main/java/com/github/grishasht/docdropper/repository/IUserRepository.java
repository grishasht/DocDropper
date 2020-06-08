package com.github.grishasht.docdropper.repository;

import java.util.UUID;

import com.github.grishasht.docdropper.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface IUserRepository extends CrudRepository<User, Long>
{

    User getUserByGuid(UUID guid);

    User getUserByLogin(String login);

    @Query("select new User(u.name, u.surname, u.login, u.email) from User u where u.guid = :guid")
    User getUserByGuidNoPassword(@Param("guid") UUID guid);

    void removeUserByGuid(UUID guid);

    Integer getUserIdByGuid(UUID guid);
}

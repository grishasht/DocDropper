package com.github.grishasht.docdropper.repository;

import com.github.grishasht.docdropper.model.impl.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long>
{
}

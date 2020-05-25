package com.github.grishasht.docdropper.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.grishasht.docdropper.model.IUser;

@Entity
@Table(name = "users")
public class User implements IUser
{

}

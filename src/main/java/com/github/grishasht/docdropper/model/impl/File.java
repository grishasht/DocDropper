package com.github.grishasht.docdropper.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.grishasht.docdropper.model.IFile;

@Entity
@Table(name = "files")
public class File implements IFile
{
}

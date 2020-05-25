package com.github.grishasht.docdropper.repository;

import com.github.grishasht.docdropper.model.impl.File;
import org.springframework.data.repository.CrudRepository;

public interface IFileRepository extends CrudRepository<File, Long>
{
}

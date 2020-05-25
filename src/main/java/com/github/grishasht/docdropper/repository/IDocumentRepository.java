package com.github.grishasht.docdropper.repository;

import com.github.grishasht.docdropper.model.impl.Document;
import org.springframework.data.repository.CrudRepository;

public interface IDocumentRepository extends CrudRepository<Document, Long>
{
}

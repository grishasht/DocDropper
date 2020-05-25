package com.github.grishasht.docdropper.repository;

import com.github.grishasht.docdropper.model.impl.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IDocumentRepository extends CrudRepository<Document, Long>
{
}

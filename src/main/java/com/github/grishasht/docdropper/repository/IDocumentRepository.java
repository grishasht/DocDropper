package com.github.grishasht.docdropper.repository;

import java.util.List;
import java.util.UUID;

import com.github.grishasht.docdropper.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IDocumentRepository extends CrudRepository<Document, Long>
{

    Document findByNameAndUserGuid(String name, UUID userGuid);

    List<Document> findAllByUserGuid(UUID userGuid);
}

package com.github.grishasht.docdropper.service;

import java.util.List;
import java.util.UUID;

import com.github.grishasht.docdropper.model.Document;
import com.github.grishasht.docdropper.model.User;
import com.github.grishasht.docdropper.repository.IDocumentRepository;
import com.github.grishasht.docdropper.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService
{
    @Autowired
    private IDocumentRepository documentRepository;

    public List<Document> getAllByGuid(UUID userGuid)
    {
        return documentRepository.findAllByUserGuid(userGuid);
    }

    public Document getByName(String name, UUID userGuid)
    {
        return documentRepository.findByNameAndUserGuid(name, userGuid);
    }

}

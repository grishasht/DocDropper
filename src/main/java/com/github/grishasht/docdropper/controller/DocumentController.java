package com.github.grishasht.docdropper.controller;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.validation.Valid;

import com.github.grishasht.docdropper.model.Document;
import com.github.grishasht.docdropper.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{userGuid}/")
public class DocumentController
{
    private final static Logger LOGGER = Logger.getLogger(DocumentController.class.getName());

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService)
    {
        this.documentService = documentService;
    }

    @GetMapping("documents/")
    public List<Document> getAll(@PathVariable @Valid UUID userGuid)
    {
        final String msg = String.format("All documents for user %s retrieved!", userGuid);
        LOGGER.info(msg);

        return documentService.getAllByGuid(userGuid);
    }

    @GetMapping("document/{name}/")
    public Document getByName(@PathVariable @Valid UUID userGuid, @PathVariable String name)
    {
        final String msg = String.format("Document %s for user %s retrieved!", name, userGuid);
        LOGGER.info(msg);

        return documentService.getByName(name, userGuid);
    }


}

package com.github.grishasht.docdropper.service.googledrive.client.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.grishasht.docdropper.exception.DocDropperException;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.common.net.MediaType;

public class GoogleDriveClient implements IGoogleDriveClient
{

    private static final String SERVICE_URL_GOOGLE_DRIVE = "https://drive.googleapis.com/";
    private static final String APPLICATION_NAME = "Document Dropper";

    private final GoogleCredential credential;

    private Drive driveService;

    private String signedJwt;

    public GoogleDriveClient(GoogleCredential credential)
    {
        this.credential = credential;
    }

    @Override
    public void authorize()
    {

        signedJwt = signJwt();

//        credential.setAccessToken(signedJwt);

        driveService = getDriveService();

    }

    private String signJwt()
    {
        final String serviceAccountEmail = credential.getServiceAccountId();
        final PrivateKey privateKey = credential.getServiceAccountPrivateKey();
        final String privateKeyId = credential.getServiceAccountPrivateKeyId();

        final long now = System.currentTimeMillis();

        final Algorithm algorithm = Algorithm.RSA256(null, (RSAPrivateKey) privateKey);

        return JWT.create()
                .withKeyId(privateKeyId)
                .withIssuer(serviceAccountEmail)
                .withSubject(serviceAccountEmail)
                .withAudience(SERVICE_URL_GOOGLE_DRIVE)
                .withIssuedAt(new Date(now))
                .withExpiresAt(new Date(now + 3600 * 10000L))
                .sign(algorithm);
    }

    private Drive getDriveService()
    {
        try
        {
            final HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            final JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            return new Drive.Builder(httpTransport, jsonFactory, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }
        catch (Exception e)
        {
            throw new DocDropperException("Can't create GoogleNetHttpTransport", e);
        }
    }

    @Override
    public void uploadFile(String name, java.io.File data)
    {
        try
        {
            final File fileMeta = new File()
                    .setName(name);
            final FileContent fileContent = new FileContent("application/text", data);

            driveService.files()
                    .create(fileMeta, fileContent)
                    .execute();

            System.out.println("File uploaded: " + name);
        }
        catch (Exception e)
        {
            throw new DocDropperException("Exception while uploading file to Google Drive", e);
        }
    }

    @Override
    public java.io.File downloadFile(String name)
    {
        return new java.io.File(new String());
    }

    @Override
    public void deleteFile(String name, java.io.File data)
    {

    }

    @Override
    public void updateFile(String name, java.io.File data)
    {

    }

    @Override
    public void updateFileName(String name)
    {

    }

    @Override
    public List<String> getAllFilesMetadata() throws GeneralSecurityException, IOException
    {
        return Collections.emptyList();
    }

}

package com.github.grishasht.docdropper.service.googledrive.client.impl;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface IGoogleDriveClient
{

    void authorize();

    void uploadFile(String name, File data);

    File downloadFile(String name);

    void deleteFile(String name, File data);

    void updateFile(String name, File data);

    void updateFileName(String name);

    List<String> getAllFilesMetadata() throws GeneralSecurityException, IOException;
}

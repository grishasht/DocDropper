package com.github.grishasht.docdropper.util;

import java.io.File;

import com.github.grishasht.docdropper.service.googledrive.client.factory.GoogleDriveClientFactory;
import com.github.grishasht.docdropper.service.googledrive.client.impl.IGoogleDriveClient;

public class Test
{

    public static void main(String[] args)
    {
        final GoogleDriveClientFactory googleDriveClientFactory = new GoogleDriveClientFactory();

        final IGoogleDriveClient googleDriveClient = googleDriveClientFactory.createInstance("credentials/google-drive-credentials.json");

        googleDriveClient.authorize();

        googleDriveClient.uploadFile("file1", new File("src/main/resources/test-tmp/tmp.txt"));
    }
}

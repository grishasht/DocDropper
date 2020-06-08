package com.github.grishasht.docdropper.service.googledrive.client.factory;

import java.io.ByteArrayInputStream;
import java.util.Collections;

import com.github.grishasht.docdropper.exception.DocDropperException;
import com.github.grishasht.docdropper.service.googledrive.client.impl.GoogleDriveClient;
import com.github.grishasht.docdropper.service.googledrive.client.impl.IGoogleDriveClient;
import com.github.grishasht.docdropper.util.ResourceUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.drive.DriveScopes;
import org.springframework.stereotype.Component;

@Component
public class GoogleDriveClientFactory
{

    private static final String KEY_CLIENT_EMAIL = "client_email";

    public IGoogleDriveClient createInstance(String credentialsFileContentPath)
    {
        try
        {
            final byte[] jsonByteArray = ResourceUtils.readAllBytesFromResources(credentialsFileContentPath);

            final GoogleCredential credential = GoogleCredential.fromStream(new ByteArrayInputStream(jsonByteArray))
                    .createScoped(Collections.singletonList(DriveScopes.DRIVE));

            return new GoogleDriveClient(credential);
        }
        catch (Exception e)
        {
            throw new DocDropperException("Can't process file by content path: " + credentialsFileContentPath, e);
        }
    }

}

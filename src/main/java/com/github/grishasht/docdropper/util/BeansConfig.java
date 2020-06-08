package com.github.grishasht.docdropper.util;

import com.github.grishasht.docdropper.service.DocumentService;
import com.github.grishasht.docdropper.service.SimilarityService;
import com.github.grishasht.docdropper.service.UserService;
import com.github.grishasht.docdropper.service.googledrive.client.factory.GoogleDriveClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeansConfig
{
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserService userService() {
//        return new UserService();
//    }
//
//    @Bean
//    public DocumentService documentService() {
//        return new DocumentService();
//    }
//
//    @Bean
//    public SimilarityService similarityService() {
//        return new SimilarityService();
//    }

//    @Bean
//    public GoogleDriveClientFactory googleDriveClientFactory() {
//        return new GoogleDriveClientFactory();
//    }
}

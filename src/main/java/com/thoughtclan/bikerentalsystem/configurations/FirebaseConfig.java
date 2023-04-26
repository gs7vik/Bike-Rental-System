package com.thoughtclan.bikerentalsystem.configurations;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//
//@Configuration
//public class FirebaseConfig {
//
//    @Value("bike-rental-system.json")
//
//    private String firebasePrivateKeyFile;
//
//    @Bean
//    public void initFirebase() throws IOException{
//        InputStream serviceAccount = new ClassPathResource(firebasePrivateKeyFile).getInputStream();
//
//        FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
//
//        if(FirebaseApp.getApps().isEmpty()){
//
//    private String FIREBASE_CONFIG_FILE;
//
//   @Bean
//    public void initFirebase() throws IOException {
//        InputStream firebaseFile = new ClassPathResource(FIREBASE_CONFIG_FILE).getInputStream();
//        FirebaseOptions firebaseOptions = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(firebaseFile))
//                .build();
//        if (FirebaseApp.getApps().isEmpty()) {
//
//            FirebaseApp.initializeApp(firebaseOptions);
//        }
//    }
//}
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;


@Configuration
public class FirebaseConfig {

    @Value("bike-rental-system.json")
    private String firebasePrivateKeyFile;

    @Bean
    public void initFirebase() throws IOException{
        InputStream serviceAccount = new ClassPathResource(firebasePrivateKeyFile).getInputStream();

        FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(firebaseOptions);
        }
    }
}

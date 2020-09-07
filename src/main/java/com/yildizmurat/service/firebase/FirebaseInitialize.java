package com.yildizmurat.service.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.*;
import com.yildizmurat.api.ParkingSpacesUsagesApi;
import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.UsageStatus;
import com.yildizmurat.repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.service.implementation.ParkingSpacesUsagesImpl;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


@Service
public class FirebaseInitialize {

   private static  DatabaseReference ref;
   private static int flag=0;
    boolean checkSignal=false;


 @PostConstruct
public void FirebaseInitialize(){

    try{
        FileInputStream serviceAccount = new FileInputStream("./self-garage-firebase-adminsdk-6wwga-2543493ca1.json");

        // Initialize the app with a service account, granting admin privileges
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://self-garage.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);

        // As an admin, the app has access to read and write all data, regardless of Security Rules
         ref = FirebaseDatabase.getInstance()
                .getReference("/");
         //   getsignal();

    }catch (Exception e){
        System.out.println("error gardas : "+ e);
    }
}


public void getSignal() {


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                String signal = document.toString();
                System.out.println(signal.charAt(7) == '0');
                if (signal.charAt(7) == '0') {
                    checkSignal = true;

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

}


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isCheckSignal() {
        return checkSignal;
    }

    public void setCheckSignal(boolean checkSignal) {
        this.checkSignal = checkSignal;
    }
}



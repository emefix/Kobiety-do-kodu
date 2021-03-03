package pl.martitafilix.cats.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {
	
	@PostConstruct
    public void initialize() {
		
		String fileName = "c:/Users/admin/Documents/PrivateKeys_and_Tokens/firebase-serviceAccount.json";
        try {
            FileInputStream serviceAccount = new FileInputStream(fileName);
//        	FirebaseOptions options = FirebaseOptions.builder()
//        		    .setCredentials(GoogleCredentials.getApplicationDefault())
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://the-catsapp.firebaseio.com")
                    .build();

            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("The default FirebasApp has been initialized...");
            }
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
            System.out.println("The sevice account file doesn't exists!");
		} catch (Exception e) {
			System.out.println("Another error!");
            e.printStackTrace();
        }
    }
}

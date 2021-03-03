package pl.martitafilix.cats.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import pl.martitafilix.cats.dao.CatDAO;
import pl.martitafilix.cats.model.Cat;

@Service
public class FirebaseCatDAO implements CatDAO {
	
/* Fields: */
	
	public static final String 	COLL_NAME 	= "cats";
	public static 		Integer id 			= 0;
	
	private Firestore firestoreDB;
	
/* Methods: */
	
	@Override
	public List<Cat> getCats() {

		List<Cat> cats = new ArrayList<Cat>();

		this.firestoreDB = FirestoreClient.getFirestore();
		
		CollectionReference collRef = firestoreDB.collection(COLL_NAME);
		Iterable<DocumentReference> docRefIterable = collRef.listDocuments();
		
//		for (DocumentReference docRef : docRefIterable) {
		docRefIterable.forEach(docRef -> {
			ApiFuture<DocumentSnapshot> docAF = docRef.get();
				try {
					DocumentSnapshot doc = docAF.get();
					Cat cat = doc.toObject(Cat.class);
					cats.add(cat);
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
		});
		
		return cats;
	}
	
	@Override
	public void addCat(Cat cat) {
		
		this.firestoreDB = FirestoreClient.getFirestore();
		
//		Map<String, Object> docData = new HashMap<>();
//		docData.put("name", "Miau");
//		docData.put("date_of_birth", "2020-12-24");
//		docData.put("weight", 2.4);
//		docData.put("name_of_catKeeper", "Bobby");
//
//		ApiFuture<WriteResult> writeResultAF = firestoreDB.collection(COLL_NAME)
//				.document("Miau").set(docData);
		
		
		String docId = getFileName(cat.getName(), "yyyyMMMdd_HHmm");
		cat.setId(docId);
		
		ApiFuture<WriteResult> writeResultAF = firestoreDB.collection(COLL_NAME)
				.document(docId).set(cat);
		try {
			System.out.println(writeResultAF.get().getUpdateTime());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cat getCatById(Integer id) {
		return null;
	}
	
	@Override
	public Cat getCatById(String id) {
		
		this.firestoreDB = FirestoreClient.getFirestore();
		
		DocumentReference docRef = firestoreDB.collection(COLL_NAME).document(id);
		ApiFuture<DocumentSnapshot> docAF = docRef.get();

		try {
			DocumentSnapshot doc = docAF.get();
			Cat cat = null;
			
			if(doc.exists()) {
				cat = doc.toObject(Cat.class);
				return  cat;
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
		
//		docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//			
//			@Override
//			public void onEvent(DocumentSnapshot doc, FirestoreException error) {
//				if(error != null) {
//					System.out.println("Listen failed: " + error);
//					return;
//				}
//				if(doc != null && doc.exists()) {
//					cat = doc.toObject(Cat.class);
//					System.out.println("Current data: " + doc.getData());
//					
//				} else {
//					System.out.println("Current data: null");
//				}
//			}
//		});
	}
	private static String getFileName(String name, String dateFormat) {
		
		String fileName = new SimpleDateFormat("'" + name + "_'" + dateFormat).format(new Date());
//		String suffix = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date());

		return fileName;
	}
}

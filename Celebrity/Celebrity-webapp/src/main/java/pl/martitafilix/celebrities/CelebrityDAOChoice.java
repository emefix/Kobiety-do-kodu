package pl.martitafilix.celebrities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.martitafilix.celebrities.dao.I_CelebrityDAO;
import pl.martitafilix.celebrities.dao.JpaCelebrityDAO;
import pl.martitafilix.celebrities.dao.Reading;
import pl.martitafilix.celebrities.dao.SpringDataCelebrityDAO;

@Service
//@Component
public class CelebrityDAOChoice {

	@Autowired
	private SpringDataCelebrityDAO springDataCelebrityDAO;
	@Autowired
	private JpaCelebrityDAO jpaCelebrityDAO;
	@Autowired
	private Reading reading;

	private I_CelebrityDAO celebrityDAO;
	
	public enum DAO {
		
		JPA_MYSQL("JPA MySQL"), 
		SPRINGDATA_MYSQL("SpringData MySQL"), 
		COLLECTION("Collection");
		
		private String name;
		
		DAO(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}		
	}
 
	public void setCelebrityDAO(DAO dao) {
		
		switch(dao) {
		
		case JPA_MYSQL: 
			celebrityDAO = jpaCelebrityDAO; 
			break;
		case SPRINGDATA_MYSQL: 
			celebrityDAO = springDataCelebrityDAO; 
			break;
		case COLLECTION: 
			celebrityDAO = reading; 
			break;
		}
	}
	
	public I_CelebrityDAO getDAO() {
		return celebrityDAO;
	}
}

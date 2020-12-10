package libDuo.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ITextIdiomes;
import libDuo.implement.TextIdiomasImpl;
import libDuo.model.*;
import libDuo.util.HibernateUtil;



public class project_main {
	
	public static void main(String[] args) {
		
		ITextIdiomes icmanagerTextIdiomes = new TextIdiomasImpl();
		ArrayList<String> idiomes = icmanagerTextIdiomes.leerFicheroDeIdiomes();
		icmanagerTextIdiomes.setAllIdiomes(idiomes);
		
		
		
		Transaction t = null;
				
				try(Session session =
						HibernateUtil.getSessionFactory().openSession()){
					
					t = session.beginTransaction();			
					
					for (int i = 0; i < idiomes.size(); i++) {
						session.save(idiomes.get(i));
					}
					
					t.commit();
					
				}catch(Exception e){
				
					
					
				}
		
	}

}

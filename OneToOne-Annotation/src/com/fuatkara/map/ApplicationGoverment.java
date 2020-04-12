package com.fuatkara.map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuatkara.util.HibernateUtil;

public class ApplicationGoverment {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			Government government = new Government();
			government.setGovernmentService("Laz Service");
			government.setGovernmentName("Kutahya");
			
			GovernmentInfo governmentInfo = new GovernmentInfo();
			governmentInfo.setGovernmentAddress("Calcali");
			governmentInfo.setGovernmentParties("Laz Kong");
			governmentInfo.setGovernment(government);
			
			government.setGovernmentInfo(governmentInfo); //Bu ve altindakinin yerine asagidaki yorumlara
			governmentInfo.setGovernment(government);//alinan kismiyla degistirebilirsin.
			
			session.save(government); 
			System.out.println("Saved all informations");
			transaction.commit();
			
//			session.save(government);  
//			session.save(governmentInfo);
//			System.out.println("Saved all informations");
//			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
}
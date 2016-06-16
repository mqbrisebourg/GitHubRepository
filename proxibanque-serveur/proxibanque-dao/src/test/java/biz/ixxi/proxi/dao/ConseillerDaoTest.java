package biz.ixxi.proxi.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Personnel;

public class ConseillerDaoTest {

	private Conseiller conseiller;
	//private PersonnelDao personneldao;
	private ConseillerDao conseillerdao;
	private ClassPathXmlApplicationContext appContext;
	
	
	@Before
	public void setUp() throws Exception {
		
		conseiller = new Conseiller("mtconseillere","Conseillère","Marie-Thérèse");
		appContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		conseillerdao = (ConseillerDao) appContext.getBean("conseillerDao");
	} 


	
//	@Test
//	public void testSavePersonnel() {
//		personneldao.save(conseiller);
//	}
	
	@Test
	public void testGetConseillerByLogin() {
		//List<Personnel> list =personneldao.findAll();
		
		//Personnel conseillerTest=list.get(0);
		List<Conseiller> liste=conseillerdao.findByIdGerant(3L);
		Conseiller conseiller=liste.get(0);
		System.out.println(conseiller.getPrenom());
		assertEquals(conseiller.getPrenom(),"Hélène");
	}

}

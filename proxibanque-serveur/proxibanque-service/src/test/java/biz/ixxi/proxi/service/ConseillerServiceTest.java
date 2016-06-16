package biz.ixxi.proxi.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.dao.ClientDao;
import biz.ixxi.proxi.dao.CompteDao;
import biz.ixxi.proxi.domaine.Client;

public class ConseillerServiceTest {

	
	//private PersonnelDao personneldao;
	
	private ClassPathXmlApplicationContext appContext;
	private ConseillerService conseillerService;
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		
		
	appContext = new ClassPathXmlApplicationContext(new String[] {
                "service-beans.xml", "dao-beans.xml"});
	conseillerService= (ConseillerService) appContext.getBean("conseillerService");
	client = new Client(45L,2L,"Consommateur","Jean-Jacques","13 rue du Commerce",56754, "Arnaque-la-Poste","0654484849");
		
	} 
	
	
//	@Test
//	public void testSave() {
//		conseillerService.saveClient(client);
//	}
//	
	
//	@Test
//	public void testVirement() {
//		
//		conseillerService.virement(1L, 3L, 161);
//	}

}

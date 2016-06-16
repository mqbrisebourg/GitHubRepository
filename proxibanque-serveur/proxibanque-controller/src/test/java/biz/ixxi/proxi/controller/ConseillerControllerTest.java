package biz.ixxi.proxi.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.domaine.Client;


public class ConseillerControllerTest {
	private ClassPathXmlApplicationContext appContext;
	private ConseillerController conseillerController;
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		
		
	appContext = new ClassPathXmlApplicationContext(new String[] {
               "springrest-servlet.xml", "service-beans.xml", "dao-beans.xml"});
	conseillerController= (ConseillerController) appContext.getBean("conseillerController");
	client = new Client(2L,"Consommateur","Jean-Jacques","13 rue du Commerce",56754, "Arnaque-la-Poste","0654484849");
	
		
	} 
	
		
	@Test
	public void testSave() {
		
		conseillerController.saveClient(client);
	}
}

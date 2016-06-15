package biz.ixxi.proxi.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Personnel;

public class ClientDaoTest {

	private Client client;
	//private PersonnelDao personneldao;
	private ClientDao clientdao;
	private ClassPathXmlApplicationContext appContext;
	
	
	@Before
	public void setUp() throws Exception {
		
		client = new Client(2L,"Client","Jean-François","13 rue de la Clientèle",33400, "ClientVille","0654484848");
		appContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		clientdao = (ClientDao) appContext.getBean("clientDao");
	} 


	
//	@Test
//	public void testClient() {
//		clientdao.save(client);
//	}
//	
	@Test
	public void testGetClientByConseiller() {
		//List<Personnel> list =personneldao.findAll();
		
		//Personnel conseillerTest=list.get(0);
		List<Client> liste=clientdao.findByIdConseiller(2L);
		Client client=liste.get(0);
		System.out.println(client.getPrenom());
	}
}

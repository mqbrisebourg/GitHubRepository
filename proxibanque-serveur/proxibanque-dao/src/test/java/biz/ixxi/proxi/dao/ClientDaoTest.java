package biz.ixxi.proxi.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.domaine.Client;


public class ClientDaoTest {

	private Client client;
	private ClientDao clientdao;
	private ClassPathXmlApplicationContext appContext;
	
	
	@Before
	public void setUp() throws Exception {
		
		client = new Client(1L,"Client","Jean-Michel","17 rue de la Clientèle",33400, "ClientVille","0654484857");
		appContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		clientdao = (ClientDao) appContext.getBean("clientDao");
	} 


	
//	@Test
//	public void testClient() {
//		clientdao.saveAndFlush(client);
//	}
	
	@Test
	public void testGetClientByConseiller() {

		List<Client> liste=clientdao.findByIdPersonnel(1L);
		Client client=liste.get(0);
		System.out.println(client.getPrenom());
	}
	
	
	@Test
	public void testGetClientById() {

		List<Client> liste=clientdao.findByIdClient(1L);
		Client client=liste.get(0);
		System.out.println(client.getPrenom());
		assertEquals(client.getPrenom(),"Jean-Michel");
	}
}

package biz.ixxi.proxi.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.ixxi.proxi.aop.Logger;
import biz.ixxi.proxi.dao.ClientDao;
import biz.ixxi.proxi.dao.TransactionDao;
import biz.ixxi.proxi.service.ConseillerService;
import biz.ixxi.proxi.service.IConseillerService;
import junit.framework.TestCase;

public class LoggerTest extends TestCase{
	


	public void test() {
		ApplicationContext	context = new ClassPathXmlApplicationContext( new String[] {"service-beans.xml"});
		IConseillerService service=(IConseillerService) context.getBean("conseillerService");
				service.virement(1L, 2L, 100);
	}

}

package com.offcn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilApp {
	
//	@Test
	public void testRead() {
		//需要读取一下beans.xml文件管理dao层的映射文件、配置文件和需要的数据源
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		readExcelToMySqlImpl mobile=(readExcelToMySqlImpl) context.getBean("readExcelToMySqlImpl");
		mobile.readForeachExcel();
	}
}

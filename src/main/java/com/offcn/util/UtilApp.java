package com.offcn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilApp {
	
//	@Test
	public void testRead() {
		//��Ҫ��ȡһ��beans.xml�ļ�����dao���ӳ���ļ��������ļ�����Ҫ������Դ
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		readExcelToMySqlImpl mobile=(readExcelToMySqlImpl) context.getBean("readExcelToMySqlImpl");
		mobile.readForeachExcel();
	}
}

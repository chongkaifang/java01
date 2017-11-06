package com.offcn.util;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilApp {

	@Autowired
	readExcelToMySql read;
	
	@Test
	public void testRead() {
		//��Ҫ��ȡһ��beans.xml�ļ�����dao���ӳ���ļ��������ļ�����Ҫ������Դ
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		try {
			read.readForeachExcel();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

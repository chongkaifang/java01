package com.offcn.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.service.MobileService;
import com.offcn.util.readExcelToMySql;
import com.offcn.util.readExcelToMySqlImpl;

@Controller
@RequestMapping("/read")
public class readController {

	@Autowired
	readExcelToMySql read;

	@RequestMapping("/readAndWriter")
	public String readExcel(){
		System.out.println("666");
		System.out.println(read.toString());
		read.readForeachExcel();
		return "index";
	}
}

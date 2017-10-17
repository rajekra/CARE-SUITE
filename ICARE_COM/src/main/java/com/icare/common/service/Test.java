package com.icare.common.service;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Test {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		File folder = new File("C:\\SVN\\OWCP_NEW_FRAMEWORK\\DSA\\target\\owcp-billprocessing-0.1.1\\WEB-INF\\lib");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println( listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }

	}

}

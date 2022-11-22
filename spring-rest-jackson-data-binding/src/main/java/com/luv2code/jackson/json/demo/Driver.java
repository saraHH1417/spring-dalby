package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper objectMapper = new ObjectMapper();

			// read JSON file and convert it to JAVA POJO: data/sample-lite.json
			Student theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			Address address = theStudent.getAddress();

			// print first name and last name
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			System.out.println("Address: " + theStudent.getAddress());
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());


			for (String tempLang: theStudent.getLanguages()) {
				System.out.println(tempLang);
			}


		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}





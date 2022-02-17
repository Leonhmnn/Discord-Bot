package de.umfrage.listener;

import javax.security.auth.login.LoginException;

public class Main {

	public static String prefix = "p-";

	public static void main(String[] args) {

		System.err.println("MAIN 10");

		try {

			System.err.println("MAIN 15");

			new DCBot();

			System.err.println("MAIN 19");

		} catch (LoginException | IllegalArgumentException e) {

			System.err.println("MAIN 23");

			e.printStackTrace();
			
			System.err.println("MAIN 27");
			
		}
	}
}

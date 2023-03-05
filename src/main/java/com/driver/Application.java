package com.driver;

import jdk.incubator.vector.VectorOperators;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
//public class Application {
 public class Test {
	//public static void main(String[] args) {

	//	SpringApplication.run(Application.class, args);
		public Test()
		{
			System.out.println("1");
			new Test(10);
			System.out.println("5");
		}
		public Test(int temp)
		{
			System.out.println("2");
			new Test(10, 20);
			System.out.println("4");
		}
		public Test(int data, int temp)
		{
			System.out.println("3");
		}
		public static void main(String[] args) {
			Test obj = new Test();
		}

	//}
}

package cts.unitTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import cts.builder.Camera;
import cts.builder.CameraBuilder;
import cts.exceptii.InvalidCostException;
import cts.exceptii.InvalidDurataCazareException;
import cts.exceptii.InvalidValoareException;
import cts.exceptii.MaxValoareBugetException;
import cts.exceptii.NegativCostException;
import cts.exceptii.NegativDurataCazareException;
import cts.exceptii.NegativValoarePretException;
import cts.exceptii.ZeroCostException;
import cts.exceptii.ZeroDurataCazareException;
import cts.exceptii.ZeroValoarePretException;
import cts.singleton.Client;
import junit.framework.TestCase;

public class TestClient extends TestCase {
	
	private Client client;
	
	private static int id;
	private static String nume;
	private static String prenume;
	private static double BUGET;
	
	private static double pret;
	private static double cost;
	
	static {
		System.out.println("Apelat in bloc static");
		try {
			getTestData("informatii.txt");
				
			//afisare valori intrare
			System.out.println("Id-ul: "+id);
			System.out.println("Numele: "+nume);
			System.out.println("Prenumele: "+prenume);
			System.out.println("Bugetul: "+BUGET);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

		//definire constructor pt Unit Test
		public TestClient(String name){
			super(name);
		}
		
		//functia setUp se apeleaza de fiecare data 
		public void setUp(){
			System.out.println("Pregatire test - creare");
			client = Client.getClient(100, "Vatasoiu", "Roxana", 220.00);
		}
		
		//functia se apeleaza automat la sfarsitul fiecarui unit test
		public void tearDown(){
			System.out.println("Terminare test - stergere");
		}
		
		public void testRezervaCamera(){
			try{
				client.rezervaCamera(null);
				fail("Test rezervaCamera() cu valoarea null");
			}
			catch(Exception e){
				
			}
		}
		
		public void testStergereCamera(){
			try{
				client.stergeCamera(null);
				fail("Test stergereCamera() cu valoarea null");
			}
			catch(Exception e){
				
			}
		}
		
		public void testNegativIndexCamera(){
			try{
				client.pozitieCamera(-99);
				fail("Test pozitieCamera() cu valoare negativa");
			}
			catch(Exception e){
				
			}
		}
		
		public void testExtraIndexCamera(){
			try{
				client.pozitieCamera(1000000000);
				fail("Test pozitieCamera() cu valoare mai mare decat lungimea listei");
			}
			catch(Exception e){
				
			}
		}

		public void testZeroDimensiuneListaCamere(){
			try{
				client.getSize();
				fail("Test getSize() cu valoare 0 a lungimii listei");
			}
			catch(Exception e){
				
			}
		}
		
		public void testZeroValoareIdCamera(){
			try{
				Camera c = new CameraBuilder(0,1,1, 110.00).build();
				client.inregistrareCamera(c);
				fail("Test inregistrareCamera() cu valoare 0 a nrCamera");
			}
			catch(Exception e){
				
			}
		}
		
		public void testNegativValoareIdCamera(){
			try{
				Camera c = new CameraBuilder(-40,1,1, 110.00).build();
				client.inregistrareCamera(c);
				fail("Test inregistrareCamera() cu valoare negativa a nrCamera");
			}
			catch(Exception e){
				
			}
		}
		
		public void testMaxValoareIdCamera(){
			try{
				Camera c = new CameraBuilder(100000000,1,1, 110.00).build();
				client.inregistrareCamera(c);
				fail("Test inregistrareCamera() cu o valoare aberanta a nrCamera.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testMaxValoareBuget(){
			try{
				Camera c = new CameraBuilder(10,1,1, BUGET).build();
				client.platesteCamera(c);
				fail("Test platesteCamera() cu un pret mai mare decat bugetul.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testNegativValoarePret(){
			try{
				Camera c = new CameraBuilder(10,1,1, -10.00).build();
				client.platesteCamera(c);
				fail("Test platesteCamera() cu un pret negativ.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testZeroValoarePret(){
			try{
				Camera c = new CameraBuilder(10,1,1, 0.00).build();
				client.platesteCamera(c);
				fail("Test platesteCamera() cu un pret egal cu 0.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testInvalidValoare(){
			try{
				Camera c = new CameraBuilder(10,1,1, 0.00007).build();
				client.platesteCamera(c);
				fail("Test platesteCamera() cu un pret aberant.");
			}
			catch(Exception e){
				
			}
		}

		public void testZeroCost(){
			try{
				client.primesteDiscount(cost);
				fail("Test primesteDiscount() cu un cost egal cu 0.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testNegativCost(){
			try{
				client.primesteDiscount(-10.00);
				fail("Test primesteDiscount() cu un cost negativ.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testInvalidCost(){
			try{
				client.primesteDiscount(0.00005);
				fail("Test primesteDiscount() cu un cost aberant.");
			}
			catch(Exception e){
				
			}
		}

		public void testZeroDurataCazare(){
			try{
				client.validareDurataCazare(0);
				fail("Test validareDurataException() are valoarea 0.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testNegativDurataCazare(){
			try{
				client.validareDurataCazare(-1);
				fail("Test validareDurataException() are valoare negativa.");
			}
			catch(Exception e){
				
			}
		}
		
		public void testInvalidDurataCazare(){
			try{
				client.validareDurataCazare(500);
				fail("Test validareDurataException() are o valoare aberanta.");
			}
			catch(Exception e){
				
			}
		}

		private static void getTestData(String numeFisier) 
				throws IOException{
			File fisierDeIntrare = new File(numeFisier);
			if(fisierDeIntrare.exists()){
				BufferedReader reader = 
						new BufferedReader(new FileReader(fisierDeIntrare));
				
				String linieCurenta;
				
				while((linieCurenta = reader.readLine())!=null){
					//ignoram liniile care incep cu #
					if(linieCurenta.startsWith("#"))
						continue;
					else
					{
						System.out.println(linieCurenta);
						//verificam marker semnificatie valoare
						if (linieCurenta.startsWith("*")){
							String[] simboluri = linieCurenta.split(" ");
							switch(simboluri[1]){
								case "id":{
									linieCurenta = reader.readLine();
									id = Integer.parseInt(linieCurenta);
									break;
								}
								case "nume":{
									linieCurenta = reader.readLine();
									nume = linieCurenta;
									
									break;
								}
								case "prenume":{
									linieCurenta = reader.readLine();
									prenume = linieCurenta;
									break;
								}
								case "BUGET":{
									linieCurenta = reader.readLine();
									BUGET = Double.parseDouble(linieCurenta);
									break;
								}
								case "pret":{
									linieCurenta = reader.readLine();
									pret = Double.parseDouble(linieCurenta);
									break;
								}
								case "cost":{
									linieCurenta = reader.readLine();
									cost = Double.parseDouble(linieCurenta);
									break;
								}
								
							}
						}
					}
				}
			}
			else
				System.out.println("Fisier inexistent");
		}

		
}

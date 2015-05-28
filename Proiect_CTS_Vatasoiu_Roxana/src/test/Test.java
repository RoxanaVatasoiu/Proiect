package test;
import cts.builder.Camera;
import cts.builder.CameraBuilder;
import cts.exceptii.ExtraIndexException;
import cts.exceptii.InvalidCostException;
import cts.exceptii.InvalidValoareException;
import cts.exceptii.MaxValoareBugetException;
import cts.exceptii.NegativCostException;
import cts.exceptii.NegativIndexException;
import cts.exceptii.NegativValoarePretException;
import cts.exceptii.NullRezervareException;
import cts.exceptii.ZeroCostException;
import cts.exceptii.ZeroDimensiuneListaException;
import cts.exceptii.ZeroValoarePretException;
import cts.singleton.*;
import cts.template.TemplateClient;

public class Test {

	public static void main(String[] args) throws ZeroDimensiuneListaException, NullRezervareException, 
													MaxValoareBugetException, NegativValoarePretException, 
													ZeroValoarePretException, InvalidValoareException, ZeroCostException, 
													NegativCostException, InvalidCostException {
		
		System.out.println("---------------------Testare Singleton--------------------------");
		Client cl1 = Client.getClient(100, "Vatasoiu", "Roxana", 220.00);
		Client cl2 = Client.getClient(200, "Vatasoiu", "Roxana", 20.00);
	
		System.out.println(cl1.toString());
		System.out.println(cl2.toString());
		
		if(cl1 == cl2)
			System.out.println("Acelasi client!!");
		
		System.out.println("");
		System.out.println("---------------------Testare Builder---------------------------");
		Camera c1 = new CameraBuilder(10,1,1, 110.00)
					.hasTelevizor()
					.build();
		Camera c2 = new CameraBuilder(11,1,2, 150.00)
					.hasTelevizor()
					.hasFrigider()
					.build();
		Camera c3 = new CameraBuilder(13,1,2,160.00)
					.hasTelevizor()
					.hasAerConditionat()
					.build();
		
		System.out.println(c1.descriere());
		System.out.println(c2.descriere());
		System.out.println(c3.descriere());
		
		System.out.println("");
		System.out.println("----------------------Testare Template--------------------------");
		TemplateClient tClient = new TemplateClient();
		tClient.parcurge(2);
		
		
		System.out.println("");
		System.out.println("==================metode============================");
	
		cl1.rezervaCamera(c1);
		cl1.rezervaCamera(c2);
		cl1.rezervaCamera(c3);
		
		System.out.println("Numar camere rezervate: "+cl1.getSize());
		cl1.afisare();
		
		System.out.println("");
		cl1.platesteCamera(c2);
			
		cl1.primesteDiscount(400.00);
		
	}

}

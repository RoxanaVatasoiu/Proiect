package cts.singleton;

import java.util.ArrayList;


import cts.builder.Camera;
import cts.builder.CameraBuilder;
import cts.exceptii.ExtraIndexException;
import cts.exceptii.InvalidCostException;
import cts.exceptii.InvalidDurataCazareException;
import cts.exceptii.InvalidValoareException;
import cts.exceptii.MaxValoareBugetException;
import cts.exceptii.MaxValoareIdException;
import cts.exceptii.NegativCostException;
import cts.exceptii.NegativDurataCazareException;
import cts.exceptii.NegativIndexException;
import cts.exceptii.NegativValoareIdException;
import cts.exceptii.NegativValoarePretException;
import cts.exceptii.NullRezervareException;
import cts.exceptii.NullStergereException;
import cts.exceptii.ZeroCostException;
import cts.exceptii.ZeroDimensiuneListaException;
import cts.exceptii.ZeroDurataCazareException;
import cts.exceptii.ZeroValoareIdException;
import cts.exceptii.ZeroValoarePretException;
import cts.interfete.IDescriere;

public class Client implements IDescriere{
	private static int id;
	private static String nume;
	private static String prenume;
	
	private ArrayList<Camera> camere = null;
	
	private static double BUGET;
	private double cost;
	
	private static Client client;
	
	private Client(int id, String nume, String prenume, double buget){
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		BUGET=buget;
		camere = new ArrayList<>();
	}
	
	public static synchronized Client getClient(int id, String nume, String prenume, double buget){
		if(Client.client == null)
			Client.client = new Client(id, nume, prenume, buget);
		return Client.client;
	}

	@Override
	public String toString() {
		return "Clientul cu id-ul  " + id + ", numele: " + nume + ", prenumele: " + prenume+", bugetul: "+BUGET;
		
	}	
	
	public void rezervaCamera(Camera cam) throws NullRezervareException{
		if(cam == null) throw new NullRezervareException("Camera ce se doreste a fi rezervata nu exista");
		camere.add(cam);
	}
	
	public void stergeCamera(Camera cam) throws NullStergereException{
		if (cam == null) throw new NullStergereException("Camera ce se doreste a fi stearsa este inexistenta");
		camere.remove(cam);		
	}
	
	public void pozitieCamera(int i) throws NegativIndexException, ExtraIndexException{
		if(i < 0) throw new NegativIndexException("Indexul introdus este o valoare negativa.");
		if(i > camere.size()) throw new ExtraIndexException("Indexul introdus este mai mare decat lungimea listei.");
		System.out.println(camere.get(i).descriere());
	}


	public void afisare(){
		System.out.println("Clientul "
						+nume+" "+prenume
						+" a rezervat urmatoarele camere:");
		for(Camera c:camere){
			c.afisare();
		}
	}
	
	public int getSize() throws ZeroDimensiuneListaException{
		if(camere.size() == 0) throw new ZeroDimensiuneListaException("Dimensiunea listei este 0");
		return camere.size();
	}

	public void inregistrareCamera(Camera c) throws ZeroValoareIdException, NegativValoareIdException, MaxValoareIdException{
		if(c.getNrCamera() == 0) throw new ZeroValoareIdException("Valoarea 0 nu poate fi introdusa pt camera");
		
		if(c.getNrCamera() < 0) throw new NegativValoareIdException("Valoarea negativa nu poate fi introdusa pt o camera.");
		
		if(c.getNrCamera() > 10000000) throw new MaxValoareIdException("Valoarea introdusa este aberanta, mult prea mare");
		
		System.out.println("Detalii -  "+c.descriere());
	}


	public void platesteCamera(Camera cam1) throws MaxValoareBugetException, NegativValoarePretException, 
	 												ZeroValoarePretException, InvalidValoareException{	
		if(cam1.getPret() > BUGET) throw new MaxValoareBugetException("Pretul camerei depaseste bugetul.");
		if(cam1.getPret() < 0.0) throw new NegativValoarePretException("Pretul camerei nu poate fi negativ.");
		if(cam1.getPret() == 0.0) throw new ZeroValoarePretException("Pretul camerei nu poate fi zero.");
		
		if(!isValoareValida(cam1.getPret())) throw new InvalidValoareException("Pretul introdus are o valoare aberanta.");
		
	 	cost += cam1.getPret();
	 	System.out.println("Costul este: "+cost);
	}
	 
	private static boolean isValoareValida(double v){
		 		double val = v*100;
		 		double numarIntreg = Math.floor(val);
		 		double valoare = (double)numarIntreg / 100.0;
		 		
		 		if(v <= valoare)
		 			return true;
		 		
		 		return false;
		 	}
	
	public void primesteDiscount(double cost) throws ZeroCostException, NegativCostException, InvalidCostException{
		if(cost == 0) throw new ZeroCostException("Valoarea costului nu poate fi 0, nu se poate aplica discount.");
		if(cost < 0) throw new NegativCostException("Valoarea costului nu poate fi negativa.");
		if(!isValoareValida(cost)) throw new InvalidCostException("Valoarea costului este aberanta.");
		
		if(camere.size() >=2 ){
			cost = cost*0.80;
			System.out.println(cost);
		}
	}
	
	public void validareDurataCazare(int nrZile) throws ZeroDurataCazareException, NegativDurataCazareException, InvalidDurataCazareException{
		if (nrZile == 0) throw new ZeroDurataCazareException("Valoarea introdusa pentru numarul de zile nu poate fi 0.");
		if (nrZile < 0) throw new NegativDurataCazareException("Valoarea introdusa pentru numarul de zile nu poate fi negativa.");
		if (nrZile > 322) throw new InvalidDurataCazareException("Valoarea introdusa pentru numarul de zile este aberanta.");
		
		System.out.println("Numarul de zile de cazare ale clientului este "+nrZile);
	}
}

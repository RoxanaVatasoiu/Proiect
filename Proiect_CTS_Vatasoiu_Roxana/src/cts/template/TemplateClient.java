package cts.template;

public class TemplateClient extends Template{

	@Override
	public void rezervaCamera(int nrCamere) {
		System.out.println("Numarul de camere rezervate este: "+nrCamere);
		
	}

	@Override
	public void introduceDatePersonale() {
		System.out.println("Datele personale au fost introduse.");
	}

	@Override
	public void selectareModPlata() {
		System.out.println("Campul mod de plata a fost completat.");
	}

	@Override
	public void platesteCamera() {
		System.out.println("Clientul a achitat suma aferenta camerei.");
	}

}

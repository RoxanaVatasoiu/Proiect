package cts.template;

public abstract class Template {

	//private int nr;

	public abstract void rezervaCamera(int nrCamere);
	public abstract void introduceDatePersonale();
	public abstract void selectareModPlata();
	public abstract void platesteCamera();
	
	//functia template
	public void parcurge(int nr){
		rezervaCamera(nr);
		introduceDatePersonale();
		selectareModPlata();
		platesteCamera();
	}
}

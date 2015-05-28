package cts.builder;

public class CameraBuilder {

	private Camera camera = null;  //referinta
	
	public CameraBuilder(int nrCamera, int etaj, int nrPaturi, double pret){
		this.camera = new Camera(nrCamera, etaj, nrPaturi, pret);
	}
	
	public CameraBuilder hasAerConditionat(){
		this.camera.hasAerConditionat = true;
		return this;
	}
	
	public CameraBuilder hasTelevizor(){
		this.camera.hasTelevizor = true;
		return this;
	}
	
	public CameraBuilder hasFrigider(){
		this.camera.hasFrigider = true;
		return this;
	}
	
	public Camera build(){
		return this.camera;
	}
	
}

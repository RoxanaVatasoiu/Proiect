package cts.builder;

import cts.interfete.IDescriere;

public class Camera implements IDescriere{
	private int nrCamera;
	private int etaj;
	private int nrPaturi;
	private double pret;
	
	boolean hasAerConditionat;
	boolean hasTelevizor;
	boolean hasFrigider;
	
	public Camera(int nrCamera, int etaj, int nrPaturi, double pret){
		this.nrCamera = nrCamera;
		this.etaj = etaj;
		this.nrPaturi = nrPaturi;
		this.pret = pret;
	}

	public int getNrCamera() {
		return nrCamera;
	}

	public int getEtaj() {
		return etaj;
	}

	public int getNrPaturi() {
		return nrPaturi;
	}

	public double getPret(){
		return pret;
	}
	
	public boolean isHasAerConditionat() {
		return hasAerConditionat;
	}

	public boolean isHasTelevizor() {
		return hasTelevizor;
	}

	public boolean isHasFrigider() {
		return hasFrigider;
	}

	public String descriere() {
		return "Camera: " + nrCamera + ", etaj=" + etaj
				+ ", nrPaturi=" + nrPaturi +", pret= "+pret+ ", hasAerConditionat="
				+ hasAerConditionat + ", hasTelevizor=" + hasTelevizor
				+ ", hasFrigider=" + hasFrigider;
	}
	
	
	public void afisare() {
		System.out.println("Camera: " + nrCamera + ", etaj=" + etaj
				+ ", nrPaturi=" + nrPaturi +", pret= "+pret+ ", hasAerConditionat="
				+ hasAerConditionat + ", hasTelevizor=" + hasTelevizor
				+ ", hasFrigider=" + hasFrigider);
	}
	
	
}

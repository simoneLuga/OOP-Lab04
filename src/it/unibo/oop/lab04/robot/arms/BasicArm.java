package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	
	private String Name;
	private boolean grab;
	private static final double consuptionForPickUp = 0.5;
	private static final double consuptionForDropDown = 0.5;
	
	public BasicArm(String name) {
		this.Name=name;
	}
	
	public boolean isGrabbing() {
		return this.grab;
	}
	
	public void pickUp() {
		this.grab=true;
		
	}
	
	public void dropDown() {
		this.grab=false;
	}
	
	public double getConsuptionForPickUp() {
		return consuptionForPickUp;
	}

	public double getConsuptionForDropDown() {
		return consuptionForDropDown;
	}

	@Override
	public String toString() {
		return "BasicArm [Name=" + Name + ", grab=" + grab + "]";
	}
	
}

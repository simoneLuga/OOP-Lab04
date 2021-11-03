package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{
	
	private BasicArm left;
	private BasicArm right;
	private int itemsCarried;

	public RobotWithTwoArms(String robotName) {
		super(robotName);
		this.left=new BasicArm(robotName);
		this.right=new BasicArm(robotName);
	}

	@Override
	public boolean pickUp() {
		if(!left.isGrabbing()) {
			left.pickUp();
			this.itemsCarried++;
			return true;
		}else {
			if(!right.isGrabbing()) {
				right.pickUp();
				this.itemsCarried++;
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public boolean dropDown() {
		if(left.isGrabbing()) {
			left.dropDown();
			this.itemsCarried--;
			return true;
		}else {
			if(right.isGrabbing()) {
				right.dropDown();
				this.itemsCarried--;
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public int getCarriedItemsCount() {
		return this.itemsCarried;
	}
	
	protected double getBatteryRequirementForMovement() {
		double consuption=MOVEMENT_DELTA_CONSUMPTION;;
		if(left.isGrabbing()==true) {
			consuption+= MOVEMENT_DELTA_CONSUMPTION;
		}
		if(right.isGrabbing()==true) {
			consuption+= MOVEMENT_DELTA_CONSUMPTION;
		}
		
		return consuption;
	}

}

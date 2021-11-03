package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot {
	
	boolean pickUp();//picks an object, return true if is successful
	
	boolean dropDown();//drops object return true if is successful
	
	int getCarriedItemsCount();// return n. object this robot is trasporting

}

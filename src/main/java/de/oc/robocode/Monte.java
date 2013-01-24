package de.oc.robocode;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Monte extends Robot {

	private double radius = 100.0;
	private double angle = 60.0;

	@Override
	public void run() {
		setUp();
		while (true) {
			ahead(radius);
			turnGunLeft(angle);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fireBullet(getEnergy());
	}

	public void onHitByBullet(HitByBulletEvent e) {
		if (e.getName().equals("de.oc.robocode.Curando")) {
			turnLeft(e.getBearing());
			ahead(300);
		}
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		turnLeft(event.getBearing() - 110);
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		turnRight(45);
		ahead(radius);
	}
	
	private void setUp() {
		setBodyColor(Color.lightGray);
		setGunColor(Color.gray);
		setRadarColor(Color.darkGray);
	}

}

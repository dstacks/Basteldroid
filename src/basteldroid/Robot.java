package basteldroid;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Robot {
	
	// Variablen welche nur in einer Klasse benötigt werden, sollten Privat sein
	// So können nur die dazugehörigen Methoden diese ändern.
	final int JUMPSPEED = -15;
	final int MOVESPEED = 5;
	// final int GROUND = 382;
	
	private static int centerX = 100;
	// private int centerY = GROUND;
	private int centerY = 377;
	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;
	private ArrayList projectiles = new ArrayList();
	
	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();
	
	private int speedX = 0;
	// private int speedY = 1;
	private int speedY = 0;
	public static Rectangle rect = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect2 = new Rectangle(0, 0 ,0 ,0);
	public static Rectangle rect3 = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect4 = new Rectangle(0, 0, 0, 0);
	public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);
	public static Rectangle footleft = new Rectangle(0, 0, 0, 0);
	public static Rectangle footright = new Rectangle(0, 0, 0, 0);
	
	public void update() {
		
		// Bewegt den Roboter oder passt den Hintergrund an.
		if (speedX < 0) {
			centerX += speedX; // Hier wird speedX zu centerX addiert
		}
		
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);
		}
		
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		
		if (speedX > 0 && centerX > 200) {
			bg1.setSpeedX(-MOVESPEED / 5);
			bg2.setSpeedX(-MOVESPEED / 5);
		}
		
		// Update der Y Position
		centerY += speedY;
		
//		if (centerY + speedY >= GROUND) {
//			centerY = GROUND;
//			// 382 bedeutet unsere Figur steht auf dem Boden
//		}
		
		// Hier wird das Springen kontolliert
//		if (jumped == true) {
//			speedY += 1; // Solange die Figur in der Luft ist, addiere 1
			// Dadurch fällt die Figur auf den Boden
			
//			if (centerY + speedY >= GROUND) {
//				centerY = GROUND;
//				speedY = 0;
//				jumped = false;
//			}
//			
//			else {
//				centerY += speedY;
//			}
//		}
		speedY += 1;
		if (speedY > 3) {
			jumped = true;
		}
		
		// Verhindert das unsere Spielfigur einen gewissen Punkt
		// in X Richtung überschreitet
		if (centerX + speedX <= 60) {
			// Falls bei addieren von speedX und centerX auf kleiner als 60 fällt
			// ist speedX = 61
			centerX = 61;
		}
		
		rect.setRect(centerX - 34, centerY - 63, 68, 63);
		rect2.setRect(rect.getX(), rect.getY() + 63, 68, 64);
		rect3.setRect(rect.getX() - 26, rect.getY() + 32, 26, 20);
		rect4.setRect(rect.getX() + 68, rect.getY() + 32, 26, 20);
		yellowRed.setRect(centerX - 110, centerY - 110, 180, 180);
		footleft.setRect(centerX - 50, centerY + 20, 50, 15);
		footright.setRect(centerX, centerY + 20, 50, 15);
	}
	
	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}
	
	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}
	
	public void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}
		
		else if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}
		
		else if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}
		
	}
	
	public void stopRight() {
		setMovingRight(false);
		stop();
	}
	
	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}
	
	public void jump() {
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}
	}
	
	public void shoot() {
		if (readyToFire) {
			Projectiles p = new Projectiles(centerX + 50, centerY - 25);
			projectiles.add(p); 
		}
	}
	
	// ab hier Getters und Setters

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	public int getMOVESPEED() {
		return MOVESPEED;
	}

//	public int getGROUND() {
//		return GROUND;
//	}

	public static int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public boolean isDucked() {
		return ducked;
	}

	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public static void setBg1(Background bg1) {
		Robot.bg1 = bg1;
	}

	public static void setBg2(Background bg2) {
		Robot.bg2 = bg2;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public ArrayList getProjectiles() {
		return projectiles;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}
}

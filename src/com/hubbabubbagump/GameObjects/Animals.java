package com.hubbabubbagump.GameObjects;


import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.hubbabubbagump.Screens.GameScreen;

public class Animals extends Scrollable{
	
	private Circle circle;
	
	public static final int SHROOMAMOUNT = 2; //how many fruit images there are (apple, etc)
	
	public boolean eaten = false;
	
	public static final float RADIUS = (float) 6.5;
	
	public static final int MINIMUM_HEIGHT = 20;
	public static final int MAXIMUM_HEIGHT = (int) (GameScreen.midScreen() + 26);

	
	public Animals(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);

		circle = new Circle();
		
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		//position.x and position.x are the coordinates for the center of the circle
		circle.set(getX() + 5, getY() + 5, RADIUS);

	}
	
	@Override
	public void reset(float newX) {
		super.reset(newX);
		eaten = false; //sets eaten back to false
		
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public boolean collides(BearCopter bear) {
		//checks if the wall and circle around the bear overlap
		if(!eaten) {
			return (Intersector.overlaps(bear.getBoundingCircle(), circle));
		}
		return false;
	}
	
	public boolean shroomCollide(Shroom shroom) {
		return (Intersector.overlaps(shroom.getCircle(), circle));
	}
	
	public void restart(float x, float y, float scrollSpeed) {
		velocity.x = scrollSpeed;
		position.y = y;
		reset(x);
	}
	
	public float getY() {
		return (float) (position.y);
	}
	
	 public float getX() {
	     return (float) (position.x);
	 }
	
	public boolean isEaten() {
		return eaten;
	}
	
	public void ate() {
		//The bear has "eaten" the shroom
		eaten = true;
	}
	
	
	 public void reverse(boolean high) {
		 velocity.x = -velocity.x;
		 

		 if (position.x <= 68) {
			 position.x = 136 - position.x;
		 }
		 else if (position.x > 68) {
			 position.x = 136 - position.x;
		 }
	 }

	 public boolean combo() {
			//if the fruit is behind bear and isn't eaten, returns true
			if(position.x <= 25  && !eaten) {
				return true;
			}
			return false;
	}
}

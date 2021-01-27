package com.techelevator;

public class RectangleWall extends Wall {

	public int length;
	public int height;
	
	public RectangleWall(String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}
	
	public int getArea() {
		int area = (length * height);
		return area;
		
	}
	
	public String toString() {
		return super.getName() + " (" + length + "x" + height + ") " + "rectangle";
	}
	
	
}

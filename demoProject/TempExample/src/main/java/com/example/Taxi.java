package com.example;

public class Taxi {
	private int id;
	private String color;
	private Location location;
	
	public Taxi(int id, String color, Location location) {
		this.id = id;
		this.color = color;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Taxi["+ id + "," + color + "," + location + "]\n";
	}
}

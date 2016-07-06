package com.example;

public class Customer {
	private String name;
	private int id;
	private Location startLocation;
	private Location endLocation;
	
	public Customer(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Location getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}
	public Location getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	
	@Override
	public String toString() {
		return "Customer[" + name + "," + id + "," + startLocation + "," + endLocation + "]";
	}
	
	public String requestTaxi(int id, Location startLocation, Location endLocation,String taxitype){
		
		return name;
	}
}

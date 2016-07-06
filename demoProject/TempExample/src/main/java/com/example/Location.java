package com.example;

import java.util.Random;

public class Location {
	private double latitude;
	private double longitude;
	
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "["+latitude + "," + longitude + "]";
	}
	
	public static Location getRandomLocation(){
		Random random = new Random();
		return new Location(random.nextInt(100), random.nextInt(100));
	}
	
	
	public double getDistance(Location location) {
		return Math.sqrt((this.latitude-location.latitude)*(this.latitude-location.latitude) + (this.longitude-location.longitude)*(this.longitude-location.longitude));
	}
}

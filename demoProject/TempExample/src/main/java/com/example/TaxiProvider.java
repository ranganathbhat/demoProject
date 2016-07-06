package com.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TaxiProvider {
	private List<Taxi> taxiList = new ArrayList<Taxi>();
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private Map<Customer,Taxi> customerTaxiMap = new HashMap<Customer,Taxi>();
	
	public List<Taxi> getTaxiList() {
		return taxiList;
	}
	public void addToTaxiList(Taxi taxi) {
		this.taxiList.add(taxi);
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void addToCustomerList(Customer customer) {
		this.customerList.add(customer);
	}
	public Map<Customer,Taxi> getCustomerTaxiMap() {
		return customerTaxiMap;
	}
	public void addToCustomerTaxiMap(Customer customer,Taxi taxi) {
		this.customerTaxiMap.put(customer, taxi);
	}
	
	@Override
	public String toString() {
		return "TaxiProvider[taxiList\n" + taxiList + "]";
	}
	
	public List<Taxi> getRandomTaxiList(int n){
		String color[] ={"red","blue","white","pink"} ;
		Random random = new Random();
		taxiList.clear();
		
		for (int i = 0; i < n; i++) {
			Taxi taxi = new Taxi(i+1, color[random.nextInt(color.length)], Location.getRandomLocation());
			taxiList.add(taxi);
		}
		
		return taxiList;
	}
	
	public Taxi processCustomerRequest(Customer customer, String taxitype){
		double nearest = 50;
		Taxi nearestTaxi = null;
		
		System.out.println("Customer Request: " + customer +", requested car type :" + taxitype);
		
		for (Taxi taxi : taxiList) {
			double distance = customer.getStartLocation().getDistance(taxi.getLocation());
			if(distance<=nearest && taxitype.equals(taxi.getColor())){
				nearest = distance;
				nearestTaxi = taxi;
			}
		}
		
		if(nearestTaxi==null){
			return null;
		}
		
		this.addToCustomerTaxiMap(customer, nearestTaxi);
		System.out.println("Customer Request granted: " + customer.getName() +", car no :" + nearestTaxi.getId());
		return nearestTaxi;
	}
	
	public int calculatePrice(Customer customer){
		Double price = 0D;
		
		DecimalFormat f = new DecimalFormat("##.00");
		Taxi taxi = customerTaxiMap.get(customer);
		double traveledDistance = customer.getStartLocation().getDistance(customer.getEndLocation());
		double traveledTime = traveledDistance*2;   //speed = 30km/hr
		
		if("pink".equals(taxi.getColor())){
			price = price + 5;
		}
		
		price = price + traveledDistance * 2 + traveledTime * 1;
		int roundUpPrice = (int) (Math.round( price * 100.0 ) / 100.0);
		
		System.out.println("Journey log: " + customer.getName() +", "+ f.format(traveledDistance) +"km, "+ f.format(traveledTime) +"min, dogecoin " + roundUpPrice);
		
		return roundUpPrice;
	}
}

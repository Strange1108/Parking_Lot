package services;

import java.util.List;

import entity.Car;

public interface ParkingLotService 
{
	public int park(String regNo, String color) throws Exception;
	
    public boolean leave(int slot) throws Exception;
    
    public List<Car> status() throws Exception;
    
    public List<String> registrationNumbersForCarsWithColour(String color) throws Exception;
    
    public List<Integer> slotNumbersForCarsWithColour(String color) throws Exception;
    
    public int slotNumberForRegistrationNumber(String regNo) throws Exception;
}

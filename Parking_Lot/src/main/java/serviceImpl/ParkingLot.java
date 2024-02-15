package serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import entity.Car;
import services.ParkingLotService;

@Service
public class ParkingLot implements ParkingLotService 
{
	private int capacity;
    private Map<Integer, Car> slots;

    public ParkingLot(int capacity)
    {
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    @Override
    public int park(String regNo, String color) throws Exception
    {
        for (int i = 1; i <= capacity; i++) 
        {
            if (!slots.containsKey(i)) 
            {
                slots.put(i, new Car(regNo, color));
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean leave(int slot) throws Exception
    {
        if (slots.containsKey(slot)) 
        {
            slots.remove(slot);
            return true;
        }
        return false;
    }

    @Override
    public List<Car> status() throws Exception
    {
        List<Car> result = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) 
        {
            Car car = entry.getValue();
            car.setSlot(entry.getKey());
            result.add(car);
        }
        return result;
    }


    @Override
    public List<String> registrationNumbersForCarsWithColour(String color) throws Exception
    {
        List<String> result = new ArrayList<>();
        for (Car car : slots.values()) 
        {
            if (car.getColor().equalsIgnoreCase(color)) 
            {
                result.add(car.getRegNo());
            }
        }
        return result;
    }

    @Override
    public List<Integer> slotNumbersForCarsWithColour(String color) throws Exception
    {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) 
        {
            if (entry.getValue().getColor().equalsIgnoreCase(color)) 
            {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    @Override
    public int slotNumberForRegistrationNumber(String regNo) throws Exception
    {
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) 
        {
            if (entry.getValue().getRegNo().equalsIgnoreCase(regNo)) 
            {
                return entry.getKey();
            }
        }
        return -1;
    }
}

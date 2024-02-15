package com.word.Parking_Lot;

import java.util.List;
import java.util.Scanner;

import entity.Car;
import serviceImpl.ParkingLot;
import services.ParkingLotService;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        ParkingLotService parkingLot = null;

        while (true) 
        {
            String[] command = scanner.nextLine().split(" ");
            if (command.length == 0) 
            {
                continue;
            }

            try 
            {
                switch (command[0]) 
                {
                    case "create_parking_lot":
                        int capacity = Integer.parseInt(command[1]);
                        parkingLot = new ParkingLot(capacity);
                        System.out.println("Created a parking lot with " + capacity + " slots");
                        break;

                    case "park":
                        String regNo = command[1];
                        String color = command[2];
                        int slot = parkingLot.park(regNo, color);
                        if (slot == -1) 
                        {
                            System.out.println("Sorry, parking lot is full");
                        } 
                        else 
                        {
                            System.out.println("Allocated slot number: " + slot);
                        }
                        break;

                    case "leave":
                        int slotToLeave = Integer.parseInt(command[1]);
                        if (parkingLot.leave(slotToLeave)) 
                        {
                            System.out.println("Slot number " + slotToLeave + " is free");
                        } 
                        else 
                        {
                            System.out.println("Slot number " + slotToLeave + " is not valid");
                        }
                        break;

                    case "status":
                        System.out.println("Slot No. Registration No Colour");
                        for (Car car : parkingLot.status()) 
                        {
                            System.out.println(car.getSlot() + " " + car.getRegNo() + " " + car.getColor());
                        }
                        break;

                    case "registration_numbers_for_cars_with_colour":
                        List<String> regNos = parkingLot.registrationNumbersForCarsWithColour(command[1]);
                        System.out.println(String.join(", ", regNos));
                        break;

                    case "slot_numbers_for_cars_with_colour":
                        List<Integer> slots = parkingLot.slotNumbersForCarsWithColour(command[1]);
                        System.out.println(String.join(", ", slots.stream().map(String::valueOf).toArray(String[]::new)));
                        break;

                    case "slot_number_for_registration_number":
                        int slotNumber = parkingLot.slotNumberForRegistrationNumber(command[1]);
                        if (slotNumber == -1) 
                        {
                            System.out.println("Not found");
                        } else 
                        {
                            System.out.println(slotNumber);
                        }
                        break;

                    case "exit":
                    	scanner.close();
                        return;

                    default:
                        System.out.println("Invalid command");
                        break;
                }
            } 
            catch (Exception e) 
            {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

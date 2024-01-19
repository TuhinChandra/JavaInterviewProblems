package com.tuhin.examples;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

enum VehicleType {
    CAR,
    MOTORCYCLE
}

class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private VehicleType vehicleType;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.occupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void vacate() {
        occupied = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        spots = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            spots.add(new ParkingSpot(i + 1, i % 2 == 0 ? VehicleType.CAR : VehicleType.MOTORCYCLE));
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.occupy();
                System.out.println(vehicle + "parked at spot: " + spot.getSpotNumber());
                return spot;
            }
        }
        System.out.println("No available spot for " + vehicle);
        return null; // No available spot for the given vehicle type
    }

    public void vacateSpot(ParkingSpot spot) {
        System.out.println("Spot " + spot.getSpotNumber() + " vacated for "+ spot.getVehicleType());
        spot.vacate();
    }
}

@ToString
class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);

        Vehicle car = new Vehicle("Mercidise", VehicleType.CAR);
        Vehicle ferrai = new Vehicle("Ferrai", VehicleType.CAR);
        Vehicle motorcycle = new Vehicle("Royal Enfield", VehicleType.MOTORCYCLE);

        ParkingSpot carSpot = parkingLot.parkVehicle(car);
        ParkingSpot ferraiSpot = parkingLot.parkVehicle(ferrai);
        ParkingSpot motorcycleSpot = parkingLot.parkVehicle(motorcycle);
        ferraiSpot = parkingLot.parkVehicle(ferrai);
        parkingLot.vacateSpot(carSpot);
        parkingLot.parkVehicle(ferrai);
    }
}


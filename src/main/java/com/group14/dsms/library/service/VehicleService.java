package com.group14.dsms.library.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.group14.dsms.library.model.Vehicle;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class VehicleService {

    private final Path filePath = Path.of("src/main/resources/data/vehicles.json");
    private static int vehicleIdCounter = 1;
    private final FileStorageService<Vehicle> fileStorageService;

    public VehicleService(FileStorageService<Vehicle> fileStorageService) throws Exception {
        this.fileStorageService = fileStorageService;
        initializeIdCounter();
    }

    private void initializeIdCounter() throws Exception {
        List<Vehicle> vehicles = getAllVehicles();
        if (!vehicles.isEmpty()) {
            vehicleIdCounter = vehicles.stream()
                    .mapToInt(vehicle -> Integer.parseInt(vehicle.getId().substring(1)))
                    .max()
                    .orElse(0) + 1;
        }
    }

    public List<Vehicle> getAllVehicles() throws Exception {
        return fileStorageService.read(filePath, new TypeReference<>() {});
    }

    public Vehicle getVehicleById(String id) throws Exception {
        return getAllVehicles().stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveAllVehicles(List<Vehicle> vehicles) throws Exception {
        fileStorageService.write(filePath, vehicles);
    }

    public void addVehicle(Vehicle vehicle) throws Exception {
        List<Vehicle> vehicles = getAllVehicles();
        vehicle.setId(String.format("V%03d", vehicleIdCounter++));
        vehicles.add(vehicle);
        saveAllVehicles(vehicles);
    }

    public void updateVehicle(String id, Vehicle updatedVehicle) throws Exception {
        List<Vehicle> vehicles = getAllVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().equals(id)) {
                updatedVehicle.setId(id);
                vehicles.set(i, updatedVehicle);
                saveAllVehicles(vehicles);
                return;
            }
        }
        throw new Exception("Vehicle with ID " + id + " not found.");
    }

    public void deleteVehicle(String id) throws Exception {
        List<Vehicle> vehicles = getAllVehicles();
        boolean removed = vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
        if (removed) {
            saveAllVehicles(vehicles);
        } else {
            throw new Exception("Vehicle with ID " + id + " not found.");
        }
    }
}
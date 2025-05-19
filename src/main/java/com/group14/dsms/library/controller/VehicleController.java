package com.group14.dsms.library.controller;

import com.group14.dsms.library.model.Vehicle;
import com.group14.dsms.library.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String listVehicles(Model model) {
        try {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            model.addAttribute("vehicles", vehicles);
            return "vehicles";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving vehicle data.");
            return "error";
        }
    }

    @GetMapping("/add-vehicle")
    public String showAddVehicleForm() {
        return "add-vehicle";
    }

    @PostMapping("/add-vehicle")
    public String addVehicle(@RequestParam String model, @RequestParam int year,
                             @RequestParam String licensePlate, @RequestParam String type) {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setModel(model);
            vehicle.setYear(year);
            vehicle.setLicensePlate(licensePlate);
            vehicle.setType(type);
            vehicleService.addVehicle(vehicle);
            return "redirect:/vehicles";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/edit-vehicle/{id}")
    public String showEditVehicleForm(@PathVariable String id, Model model) {
        try {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getId().equals(id)) {
                    model.addAttribute("vehicle", vehicle);
                    return "edit-vehicle";
                }
            }
            return "error";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/edit-vehicle/{id}")
    public String editVehicle(@PathVariable String id, @RequestParam String model,
                              @RequestParam int year, @RequestParam String licensePlate,
                              @RequestParam String type) {
        try {
            Vehicle updatedVehicle = new Vehicle();
            updatedVehicle.setModel(model);
            updatedVehicle.setYear(year);
            updatedVehicle.setLicensePlate(licensePlate);
            updatedVehicle.setType(type);
            vehicleService.updateVehicle(id, updatedVehicle);
            return "redirect:/vehicles";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/delete-vehicle/{id}")
    public String deleteVehicle(@PathVariable String id) {
        try {
            vehicleService.deleteVehicle(id);
            return "redirect:/vehicles";
        } catch (Exception e) {
            return "error";
        }
    }
}
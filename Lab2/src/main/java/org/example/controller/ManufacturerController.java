package org.example.controller;

import org.example.dto.ManufacturerDto;
import org.example.entity.Manufacturer;
import org.example.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<ManufacturerDto> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @PostMapping
    public ManufacturerDto createManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerService.saveManufacturer(manufacturerDto);
    }

    @PutMapping("/{id}")
    public ManufacturerDto updateManufacturer(@PathVariable Long id, @RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerService.updateManufacturer(id, manufacturerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }

}

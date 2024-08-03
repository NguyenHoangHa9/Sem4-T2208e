package org.example.service;

import jakarta.persistence.Id;
import org.example.dto.ManufacturerDto;
import org.example.entity.Manufacturer;
import org.example.mapper.ManufacturerMapper;
import org.example.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerDto> getAllManufacturers() {
        return manufacturerRepository.findAll().stream()
                .map(ManufacturerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ManufacturerDto saveManufacturer(ManufacturerDto manufacturerDtO) {
        Manufacturer manufacturer = ManufacturerMapper.dtoToEntity(manufacturerDtO);
        return ManufacturerMapper.entityToDto(manufacturerRepository.save(manufacturer));
    }

    public ManufacturerDto updateManufacturer(Long id, ManufacturerDto manufacturerDto) {
        if (manufacturerRepository.existsById(id)) {
            Manufacturer manufacturer = ManufacturerMapper.dtoToEntity(manufacturerDto);
            manufacturer.setManufacturerId(id);
            return ManufacturerMapper.entityToDto(manufacturerRepository.save(manufacturer));
        }
        throw new RuntimeException("Manufacturer not found");
    }

    public void deleteManufacturer(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        if (!manufacturer.getProducts().isEmpty()) {
            throw new RuntimeException("Cannot delete manufacturer with products");
        }
        manufacturerRepository.delete(manufacturer);
    }
}

package org.example.mapper;


import org.example.dto.ManufacturerDto;
import org.example.entity.Manufacturer;
import org.springframework.beans.BeanUtils;

public class ManufacturerMapper {
    public static ManufacturerDto entityToDto (Manufacturer manufacturer) {
        ManufacturerDto dto = new ManufacturerDto();
        BeanUtils.copyProperties(manufacturer, dto);
        return dto;
    }

    public static Manufacturer dtoToEntity (ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer();
        BeanUtils.copyProperties(manufacturerDto, manufacturer);
        return manufacturer;
    }
}

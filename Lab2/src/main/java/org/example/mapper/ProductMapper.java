package org.example.mapper;

import org.example.dto.ProductDto;
import org.example.entity.Manufacturer;
import org.example.entity.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static ProductDto entityToDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        dto.setManufacturerId(product.getManufacturer().getManufacturerId());
        return dto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(productDto.getManufacturerId());
        product.setManufacturer(manufacturer);
        return product;
    }
}

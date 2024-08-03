package org.example.service;

import org.example.dto.ProductDto;
import org.example.entity.Product;
import org.example.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> searchProducts(String name) {
        return productRepository.findByNameContaining(name).stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = ProductMapper.dtoToEntity(productDto);
        return ProductMapper.entityToDto(productRepository.save(product));
    }

    public ProductDto updateProduct(Long id, ProductDto productDTO) {
        if (productRepository.existsById(id)) {
            Product product = ProductMapper.dtoToEntity(productDTO);
            product.setProductId(id);
            return ProductMapper.entityToDto(productRepository.save(product));
        }
        throw new RuntimeException("Product not found");
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

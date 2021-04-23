package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertToDto(ProductEntity entity) {
        ProductDTO result = modelMapper.map(entity, ProductDTO.class);
        return result;
    }

    public ProductEntity convertToEntity(ProductDTO dto) {
        ProductEntity result = modelMapper.map(dto, ProductEntity.class);
        return result;
    }
}

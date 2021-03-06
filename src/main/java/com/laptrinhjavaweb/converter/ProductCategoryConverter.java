package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ProductCategoryDTO;
import com.laptrinhjavaweb.entity.ProductCategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductCategoryDTO convertToDto(ProductCategoryEntity entity) {
        ProductCategoryDTO result = modelMapper.map(entity, ProductCategoryDTO.class);
        return result;
    }

    public ProductCategoryEntity convertToEntity(ProductCategoryDTO dto) {
        ProductCategoryEntity result = modelMapper.map(dto, ProductCategoryEntity.class);
        return result;
    }
}

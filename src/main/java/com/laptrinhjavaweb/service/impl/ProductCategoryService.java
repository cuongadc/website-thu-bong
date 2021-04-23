package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ProductCategoryConverter;
import com.laptrinhjavaweb.dto.ProductCategoryDTO;
import com.laptrinhjavaweb.entity.ProductCategoryEntity;
import com.laptrinhjavaweb.repository.ProductCategoryRepository;
import com.laptrinhjavaweb.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryConverter productCategoryConverter;

    @Override
    public Map<String, String> getCategories() {
        Map<String, String> results = new HashMap<>();
        productCategoryRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategoryEntity> productCategoryEntities = productCategoryRepository.findAll();
        return productCategoryEntities.stream().map(item -> productCategoryConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO findById(long id) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(id).get();
        ProductCategoryDTO productCategoryDTO = productCategoryConverter.convertToDto(productCategoryEntity);
        return productCategoryDTO;
    }

    @Override
    public ProductCategoryDTO findByCode(String code) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findOneByCode(code);
        ProductCategoryDTO productCategoryDTO = productCategoryConverter.convertToDto(productCategoryEntity);
        return productCategoryDTO;
    }

    @Override
    @Transactional
    public ProductCategoryDTO insert(ProductCategoryDTO productCategoryDTO) {
        ProductCategoryEntity productCategoryEntity = productCategoryConverter.convertToEntity(productCategoryDTO);
        return productCategoryConverter.convertToDto(productCategoryRepository.save(productCategoryEntity));
    }

    @Override
    @Transactional
    public ProductCategoryDTO update(ProductCategoryDTO productCategoryDTO) {
        //ProductCategoryEntity old = productCategoryRepository.findOne(productCategoryDTO.getId());
        ProductCategoryEntity old = productCategoryRepository.findById(productCategoryDTO.getId()).get();
        old.setName(productCategoryDTO.getName());
        old.setCode(productCategoryDTO.getCode());
        return productCategoryConverter.convertToDto(productCategoryRepository.save(old));
    }

    @Override
    @Transactional
    public void deleteProductCategory(long[] ids) {
        for (Long item : ids) {
            //productCategoryRepository.delete(item);
            productCategoryRepository.deleteById(item);
        }
    }
}

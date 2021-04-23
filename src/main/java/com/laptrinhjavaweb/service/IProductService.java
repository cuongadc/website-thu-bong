package com.laptrinhjavaweb.service;
import com.laptrinhjavaweb.dto.HomeSearchDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<ProductDTO> findAll(String name, Pageable pageable);
    List<ProductDTO> findAll();
    List<ProductDTO> findProductHot();
    int getTotalItems(String name);
    ProductDTO insert(ProductDTO productDTO);
    ProductDTO findById(long id);
    ProductDTO update(ProductDTO productDTO);
    void deleteProduct(long[] ids);
    List<ProductDTO> findAll(String category);
}

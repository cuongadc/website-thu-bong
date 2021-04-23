package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductCategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.utils.UploadFileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductDTO> findAll(String name, Pageable pageable) {
        List<ProductEntity> results = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            results = productRepository.findByNameContainingIgnoreCase(name, pageable).getContent();
        } else {
            results = productRepository.findAll(pageable).getContent();
        }
        return results.stream().map(item -> productConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> results = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        for (ProductEntity productEntity: productEntities) {
            ProductDTO productDTO = productConverter.convertToDto(productEntity);
            results.add(productDTO);
        }
        return results;
    }

    @Override
    public List<ProductDTO> findProductHot() {
        List<ProductDTO> results = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findByProductHot(1);
        for (ProductEntity productEntity: productEntities) {
            ProductDTO productDTO = productConverter.convertToDto(productEntity);
            if (StringUtils.isNotBlank(productEntity.getImages())) {
                productDTO.setThumbnail(productEntity.getImages().split(",")[0]);
            }
            results.add(productDTO);
        }
        return results;
    }

    @Override
    public int getTotalItems(String name) {
        if (StringUtils.isNotBlank(name)) {
            return (int) productRepository.countByNameContainingIgnoreCase(name);
        } else {
            return (int) productRepository.count();
        }
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        ProductEntity productEntity = productConverter.convertToEntity(productDTO);
        productEntity.setProductCategory(productCategoryRepository.findOneByCode(productDTO.getProductCategoryCode()));
        if (productDTO.isHotProduct()) {
            productEntity.setProductHot(1);
        } else {
            productEntity.setProductHot(0);
        }
        saveImages(productDTO, productEntity);
        productEntity = productRepository.save(productEntity);
        return productConverter.convertToDto(productEntity);
    }

    private void saveImages(ProductDTO productDTO, ProductEntity productEntity) {
        if (productDTO.getBase64Images() != null && productDTO.getBase64Images().length > 0) {
           List<String> images = new ArrayList<>();
           for (Map.Entry<String, String> entry : productDTO.getImageMaps().entrySet()) {
                String path = "/product" + "/" + entry.getKey();
                if (productEntity.getImages() != null) {
                    if (!productEntity.getImages().contains(path)) {
                        File file = new File("C:/home/javawebuat/teddybear" + path);
                        //File file = new File("/home/javawebuat/teddybear" + path);
                        file.delete();
                    }
                }
                byte[] bytes = Base64.decodeBase64(entry.getValue().getBytes());
                uploadFileUtils.writeOrUpdate(path, bytes);
               images.add(path);
           }
           productEntity.setImages(String.join(",", images));
        }
    }

    @Override
    @Transactional
    public ProductDTO update(ProductDTO productDTO) {
        try {
            ProductEntity existsProduct = productRepository.findById(productDTO.getId()).get();
            ProductEntity updateProduct = productConverter.convertToEntity(productDTO);
            updateProduct.setCreatedBy(existsProduct.getCreatedBy());
            updateProduct.setCreatedDate(existsProduct.getCreatedDate());
            updateProduct.setProductCategory(productCategoryRepository.findOneByCode(productDTO.getProductCategoryCode()));
            if (productDTO.isHotProduct()) {
                updateProduct.setProductHot(1);
            } else {
                updateProduct.setProductHot(0);
            }
            saveImages(productDTO, updateProduct);
            if (productDTO.getBase64Images() == null) {
                if (StringUtils.isNotBlank(existsProduct.getImages())) {
                    updateProduct.setImages(existsProduct.getImages());
                }
            }
            productRepository.save(updateProduct);
            return productConverter.convertToDto(updateProduct);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteProduct(long[] ids) {
        for (long item : ids) {
            //productRepository.delete(item);
            productRepository.deleteById(item);
        }
    }

    @Override
    public List<ProductDTO> findAll(String category) {
        List<ProductDTO> results = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findByProductCategory_Code(category);
        for (ProductEntity item: productEntities) {
            ProductDTO productDTO = productConverter.convertToDto(item);
            if (StringUtils.isNotBlank(item.getImages())) {
                productDTO.setSingleImage(item.getImages().split(",")[0]);
            }
            results.add(productDTO);
        }
        return results;
    }

    @Override
    public ProductDTO findById(long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        ProductDTO productDTO = productConverter.convertToDto(productEntity);
        if (StringUtils.isNotBlank(productDTO.getImages())) {
            productDTO.setImageProducts(Arrays.asList(productDTO.getImages().split(",")));
            productDTO.setFirstImage(productEntity.getImages().split(",")[0]);
        }
        if (productEntity.getProductHot() == 1) {
            productDTO.setHotProduct(true);
        } else {
            productDTO.setHotProduct(false);
        }
        return productDTO;
    }
}

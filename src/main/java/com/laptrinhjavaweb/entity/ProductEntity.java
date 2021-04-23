package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	@Column
	private String name;
	
	@Column
	private String code;

	@Column(name = "producthot", columnDefinition = "integer default 0")
	private Integer productHot;

	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(columnDefinition = "TEXT")
	private String images;

	@Column(name = "seourl", columnDefinition = "TEXT")
	private String seoUrl;
	
	@Column(columnDefinition = "TEXT")
	private String specification;

	@Column(columnDefinition = "TEXT")
	private String feature;

	@Column
	private Integer price;

	@Column
	private Integer quantity;

	@Column(columnDefinition = "TEXT", name = "pricedescription")
	private String priceDescription;

	@ManyToOne
	@JoinColumn(name = "productcategoryid")
	private ProductCategoryEntity productCategory;

	@OneToMany(mappedBy = "productOrder", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderEntity> orders = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public ProductCategoryEntity getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryEntity productCategory) {
		this.productCategory = productCategory;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPriceDescription() {
		return priceDescription;
	}

	public void setPriceDescription(String priceDescription) {
		this.priceDescription = priceDescription;
	}

	public String getSeoUrl() {
		return seoUrl;
	}

	public void setSeoUrl(String seoUrl) {
		this.seoUrl = seoUrl;
	}

	public Integer getProductHot() {
		return productHot;
	}

	public void setProductHot(Integer productHot) {
		this.productHot = productHot;
	}
}
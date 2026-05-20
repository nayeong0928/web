package com.example.demo.application;

import com.example.demo.domain.Product;
import com.example.demo.infrastructure.ListProductRepository;
import com.example.demo.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    public SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper, ValidationService validationService) {
        this.listProductRepository = listProductRepository;
        this.modelMapper=modelMapper;
        this.validationService=validationService;
    }

    public ProductDto add(ProductDto productDto){
        // 새로운 product 생성
        Product product= modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);      // 유효성 체크

        // 생성한 product 저장
        Product savedProduct= listProductRepository.add(product);

        // 생성한 product 정보 -> dto로 리턴
        ProductDto savedProductDto= modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product product= listProductRepository.findById(id);
        ProductDto productDto=modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> findAll(){
        List<Product> products=listProductRepository.findAll();
        List<ProductDto> productDtos=products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findNameContaining(String name){
        List<Product> products=listProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos=products.stream()
                .map(product->modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public ProductDto update(Long id, ProductDto productDto){
        Product product=modelMapper.map(productDto, Product.class);
        Product updatedProduct= listProductRepository.update(product);
        ProductDto updatedProductDto=modelMapper.map(updatedProduct, ProductDto.class);
        return updatedProductDto;
    }

    public void delete(Long id){
        listProductRepository.delete(id);
    }
}

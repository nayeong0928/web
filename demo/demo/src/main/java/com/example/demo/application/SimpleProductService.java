package com.example.demo.application;

import com.example.demo.domain.Product;
import com.example.demo.infrastructure.ListProductRepository;
import com.example.demo.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    public SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper=modelMapper;
    }

    public ProductDto add(ProductDto productDto){
        // 새로운 product 생성
        Product product= modelMapper.map(productDto, Product.class);

        // 생성한 product 저장
        Product savedProduct= listProductRepository.add(product);

        // 생성한 product 정보 -> dto로 리턴
        ProductDto savedProductDto= modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }
}

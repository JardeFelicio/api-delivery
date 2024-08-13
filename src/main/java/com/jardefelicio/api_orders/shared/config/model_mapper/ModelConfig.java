package com.jardefelicio.api_orders.shared.config.model_mapper;

import com.jardefelicio.api_orders.modules.product.dtos.ProductResponseDTO;
import com.jardefelicio.api_orders.modules.product.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<ProductEntity, ProductResponseDTO>() {
            @Override
            protected void configure() {
                map().setCompanyId(source.getCompany().getId());
            }
        });

        return modelMapper;
    }
}

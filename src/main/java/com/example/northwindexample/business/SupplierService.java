package com.example.northwindexample.business;

import com.example.northwindexample.business.responses.GetAllSuppliersResponse;
import com.example.northwindexample.business.responses.GetProductsPerSuppliersResponse;
import com.example.northwindexample.business.responses.GetSuppliersandTheirProductsResponse;
import com.example.northwindexample.core.mappers.ModelMapperService;
import com.example.northwindexample.entities.Supplier;
import com.example.northwindexample.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;
    public List<GetAllSuppliersResponse> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();

        List<GetAllSuppliersResponse> getAllSuppliersResponses = suppliers.stream()
                .map(supplier -> this.modelMapperService.forResponse()
                        .map(supplier, GetAllSuppliersResponse.class))
                .collect(Collectors.toList());

        return getAllSuppliersResponses;
    }

    public List<GetProductsPerSuppliersResponse> productsPerSuppliers() {
        return this.supplierRepository.productsPerSuppliers();
    }

    public List<GetSuppliersandTheirProductsResponse> getSuppliersandTheirProducts() {
        return this.supplierRepository.getSuppliersandTheirProducts();
    }

}

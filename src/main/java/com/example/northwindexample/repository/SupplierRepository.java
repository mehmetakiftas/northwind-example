package com.example.northwindexample.repository;

import com.example.northwindexample.business.responses.GetProductsPerSuppliersResponse;
import com.example.northwindexample.business.responses.GetSuppliersandTheirProductsResponse;
import com.example.northwindexample.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    // Her bir tedarikçide toplam kaç ürün var, büyükten küçüğe sıralı göster
    @Query(value = "SELECT new com.example.northwindexample.business.responses.GetProductsPerSuppliersResponse(s.supplierName, COUNT(p.productId) AS ProductCount) " +
            "FROM Supplier s " +
            "LEFT JOIN Product p ON s.supplierId = p.supplier.id " +
            "GROUP BY s.supplierName " +
            "ORDER BY ProductCount DESC")
    List<GetProductsPerSuppliersResponse> productsPerSuppliers();

    // Tedarikçi ve ürün bilgilerini listele
    @Query(value = "SELECT new com.example.northwindexample.business.responses.GetSuppliersandTheirProductsResponse(p.supplier.supplierName, ARRAY_AGG(p.productName) AS productArray) " +
            "FROM Product p " +
            "INNER JOIN Supplier s ON p.supplier.id = s.supplierId " +
            "GROUP BY s.supplierName")
    List<GetSuppliersandTheirProductsResponse> getSuppliersandTheirProducts();

}

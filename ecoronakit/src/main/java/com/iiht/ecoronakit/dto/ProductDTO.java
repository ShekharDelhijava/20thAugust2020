package com.iiht.ecoronakit.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {

    private String productName;
    private String productCost;
    private byte[] productImage;
    private String productDescription;
    private String productSpecification;
    private String category;
    private Long barcode;
}

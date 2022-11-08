package org.example.expection;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.pojo.ProductCategory;

@Data
@AllArgsConstructor
public class BulkBuyLimitCategory {
    private ProductCategory productCategory;
    private Integer limit;
}

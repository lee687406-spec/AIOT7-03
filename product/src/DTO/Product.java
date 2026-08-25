package DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int no;                     // 상품번호
    private String name;                // 상품명
    private int price;                  // 가격
    private String description;         // 설명
    private Date createdAt;             // 등록일자
    private Date updatedAt;             // 수정일자

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
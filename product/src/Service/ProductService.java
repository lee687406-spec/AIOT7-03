package Service;

import java.util.List;
import DTO.Product; 

public class ProductService {
    // 상품 목록
    List<Product> list();
    // 상품 조회
    Product select(int no);
    // 상품 등록
    int insert(Product product);
    // 상품 수정
    int update(Product product);
    // 상품 삭제
    int delete(int no);

}

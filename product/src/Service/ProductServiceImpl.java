package Service;

import java.util.List;

import DAO.ProductDAO;
import DTO.Product;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> list() {
        List<Product> productlist = productDAO.list();
        return productlist;
    }

    @Override
    public Product select(int no) {
        Product product = productDAO.select(no);
        return product;
    }

    @Override
    public int insert(Product product) {
        int result = productDAO.insert(product);
        if( result > 0 ) System.out.println("상품 등록 성공");
        else System.out.println("상품 등록 실패");
        return result;
    }

    @Override
    public int update(Product product) {
        int result = productDAO.update(product);
        if( result > 0 ) System.out.println("상품정보 수정 성공");
        else System.out.println("상품정보 수정 실패");
        return result;
    }

    @Override
    public int delete(int no) {
        int result = productDAO.delete(no);
        if( result > 0) System.out.println("상품 삭제 성공");
        else System.out.println("상품 삭제 실패");
        return result;
    }
}

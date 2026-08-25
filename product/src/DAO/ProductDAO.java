package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.Product;

public class ProductDAO extends JDBConnection {
public List<Product> list(){
    List<Product> productList= new ArrayList<>();                               //상품목록
    String sql= " SELECT * "
              + " FROM board ";

    try{
        stmt= con.createStatement();
        rs= stmt.executeQuery(sql);
        while (rs.next()) {
            Product product= new Product();
            product.setNo(rs.getInt("no"));                         //no 상품번호
            product.setTitle(rs.getString("title"));                //title?
            product.setWriter(rs.getString("writer"));              //writer?
            product.setContent(rs.getString("content"));            //content?
            product.setCreatedAt(rs.getTimestamp("created_at"));    //createdAt 생성날짜
            product.setUpdatedAt(rs.getTimestamp("updated_at"));    //updatedAt 수정날짜

            productList.add(product);
        }

    } catch(Exception e){
        System.err.println("상품 조회시, 예외 발생");
        e.printStackTrace();
    }
    return productList;
}

/**
 *                                                                              //조회
 * @param no
 * @return
 */
public Product select(int no){
    Product product= new Product();
    String sql= " SELECT * "
              + " FROM product "
              + " WHERE no = ? ";
    try{
        psmt= con.prepareStatement(sql);
        psmt.setInt(1, no);
        rs= psmt.executeQuery();

        if (rs.next()) {
            product.setNo(rs.getInt("no"));                         //no 상품번호
            product.setName(rs.getString("name"));                  //title-> name 상품명
            product.setPrice(rs.getString("price"));                //writer-> price 가격
            product.setDescription(rs.getString("description"));    //content-> description 설명
            product.setCreatedAt(rs.getTimestamp("created_at"));    //createdAt 등록일자
            product.setUpdatedAt(rs.getTimestamp("updated_at"));    //updatedAt 수정일자
        }
    } catch(Exception e){
        System.err.println("상품조회시, 예외 발생");
        e.printStackTrace();
    }
    return product;
}

/**
 *                                                                              //등록
 * @param product
 * @return
 */
public int insert(Product product){
    int result= 0;
    String sql= " INSERT INTO product ( no, title, writer, content ) "          //no, title, writer, content
              + " VALUES ( PRODUCT_SEQ.nextval, ?, ?, ? ) ";
    try{
        psmt= con.prepareStatement(sql);
        psmt.setString(1, product.getName());                  //getTitle
        psmt.setString(2, product.getPrice());                 //getWriter
        psmt.setString(3, product.getDescription());           //getContent
        result= psmt.executeUpdate();
    } catch(Exception e){
        System.err.println("상품등록시, 예외 발생");
        e.printStackTrace();
    }
    return result;
}


/**
 *                                                                              //수정
 * @param product
 * @return
 */
public int update(Product product){
    int result= 0;
    String sql= " UPDATE product "
              + " SET title = ? "                                               //title
              + " , writer = ? "                                                //writer
              + " , content = ? "                                               //content
              + " , updated_at = sysdate "
              + " WHERE no= ? ";
    try{
        psmt= con.prepareStatement(sql);
        psmt.setString(1, product.getTitle());                  //title
        psmt.setString(2, product.getWriter());                 //writer
        psmt.setString(1, product.getContent());                //content
        psmt.setInt(4, product.getNo());
        result= psmt.executeUpdate();
    } catch (Exception e){
        System.err.println("상품수정시, 예외 발생");
        e.printStackTrace();
    }
    return result;
}

/**
 *                                                                              //삭제
 * @param no
 * @return
 */
public int delete(int no){
    int result= 0;
    String sql= " DELETE FROM product "
              + " WHERE no = ? ";
    try{
        psmt= con.prepareStatement(sql);
        psmt.setInt(1, no);
        result= psmt.executeUpdate();
    } catch(Exception e){
        System.err.println("상품삭제시, 예외 발생");
        e.printStackTrace();
    }
    return result;
}


}
package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.ProductPromotion;
import org.ironhack.Food_Punck.models.ProductPromotionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, ProductPromotionId> {
	
//	Optional<ProductPromotion> findByProductId(@Param("id_Producto") int idProducto);
	
//	Optional<ProductPromotion> findByPromotionId(@Param("id_Promotion") int idPromo);
	
//    @Query("SELECT SUM(p.cantidad) FROM ProductoPromocionPedido p WHERE p.idPedido = :idPedido")
//    Integer calcularCantidadPedido(@Param("idPedido") int idPedido);

//	@Query("SELECT php.id_Product, p.product_name, pro.promotion_name FROM Products_has_Promotions php "
//			+ "INNER JOIN Products p ON php.id_Product = p.id_Product"
//			+ "INNER JOIN Promotions pro ON php.id_Promotion = pro.id_Promotion "
//			+ "WHERE php.id_Product = :id_Product AND php.id_Promotion = :id_Promotion")
//	List<ProductPromotionId> findByProductPromotionId(@Param("id_Product") int idProduct, @Param("id_Promotion") int idPromo);
	
	@Query(value = "SELECT * FROM product_promotion WHERE product_promotion_id = ?1 AND product_id = ?2", nativeQuery = true)
	List<ProductPromotion> findByProductPromotionId(int productPromotionId, int productId);   
	
}

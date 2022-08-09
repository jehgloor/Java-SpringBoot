package me.java.spring.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import me.java.spring.venda.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor,Long>{

	List<Vendedor> findByNome(String nome);
	
	// tentei essas duas Query, mas não consegui fazer funcionar
	@Query(value = "SELECT Vendedor.nome ,Vendedor.id,"
			+" COUNT(Venda.Vendedor_id) AS qtdVendas"
			+" FROM Vendedor"
			+" JOIN Venda"
			+" ON Venda.Vendedor_id = Vendedor.id"
			+" GROUP BY Venda.Vendedor_id", nativeQuery = true)
	List<Vendedor> countVendasPorVendedor();
	
	@Query(value = "SELECT VENDEDOR.NOME,VENDEDOR.ID,\r\n"
			+ "COUNT (VENDA.VENDEDOR_ID) AS QTD_VENDAS,\r\n"
			+ "AVG(VALOR_VENDA) AS MEDIA ,\r\n"
			+ "SUM(VALOR_VENDA) AS VALOR_TOTAL_VENDAS\r\n"
			+ "FROM VENDEDOR\r\n"
			+ "INNER JOIN VENDA\r\n"
			+ "ON VENDA.VENDEDOR_ID = VENDEDOR.ID\r\n"
			+ "WHERE DATA_VENDA > '2022-08-01' AND DATA_VENDA < '2022-08-15'\r\n"
			+ "GROUP BY VENDA.VENDEDOR_ID" , nativeQuery = true)
	List<Vendedor> retornoDosCampos();
	
}

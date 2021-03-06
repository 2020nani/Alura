package testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Categoria;
import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("negocios");
		
		Conta conta = new Conta();
		conta.setId(2L);
        //primeira movimentacao
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a sp");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.00));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		//segunda movimentacao
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem a rj");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.00));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao2.setConta(conta);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		
		em.close();
	}

}

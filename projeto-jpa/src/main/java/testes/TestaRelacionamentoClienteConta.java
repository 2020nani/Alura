package testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Categoria;
import modelo.Cliente;
import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Hernani A Almeida");
		cliente.setEndereco("Rua 3");
		cliente.setProfissao("vigia");
		cliente.setConta(conta);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		
		em.close();

	}

}

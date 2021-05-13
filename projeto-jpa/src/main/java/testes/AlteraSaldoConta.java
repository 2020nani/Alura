package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		Conta contaSemSaldo = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		contaSemSaldo.setSaldo(600.00);
		em.getTransaction().commit();

	}

}

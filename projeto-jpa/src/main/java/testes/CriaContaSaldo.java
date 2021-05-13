package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class CriaContaSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		Conta conta = new Conta();
		conta.setTitular("Davi");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.00);
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		conta.setSaldo(900.00);
		//estadodetached
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();

	}

}

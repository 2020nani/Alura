package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Marcos");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.00);
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
        
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}

}

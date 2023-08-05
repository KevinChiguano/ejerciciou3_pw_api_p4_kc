package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vehiculo> seleccionarTodo() {
		// TODO Auto-generated method stub
		
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo seleccionarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =:dataPlaca", Vehiculo.class);
		myQuery.setParameter("dataPlaca", placa);
		return myQuery.getSingleResult();
	}

}

package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.entity.Vehiculo;

public interface IVehiculoRepository {
	
	public List<Vehiculo> seleccionarTodo();
	
	public Vehiculo seleccionarPorPlaca(String placa);

}

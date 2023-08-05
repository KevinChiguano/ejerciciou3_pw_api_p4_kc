package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.entity.Vehiculo;
import com.example.demo.service.to.VehiculoTo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoTo> BuscarTodo() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista = this.vehiculoRepository.seleccionarTodo(); 
		List<VehiculoTo> listaTO = lista.stream().map(vehiculo -> this.convertir(vehiculo)).collect(Collectors.toList());
		return listaTO;
	}

	@Override
	public VehiculoTo BuscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.convertir(this.vehiculoRepository.seleccionarPorPlaca(placa));
	}
	
	private VehiculoTo convertir(Vehiculo vehiculo) {
		VehiculoTo vehi = new VehiculoTo();
		vehi.setId(vehiculo.getId());
		vehi.setGasolina(vehiculo.getGasolina());
		vehi.setNumeroPuerta(vehiculo.getNumeroPuerta());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setTipo(vehiculo.getTipo());
		return vehi;
	}

}

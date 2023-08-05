package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.VehiculoTo;

public interface IVehiculoService {

	public List<VehiculoTo> BuscarTodo();

	public VehiculoTo BuscarPorPlaca(String placa);

}

package com.politecnicomalaga.entidadbancaria;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cuenta {
	
	private String ccc; //Código de la cuenta
	private float saldo;
	private String fechaApertura;
	private List<Operacion> misOperaciones;
	Cliente micliente;


	public Cuenta(String ccc, float saldo, String fechaApertura) {
		super();
		this.ccc = ccc;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		misOperaciones = new ArrayList<>();

	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public float getSaldo() {
		return saldo;
	}


	public String getFechaApertura() {
		return fechaApertura;
	}


	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	public boolean isActiva() {
		return saldo>0;
	}

	public List<Operacion> getMisOperaciones() {
		return misOperaciones;
	}

	public void setMisOperaciones(List<Operacion> misOperaciones) {
		this.misOperaciones = misOperaciones;
	}

	public Cliente getMicliente() {
		return micliente;
	}

	public void setMicliente(Cliente micliente) {
		this.micliente = micliente;
	}

	public boolean retirarEfectivo(float cantidad, String fecha) {
		if (cantidad <= 0) return false;
		if (cantidad <= saldo) {
			saldo -= cantidad;

			long codigo;
			codigo = (long) (Math.random()*1000000);
			while (buscarOperacion(codigo)) {
				if (buscarOperacion(codigo)) {
					codigo = (long) (Math.random() * 1000000);
				}
			}
			misOperaciones.add(new Operacion(codigo,-cantidad,fecha));

			return true;
		}
		return false;


	}

	public boolean ingresarEfectivo(float cantidad, String fecha) {
		if (cantidad <= 0) return false;
		saldo += cantidad;

		long codigo;
		codigo = (long) (Math.random()*1000000);

		while (buscarOperacion(codigo)) {
			if (buscarOperacion(codigo)) {
				codigo = (long) (Math.random() * 1000000);
			}
		}
		misOperaciones.add(new Operacion(codigo,cantidad,fecha));

		return true;
	}

	public boolean buscarOperacion(long codigo){
		for(Operacion o:misOperaciones) {
			if (o.getCodigo()==codigo) {
				return true;
			}
		}
		return false;
	}



	public String verDatos() {

		String datos = " " +
				"Codigo de cuenta:" + ccc + " | Saldo de la cuenta:" + saldo + " | Apertura de la cuenta:'" + fechaApertura +
				"\n   Cliente:" + micliente.verDatos() +
				"\nOperaciones";

		for ( Operacion operacion : misOperaciones) {
			datos += operacion.verDatos();
		}
		datos += "\n---------------------------";

		return datos;
//		return " Codigo de cuenta:" + ccc + " | saldo:" + saldo + " | fechaApertura='" + fechaApertura +
//				"\nCliente:" + micliente.verDatos() +
//				"\nOperaciones" + misOperaciones.verDatos();
	}

	@Override
	public String toString() {
		return "Cuenta{" +
				"ccc='" + ccc + '\'' +
				", saldo=" + saldo +
				", fechaApertura='" + fechaApertura + '\'' +
				", misOperaciones=" + misOperaciones +
				", micliente=" + micliente +
				'}';
	}
}

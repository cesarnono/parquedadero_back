package com.ceiba.induccion.parqueadero.util;

import java.util.Calendar;

import com.ceiba.induccion.parqueadero.model.CobroCarro;
import com.ceiba.induccion.parqueadero.model.CobroMoto;
import com.ceiba.induccion.parqueadero.model.Servicio;

public class CobroBuilder {
	
	private Calendar fechaEntradaDefault = ParqueaderoUtil.getFechaCalendar("dd-M-yyyy HH:mm:ss",
			"18-03-2018 01:00:00");
	private Calendar fechaSalidaDefault = ParqueaderoUtil.getFechaCalendar("dd-M-yyyy HH:mm:ss",
			"18-03-2018 06:10:00");
	private static final String ESTADO_DEFAULT = "PENDIENTE";
	private static final String PLACA_DEFAULT = ParqueaderoUtil.PLACA_COMUN;

	private long id;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private String estado;
	protected long valorServicio;
	protected long tiempoServicioHoras;
	protected String descripcionTiempoServicio;
	private Servicio servicio;	
	private String placa;
	private int cilindraje;

	public CobroBuilder() {
		this.fechaEntrada = fechaEntradaDefault;
		this.fechaSalida = fechaSalidaDefault;
		this.estado = ESTADO_DEFAULT;
		this.placa = PLACA_DEFAULT;
		this.servicio = new ServicioBuilder().withDescripcion(ParqueaderoUtil.SERVICIO_PARQUEO_CARRO)
				.withCupoMaximo(20).withTarifaDia(ParqueaderoUtil.TARIFA_DIA_CARRO)
				.withTarifaHora(ParqueaderoUtil.TARIFA_HORA_CARRO).build();
	}

	public CobroBuilder withFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public CobroBuilder withFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public CobroBuilder whithEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public CobroBuilder withServicio(Servicio servicio) {
		this.servicio = servicio;
		return this;
	}

	public CobroBuilder withCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	
	public CobroBuilder withId(long id) {
		this.id = id;
		return this;
	}
	
	public CobroBuilder withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public CobroCarro buildCarro() {
		return new CobroCarro(this.id, this.placa, this.fechaEntrada, this.fechaSalida, this.estado, this.valorServicio,
				this.servicio);
	}

	public CobroMoto buildMoto() {
		return new CobroMoto(this.id, this.placa, this.cilindraje, this.fechaEntrada, this.fechaSalida, this.estado,
				 this.servicio);
	}

}

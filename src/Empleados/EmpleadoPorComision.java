package Empleados;

public class EmpleadoPorComision {
	private String primerNombre;
	private String apellidoPaterno;
	private String numeroSeguroSocial;
	private double ventasBrutas; // ventas totales por semana
	private double tarifaComision; // porcentaje de comisión

	//Constructor por defecto
	public EmpleadoPorComision() {
	}

	// constructor con cinco argumentos
	@SuppressWarnings("OverridableMethodCallInConstructor")
	public EmpleadoPorComision(String nombre, String apellido, String nss,
	                           double ventas, double tarifa) { // la llamada implícita al constructor de Object ocurre aquí
		this.primerNombre = nombre;
		this.apellidoPaterno = apellido;
		this.numeroSeguroSocial = nss;
		establecerVentasBrutas(ventas); // valida y almacena las ventas brutas
		establecerTarifaComision(tarifa); // valida y almacena la tarifa de comisión
	} // fin del constructor de EmpleadoPorComision3 con cinco argumentos

	// establece el primer nombre
	public void establecerPrimerNombre(String nombre) {
		primerNombre = nombre;
	} // fin del método establecerPrimerNombre

	// devuelve el primer nombre
	public String obtenerPrimerNombre() {
		return primerNombre;
	} // fin del método obtenerPrimerNombre

	// establece el apellido paterno
	public void establecerApellidoPaterno(String apellido) {
		apellidoPaterno = apellido;
	} // fin del método establecerApellidoPaterno

	// devuelve el apellido paterno
	public String obtenerApellidoPaterno() {
		return apellidoPaterno;
	} // fin del método obtenerApellidoPaterno

	// establece el número de seguro social
	public void establecerNumeroSeguroSocial(String nss) {
		numeroSeguroSocial = nss; // debe validar
	} // fin del método establecerNumeroSeguroSocial

	// devuelve el número de seguro social
	public String obtenerNumeroSeguroSocial() {
		return numeroSeguroSocial;
	} // fin del método obtenerNumeroSeguroSocial

	// establece el monto de ventas brutas
	public void establecerVentasBrutas(double ventas) {
		ventasBrutas = (ventas < 0.0) ? 0.0 : ventas;
	} // fin del método establecerVentasBrutas

	// devuelve el monto de ventas brutas
	public double obtenerVentasBrutas() {
		return ventasBrutas;
	} // fin del método obtenerVentasBrutas

	// establece la tarifa de comisión
	public void establecerTarifaComision(double tarifa) {
		tarifaComision = (tarifa > 0.0 && tarifa < 1.0) ? tarifa : 0.0;
	} // fin del método establecerTarifaComision

	// devuelve la tarifa de comisión
	public double obtenerTarifaComision() {
		return tarifaComision;
	} // fin del método obtenerTarifaComision

	public double obtenerKM() {
		return 0;
	}

	public double obtenerLitrosGasolina() {
		return 0;
	}

	public String obtenerTipoGasolina() {
		return "";
	}

	// calcula los ingresos
	//método polimófico
	public double ingresos() {
		return obtenerTarifaComision() * obtenerVentasBrutas();
	} // fin del método ingresos

	// devuelve representación String del objeto EmpleadoPorComision3
	public String toString() {
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
				"Empleado por comision", obtenerPrimerNombre(), obtenerApellidoPaterno(),
				"Numero de seguro social", obtenerNumeroSeguroSocial(),
				"Ventas brutas", obtenerVentasBrutas(),
				"Tarifa de comision", obtenerTarifaComision(),
				"Sueldo más comisión", ingresos());
	} // fin del método toString
} // fin de la clase EmpleadoPorComision3
package Empleados;

public class EmpleadoBaseChofer extends EmpleadoPorComision {
    private double salarioBase;
    private double nKM;
    private String tipoGasolina;
    private double litrosGasolinaKM;
    private double diasViaticos;

    public EmpleadoBaseChofer() {
    }

    public EmpleadoBaseChofer(String nombre, String apellido, String nss, double salario, String tipo, double km) {
        super (nombre, apellido, nss, 0, 0);
        establecerTipoGasolina (tipo);
        establecerSalarioBase (salario);
        establecerKM (km);
        establecerLitrosGasolina (km);
        establecerDiasViaticos (km);
    }

    public void establecerKM(double km) {
        nKM = km;
    }

    public double obtenerKM() {
        return nKM + super.obtenerKM ();
    }

    public void establecerTipoGasolina(String tipoG) {
        tipoGasolina = tipoG;
    }

    public String obtenerTipoGasolina() {
        return tipoGasolina + super.obtenerTipoGasolina ();
    }

    public void establecerLitrosGasolina(double km) {
        litrosGasolinaKM = km * 40 / 100;
    }

    public double obtenerLitrosGasolina() {
        return litrosGasolinaKM + super.obtenerLitrosGasolina ();
    }

    public void establecerDiasViaticos(double km) {
        if (km < 100) {
            diasViaticos = .5;
        } else {
            diasViaticos = (km / 100);
        }
    }

    public double obtenerDiasViaticos() {
        return diasViaticos;
    }

    public void establecerSalarioBase(double salario) {
        salarioBase = (salario < 0.0) ? 0.0 : salario;
    }

    public double obtenerSalarioBase() {
        return salarioBase;
    }

    public double costoViaticos() {
            return obtenerDiasViaticos () * 400;
    }

    public double costoGasolina() {
        if(tipoGasolina.equals ("Magna")) {
            return obtenerLitrosGasolina () * 20.86;
        }
        if(tipoGasolina.equals ("Premium")) {
            return obtenerLitrosGasolina () * 21.25;
        }
        if(tipoGasolina.equals ("Diésel")) {
            return obtenerLitrosGasolina () * 22.66;
        }
        return 0;
    }

    public double ingresos() {
        return obtenerSalarioBase () + ((costoGasolina () + costoViaticos ()) * 2) + super.ingresos ();
    }

    public String toString() {
        return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f\n%s: %.2f\n%s: %.2f\n%s: %.2f",
                "Empleado con Base (Chofer)", obtenerPrimerNombre(), obtenerApellidoPaterno(),
                "Numero de Seguro Social", obtenerNumeroSeguroSocial(),
                "Recorrido en KM", obtenerKM(),
                "Litros de Consumo", obtenerLitrosGasolina (),
                "Tipo de Gasolina", obtenerTipoGasolina (),
                "Costo Gasolina", costoGasolina (),
                "Días Viaticos", obtenerDiasViaticos (),
                "Costo Viaticos", costoViaticos (),
                "Total Ida y Regreso", ((costoGasolina () + costoViaticos ()) * 2),
                "Sueldo Base", obtenerSalarioBase (),
                "Sueldo Base + Viaticos", ingresos ());
    }
}
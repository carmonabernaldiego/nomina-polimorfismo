package Empleados;

public class EmpleadoBaseChofer extends EmpleadoPorComision {
    private double salarioBase; // salario base por semana// salario base por semana
    private String tipoGasolina;
    private double litrosGasolinaKM;
    private double diasViaticos;

    //constructor por defecto
    public EmpleadoBaseChofer() {
    }

    // constructor con seis argumentos
    public EmpleadoBaseChofer(String nombre, String apellido, String nss, double salario, String tipo, double km) {
        super (nombre, apellido, nss, 0, 0);
        this.tipoGasolina = tipo;
        establecerSalarioBase (salario); // valida y almacena el salario base
        establecerLitrosGasolina (km);
        establecerDiasViaticos (km);
    } // fin del constructor de EmpleadoBaseMasComision4 con seis argumentos// fin del constructor de EmpleadoBaseMasComision4 con seis argumentos

    public void establecerLitrosGasolina(double km) {
        litrosGasolinaKM = km * 40 / 100;
    }

    public double obtenerLitrosGasolina() {
        return litrosGasolinaKM + super.obtenerLitrosGasolina ();
    }

    public void establecerDiasViaticos(double km) {
        diasViaticos = (km / 100);
    }

    public double obtenerDiasViaticos() {
        return diasViaticos;
    }

    // establece el salario base
    public void establecerSalarioBase(double salario) {
        salarioBase = (salario < 0.0) ? 0.0 : salario;
    } // fin del método establecerSalarioBase// fin del método establecerSalarioBase

    // devuelve el salario base
    public double obtenerSalarioBase() {
        return salarioBase;
    } // fin del método obtenerSalarioBase// fin del método obtenerSalarioBase

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

    // calcula los ingresos
    public double ingresos() {
        return obtenerSalarioBase () + costoGasolina () + costoViaticos () + super.ingresos ();
    } // fin del método ingresos// fin del método ingresos

    // devuelve representación String de EmpleadoBaseMasComision4
    public String toString() {
        return String.format ("%s %s\n%s: %.2f\n%s: %.2f\n%s: %.2f", "Con Base (Chofer)",
                super.toString (), "Sueldo base", obtenerSalarioBase (), "Litros", obtenerLitrosGasolina (), "Diás Viaticos", obtenerDiasViaticos ());
    } // fin del método toString// fin del método toString
} // fin de la clase EmpleadoBaseMasComision4
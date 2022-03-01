package Empleados;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase; // salario base por semana// salario base por semana

    //constructor por defecto
    public EmpleadoBaseMasComision() {
    }

    // constructor con seis argumentos
    public EmpleadoBaseMasComision(String nombre, String apellido, String nss, double ventas,
                                   double tarifa, double salario) {
        super (nombre, apellido, nss, ventas, tarifa);
        establecerSalarioBase (salario); // valida y almacena el salario base
    } // fin del constructor de EmpleadoBaseMasComision4 con seis argumentos// fin del constructor de EmpleadoBaseMasComision4 con seis argumentos

    // establece el salario base
    public void establecerSalarioBase(double salario) {
        salarioBase = (salario < 0.0) ? 0.0 : salario;
    } // fin del método establecerSalarioBase// fin del método establecerSalarioBase

    // devuelve el salario base
    public double obtenerSalarioBase() {
        return salarioBase;
    } // fin del método obtenerSalarioBase// fin del método obtenerSalarioBase

    // calcula los ingresos
    public double ingresos() {
        return obtenerSalarioBase () + super.ingresos ();
    } // fin del método ingresos// fin del método ingresos

    // devuelve representación String de EmpleadoBaseMasComision4
    public String toString() {
        return String.format ("%s %s\n%s: %.2f", "Con sueldo base",
                super.toString (), "Sueldo base", obtenerSalarioBase ());
    } // fin del método toString// fin del método toString
} // fin de la clase EmpleadoBaseMasComision4
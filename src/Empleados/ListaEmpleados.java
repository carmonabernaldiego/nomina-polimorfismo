package Empleados;

public class ListaEmpleados {
	private EmpleadoPorComision[] lista;
	private int contador;

	public ListaEmpleados(int tamañoMaximo) {
		lista = new EmpleadoPorComision[tamañoMaximo];
		contador = 0;
	}

	public int size() {
		return contador;
	}

	private boolean llena() {
		return contador == lista.length;
	}

	public boolean add(EmpleadoPorComision m) {
		if (llena()) {
			return false;
		} else {
			lista[contador] = m;
			contador++;
			return true;
		}
	}

	public void remove() {
		contador--;
	}

	public void clear() {
		contador = 0;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < contador; i++) {
			s += lista[i].toString() + "\n\n";
		}
		return s;
	}
}
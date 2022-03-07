package Empleados;

import javax.swing.*;

public class NominaPolimorfismo {
	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		EmpleadoForm formEmpleado = new EmpleadoForm();
		formEmpleado.setVisible(true);
	}
}
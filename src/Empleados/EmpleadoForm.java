package Empleados;

import javax.swing.*;
import java.awt.event.*;

public class EmpleadoForm extends JFrame {
    ListaEmpleados listaEmpleados = new ListaEmpleados (10);

    private JPanel mainPanel;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtNSS;
    private JTextField txtVentas;
    private JTextField txtTarifa;
    private JTextField txtSalario;
    private JButton btnAgregar;
    private JButton btnVisualizar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JComboBox cbbxContrato;
    private JTextArea txtResultados;
    private JTextField txtKM;
    private JComboBox cbbxGasolina;

    public void habilitar() {
        txtNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtNSS.setEnabled(true);
        txtSalario.setEnabled(true);
        txtTarifa.setEnabled(true);
        txtVentas.setEnabled(true);
        txtKM.setEnabled (true);
        cbbxGasolina.setEnabled (true);
    }

    public void desabilitar() {
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtNSS.setEnabled(false);
        txtSalario.setEnabled(false);
        txtTarifa.setEnabled(false);
        txtVentas.setEnabled(false);
        txtKM.setEnabled (false);
        cbbxGasolina.setEnabled (false);
    }

    public void limpiarInputs() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtNSS.setText("");
        txtSalario.setText("");
        txtTarifa.setText("");
        txtVentas.setText("");
        txtKM.setText ("");
        cbbxContrato.setSelectedItem("Seleccioné");
        cbbxGasolina.setSelectedItem ("Seleccioné");
    }

    public boolean validarInputs() {
        if (txtNombre.getText().isEmpty() && txtNombre.isEnabled ()) {
            txtNombre.requestFocus();
            return false;
        }
        if (txtApellidos.getText().isEmpty() && txtApellidos.isEnabled ()) {
            txtApellidos.requestFocus();
            return false;
        }
        if (txtNSS.getText().isEmpty() && txtNSS.isEnabled ()) {
            txtNSS.requestFocus();
            return false;
        }
        if (txtVentas.getText().isEmpty() && txtVentas.isEnabled ()) {
            txtVentas.requestFocus();
            return false;
        }
        if (txtTarifa.getText().isEmpty() && txtTarifa.isEnabled ()) {
            txtTarifa.requestFocus ();
            return false;
        }
        if (txtSalario.getText().isEmpty() && txtSalario.isEnabled ()) {
            txtSalario.requestFocus();
            return false;
        }
        if (txtKM.getText().isEmpty() && txtKM.isEnabled ()) {
            txtKM.requestFocus ();
            return false;
        }
        if (cbbxGasolina.getSelectedItem().equals ("Seleccioné") && cbbxGasolina.isEnabled ()) {
            cbbxGasolina.requestFocus ();
            return false;
        }
        return true;
    }

    public boolean validarInputN(int caracter) {
        boolean numeros = caracter >= 48 && caracter <= 57;
        if (!numeros) {
            return true;
        }
        return false;
    }

    public boolean validarInputNPoint(int caracter, JTextField textField) {
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.' || textField.getText().contains("."))) {
            return true;
        }
        return false;
    }

    public EmpleadoForm() {
        setTitle("Empleados");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(false);

        if (cbbxContrato.getSelectedItem().equals("Seleccioné")) {
            desabilitar();
            txtResultados.setEnabled (false);
        }
        cbbxContrato.requestFocus();

        cbbxContrato.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbbxContrato.getSelectedItem().equals("Seleccioné")) {
                    desabilitar();
                }
                if (cbbxContrato.getSelectedItem().equals("Base")) {
                    habilitar();
                    txtKM.setEnabled (false);
                    txtKM.setText ("");
                    cbbxGasolina.setEnabled (false);
                    cbbxGasolina.setSelectedItem ("Seleccioné");
                    txtNombre.requestFocus();
                }
                if (cbbxContrato.getSelectedItem().equals("Base (Chofer)")) {
                    habilitar();
                    txtVentas.setEnabled (false);
                    txtVentas.setText ("");
                    txtTarifa.setEnabled (false);
                    txtTarifa.setText ("");
                    txtNombre.requestFocus();
                }
                if (cbbxContrato.getSelectedItem().equals("Comisión")) {
                    habilitar();
                    txtSalario.setEnabled(false);
                    txtSalario.setText("");
                    txtKM.setEnabled (false);
                    txtKM.setText ("");
                    cbbxGasolina.setEnabled (false);
                    cbbxGasolina.setSelectedItem ("Seleccioné");
                    txtNombre.requestFocus();
                }
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbbxContrato.getSelectedItem().equals("Seleccioné")) {
                    JOptionPane.showMessageDialog(null, "Seleccioné un elemento de la lista.", "Empleados", JOptionPane.INFORMATION_MESSAGE);
                    cbbxContrato.requestFocus();
                }
                if (cbbxContrato.getSelectedItem ().equals ("Base")) {
                    if(validarInputs()) {
                        String nombre = txtNombre.getText();
                        String apellidos = txtApellidos.getText();
                        String nss = txtNSS.getText();
                        String ventas =  txtVentas.getText();
                        String tarifa =  txtTarifa.getText();
                        String salario =  txtSalario.getText();
                        Double dVentas = Double.valueOf (ventas);
                        Double dTarifa = Double.valueOf (tarifa);
                        Double dSalario = Double.valueOf (salario);

                        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(nombre,apellidos, nss, dVentas, dTarifa, dSalario);
                        EmpleadoPorComision empleadoPorComisionPolimorfismo = empleadoBaseMasComision;

                        listaEmpleados.add(empleadoPorComisionPolimorfismo);

                        JOptionPane.showMessageDialog(null, "Empleado agregado.", "Empleados", JOptionPane.INFORMATION_MESSAGE);

                        limpiarInputs();
                    }
                }
                if (cbbxContrato.getSelectedItem ().equals ("Base (Chofer)")) {
                    if(validarInputs()) {
                        String nombre = txtNombre.getText();
                        String apellidos = txtApellidos.getText();
                        String nss = txtNSS.getText();
                        String tipoGasolina =  (String) cbbxGasolina.getSelectedItem();
                        String salario =  txtSalario.getText();
                        String km =  txtKM.getText();
                        Double dSalario = Double.valueOf (salario);
                        Double dKM = Double.valueOf (km);

                        EmpleadoBaseChofer empleadoBaseChofer = new EmpleadoBaseChofer (nombre, apellidos, nss, dSalario, tipoGasolina, dKM);
                        EmpleadoPorComision empleadoPorComisionPolimorfismo = empleadoBaseChofer;

                        listaEmpleados.add(empleadoPorComisionPolimorfismo);

                        JOptionPane.showMessageDialog(null, "Empleado agregado.", "Empleados", JOptionPane.INFORMATION_MESSAGE);

                        limpiarInputs();
                    }
                }
                if (cbbxContrato.getSelectedItem().equals("Comisión")) {
                    if(validarInputs()){
                        String nombre = txtNombre.getText();
                        String apellidos = txtApellidos.getText();
                        String nss = txtNSS.getText();
                        String ventas =  txtVentas.getText();
                        String tarifa =  txtTarifa.getText();
                        Double dVentas = Double.valueOf (ventas);
                        Double dTarifa = Double.valueOf (tarifa);

                        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision (nombre, apellidos, nss, dVentas, dTarifa);

                        listaEmpleados.add(empleadoPorComision);

                        JOptionPane.showMessageDialog(null, "Empleado agregado.", "Empleados", JOptionPane.INFORMATION_MESSAGE);

                        limpiarInputs();
                    }
                }
            }
        });

        btnVisualizar.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultados.setText ("");
                txtResultados.append(listaEmpleados.toString());
                txtResultados.setEnabled (true);
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarInputs();
                txtResultados.setText ("");
                txtResultados.setEnabled (false);

                listaEmpleados.clear ();

                cbbxContrato.requestFocus();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        txtApellidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        txtNSS.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarInputN(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        txtVentas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarInputNPoint(e.getKeyChar(), txtVentas)) {
                    e.consume();
                }
            }
        });

        txtTarifa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarInputNPoint(e.getKeyChar(), txtTarifa)) {
                    e.consume();
                }
            }
        });

        txtSalario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarInputNPoint(e.getKeyChar(), txtSalario)) {
                    e.consume();
                }
            }
        });

        txtKM.addKeyListener (new KeyAdapter () {
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarInputNPoint(e.getKeyChar(), txtKM)) {
                    e.consume();
                }
            }
        });
    }
}
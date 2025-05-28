import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class HospitalManagementSystemGUI extends JFrame {
    private ArrayList<HospitalPatient> patients = new ArrayList<>();

    public HospitalManagementSystemGUI() {
        setTitle("Hospital Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showLoginScreen();
        setLocationRelativeTo(null);
    }

    private void showLoginScreen() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("Enter Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(label);
        panel.add(passwordField);
        panel.add(loginButton);

        setContentPane(panel);
        revalidate();

        loginButton.addActionListener(e -> {
            String password = new String(passwordField.getPassword());
            if (password.equals("24070103")) {
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void showMainMenu() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JButton patientBtn = new JButton("Patient Management");
        JButton paymentBtn = new JButton("Payment System");
        JButton appointmentBtn = new JButton("Doctor Appointment");
        JButton exitBtn = new JButton("Exit");

        panel.add(patientBtn);
        panel.add(paymentBtn);
        panel.add(appointmentBtn);
        panel.add(exitBtn);

        setContentPane(panel);
        revalidate();

        patientBtn.addActionListener(e -> showPatientMenu());
        paymentBtn.addActionListener(e -> paymentSystem());
        appointmentBtn.addActionListener(e -> doctorAppointment());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void showPatientMenu() {
        String[] options = {"Add Patient", "View Patients", "Search Patient", "Delete Patient"};
        int choice = JOptionPane.showOptionDialog(this, "Select an option", "Patient Management",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> addPatient();
            case 1 -> viewPatients();
            case 2 -> searchPatient();
            case 3 -> deletePatient();
        }
    }

    private void addPatient() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            String name = JOptionPane.showInputDialog("Enter Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
            String disease = JOptionPane.showInputDialog("Enter Disease:");

            patients.add(new HospitalPatient(id, name, age, disease));
            JOptionPane.showMessageDialog(this, "Patient added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No patients found.");
            return;
        }

        StringBuilder list = new StringBuilder();
        for (HospitalPatient p : patients) {
            list.append(p).append("\n");
        }

        JTextArea textArea = new JTextArea(list.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Patient List", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchPatient() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID to search:"));
            for (HospitalPatient p : patients) {
                if (p.getId() == id) {
                    JOptionPane.showMessageDialog(this, p.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Patient not found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    private void deletePatient() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID to delete:"));
            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getId() == id) {
                    patients.remove(i);
                    JOptionPane.showMessageDialog(this, "Patient record deleted.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Patient not found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    private void paymentSystem() {
        String[] methods = {"bKash", "Nagad"};
        int method = JOptionPane.showOptionDialog(this, "Choose Payment Method", "Payment",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, methods, methods[0]);

        if (method == -1) return;

        try {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
            JOptionPane.showMessageDialog(this, "Payment of " + amount + " via " + methods[method] + " successful.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
        }
    }

    private void doctorAppointment() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        String doctor = JOptionPane.showInputDialog("Enter preferred doctor:");
        String date = JOptionPane.showInputDialog("Enter date (dd-mm-yyyy):");

        try (FileWriter fw = new FileWriter("appointments.txt", true)) {
            fw.write("Appointment: " + name + " with Dr. " + doctor + " on " + date + "\n");
            JOptionPane.showMessageDialog(this, "Appointment booked successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving appointment.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementSystemGUI().setVisible(true));
    }
}

package chp1_swing_ui;

import javax.swing.*;
import java.awt.event.*;

public class MasterPage extends JFrame {

    public MasterPage() {
        setTitle("Master Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        // Home Menu
        JMenu homeMenu = new JMenu("Home");
        JMenuItem aboutUsItem = new JMenuItem("About Us");
        JMenuItem serviceItem = new JMenuItem("Service");
        JMenuItem locationItem = new JMenuItem("Location");
        JMenuItem exitItem = new JMenuItem("Exit");

        homeMenu.add(aboutUsItem);
        homeMenu.add(serviceItem);
        homeMenu.add(locationItem);
        homeMenu.addSeparator();
        homeMenu.add(exitItem);

        // Doctor Menu
        JMenu doctorMenu = new JMenu("Doctor");
        JMenuItem docInfoItem = new JMenuItem("Info");
        JMenuItem docRegItem = new JMenuItem("Registration");
        JMenuItem docPaymentItem = new JMenuItem("Payment");

        doctorMenu.add(docInfoItem);
        doctorMenu.add(docRegItem);
        doctorMenu.add(docPaymentItem);

        // Patient Menu
        JMenu patientMenu = new JMenu("Patient");
        JMenuItem patDetailsItem = new JMenuItem("Patient Details");
        JMenuItem patBillingItem = new JMenuItem("Billing");
        JMenuItem patRegItem = new JMenuItem("Registration");

        patientMenu.add(patDetailsItem);
        patientMenu.add(patBillingItem);
        patientMenu.add(patRegItem);

        // Accounts Menu
        JMenu accountMenu = new JMenu("Accounts");
        JMenuItem gstItem = new JMenuItem("GST");
        JMenuItem ngoItem = new JMenuItem("NGO Account");
        JMenuItem payDetailsItem = new JMenuItem("Payment Details");

        accountMenu.add(gstItem);
        accountMenu.add(ngoItem);
        accountMenu.add(payDetailsItem);

        // Adding menus to the menubar
        menuBar.add(homeMenu);
        menuBar.add(doctorMenu);
        menuBar.add(patientMenu);
        menuBar.add(accountMenu);

        setJMenuBar(menuBar);

        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MasterPage());
    }
}


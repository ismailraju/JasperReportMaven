/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReport {

    DefaultTableModel tableModel;

    private static String jrxmlFileName = "/home/ismailu/NetBeansProjects/JasperReportMaven/src/main/java/com/mycompany/mavenproject2/newReport.jrxml";
    private static String jasperFileName = "/home/ismailu/NetBeansProjects/JasperReportMaven/src/main/java/com/mycompany/mavenproject2/newReport.jasper";
    private static String pdfFileName = "/home/ismailu/NetBeansProjects/JasperReportMaven/src/main/java/com/mycompany/mavenproject2/newReport.pdf";

    public SimpleReport() {
        JasperPrint jasperPrint = null;
//        TableModelData();
        String[] columnNames = {"Id", "Name", "Department", "Email"};
        String[][] data = {
            {"111", "G Conger", " Orthopaedic", "jim@wheremail.com"},
            {"222", "A Date", "ENT", "adate@somemail.com"},
            {"333", "R Linz", "Paedriatics", "rlinz@heremail.com"},
            {"444", "V Sethi", "Nephrology", "vsethi@whomail.com"},
            {"555", "K Rao", "Orthopaedics", "krao@whatmail.com"},
            {"666", "V Santana", "Nephrology", "vsan@whenmail.com"},
            {"777", "J Pollock", "Nephrology", "jpol@domail.com"},
            {"888", "H David", "Nephrology", "hdavid@donemail.com"},
            {"999", "P Patel", "Nephrology", "ppatel@gomail.com"},
            {"101", "C Comer", "Nephrology", "ccomer@whymail.com"}

        };

        try {
            JasperCompileManager.compileReportToFile(jrxmlFileName);
            jasperPrint = JasperFillManager.fillReport(jasperFileName, new HashMap<>(),
                    new JRTableModelDataSource(new DefaultTableModel(data, columnNames)));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFileName);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SimpleReport();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.jasper;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ismail
 */
public class SespReport {

    private static String jrxmlFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.jrxml";
    private static String jasperFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.jasper";
    private static String pdfFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.pdf";

    public static void main(String[] args) throws JRException {
        HashMap hm = null;
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFileName);

        JRDataSource jRDataSource = new JREmptyDataSource();

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("headerText1", "raju");
        parameter.put("headerText2", "raju");
        parameter.put("headerText3", "List Of Beneficiary");
        parameter.put("headerText4", "raju");
        parameter.put("reportDate", "raju");
        parameter.put("header1", "Student Name");
        parameter.put("header2", "Class");
        parameter.put("header3", "Gender");
        parameter.put("header4", "Guardian Name");
        parameter.put("header5", "Guardian NID");
        parameter.put("header6", "Mobile");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, jRDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFileName);
    }

}

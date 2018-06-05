/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.jasper;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author ismail
 */
public class genarateSimplePdf {

    private static String jrxmlFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/SimpleReport.jrxml";
    private static String jasperFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/SimpleReport.jasper";
    private static String pdfFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/SimpleReport.pdf";

    public static void main(String[] args) throws JRException {
        HashMap hm = null;
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFileName);

        JRDataSource jRDataSource = new JREmptyDataSource();

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("COLUMN_0", "raju");
        parameter.put("COLUMN_1", "raju");
        parameter.put("COLUMN_2", "raju");
        parameter.put("COLUMN_3", "raju");
        parameter.put("COLUMN_0", "raju");
        parameter.put("address", "rdfhgdsfghdfhaju");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, jRDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFileName);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.jasper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRImageRenderer;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRRenderable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ismail
 */
public class SespReport {

    private static String reportPath = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/";
    private static String jrxmlFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.jrxml";
    private static String jasperFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.jasper";
    private static String pdfFileName = "/home/ismail/NetBeansProjects/jasper/jasperDemoMaven/src/main/java/com/raju/jasper/Landscape6.pdf";

    public static void main(String[] args) throws JRException {
//        HashMap hm = null;
//        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFileName);
//
//        JRDataSource jRDataSource = new JREmptyDataSource();
//
//        Map<String, Object> parameter = new HashMap<String, Object>();
//        parameter.put("headerImgLeft", "raju");
//        parameter.put("headerText1", "raju");
//        parameter.put("headerText2", "raju");
//        parameter.put("headerText3", "List Of Beneficiary");
//        parameter.put("headerText4", "raju");
//        parameter.put("reportDate", "raju");
//        parameter.put("header1", "Student Name");
//        parameter.put("header2", "Class");
//        parameter.put("header3", "Gender");
//        parameter.put("header4", "Guardian Name");
//        parameter.put("header5", "Guardian NID");
//        parameter.put("header6", "Mobile");
//        parameter.put("categoryName", "categoryName");
//
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, jRDataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFileName);
///////////////////////////////////
        ReportContentType rct = new ReportContentType();
        String fileName = "beneficiarylist";
        String templateFileName = "Landscape6.jasper";
        String REPORT_TEMP_FILE_PATH_LINUX = "/home/ismail/";
        String REPORT_FONT_PATH = "/Bangla_arial.ttf";
        String REPORT_TEMPLATE_PATH = "";
        String REPORT_TYPE_PDF = "PDF";
        String REPORT_TYPE_XLS = "XLS";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Integer REPORT_CHUNK_SIZE = 1;

//        if (req.getParameter("reportName") != null && !req.getParameter("reportName").isEmpty()) {
//            fileName = StringEscapeUtils.escapeHtml4(req.getParameter("reportName"));
//        }
        rct.fileName = fileName + ".xls";
        rct.contentType = "xls";
        rct.reportType = String.valueOf("pdf");
        System.out.println("REPORT TYPE: " + rct.reportType);
//        rct.reportType = req.getParameter("rtype");
        rct.reportPath = reportPath;
        rct.reportPath = rct.reportPath.replace("//", "/");
        String reportPathTemp = rct.reportPath;

        System.out.println("REPORT PATH IN HERE: " + rct.reportPath);
        rct.fontPath = rct.reportPath + REPORT_FONT_PATH;
        rct.fontPath = rct.fontPath.replace("//", "/");
        rct.govtLogo = rct.reportPath + "/govt.jpg";
        rct.spLogo = rct.reportPath + "/spfmsp.jpg";
        rct.signatureLogo = rct.reportPath + "/sig.jpg";

        rct.tempReportPath = REPORT_TEMP_FILE_PATH_LINUX;
//        if (SystemUtils.IS_OS_LINUX) {
//            rct.tempReportPath = REPORT_TEMP_FILE_PATH_LINUX;
//        }

        File tempReportDir = new File(rct.tempReportPath);
        try {
            if (!tempReportDir.exists()) {
                tempReportDir.mkdirs();
            }
        } catch (Exception ex) {
            // UsefulMethods.debugPrint(ex);
        }
        rct.reportLocation = rct.reportPath + REPORT_TEMPLATE_PATH;

        if (rct.reportType != null && rct.reportType.contains("pdf")) {
            System.out.println("REPORT TYPE: PDF FOUND");
            rct.reportType = REPORT_TYPE_PDF;
            rct.fileName = fileName + ".pdf";
            rct.contentType = "pdf";
        } else {
            rct.reportType = REPORT_TYPE_XLS;
        }

        System.out.println("CONTENT TYPE IN HERE: " + rct.reportType);

        //BufferedImage titleImg = UsefulMethods.getBufferedImage(rct.govtLogo);
        rct.parameters = new HashMap<String, Object>();
        JRRenderable titleImgLeft = null;
//        JRRenderable titleImgRight = null;
        JRRenderable signatureImg = null;
        try {
            titleImgLeft = JRImageRenderer.getInstance(rct.govtLogo);
//            titleImgRight = JRImageRenderer.getInstance(rct.spLogo);
            signatureImg = JRImageRenderer.getInstance(rct.signatureLogo);
        } catch (Exception ex) {
        }
        rct.parameters.put("headerImgLeft", titleImgLeft);
//        titleImg = UsefulMethods.getBufferedImage(rct.spLogo);
//        rct.parameters.put("headerImgRight", titleImgRight);

//        if (UsefulMethods.isBengaliReportLang(req)) {
//            rct.parameters.put("headerText1", "শিক্ষা মন্ত্রণালয়, গণপ্রজাতন্ত্রী বাংলাদেশ সরকার");
//            String x = "মাধ্যমিক শিক্ষা উপবৃত্তি প্রকল্প";
//            rct.parameters.put("headerText2", x);
//            rct.parameters.put("headerText6", "রিপোর্টের বিস্তারিত");
//        } else {
        rct.parameters.put("headerText1", "Ministry of Education, Government of the Peoples Republic of Bangladesh");
        rct.parameters.put("headerText2", "Secondary Education Stipend Project");
        rct.parameters.put("headerText6", "Report Details");
//        }

//        titleImg = UsefulMethods.getBufferedImage(rct.signatureLogo);
//        rct.parameters.put("authorizedSignature",signatureImg);
        rct.parameters.put("authorizedSignature", null);
        Date date = new Date();
        rct.parameters.put("reportDate", dateFormat.format(date));
        rct.mainReportPath = rct.reportLocation + templateFileName;

        rct.tempReportPath = rct.tempReportPath.replace("//", "/");
        JRFileVirtualizer virtualizer = new JRFileVirtualizer(REPORT_CHUNK_SIZE, rct.tempReportPath);
        try {
            JRBeanCollectionDataSource beanColDataSource;
            beanColDataSource = new JRBeanCollectionDataSource(tblDataList, false);
            rct.mainReportPath = rct.mainReportPath.replace("//", "/");
            System.out.println("MAIN PATH: " + rct.mainReportPath);
            JasperReport jasperMasterReport = (JasperReport) JRLoader.loadObjectFromFile(rct.mainReportPath);
            rct.parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, rct.parameters, beanColDataSource);

            // byte[] bArr = processReport(rct, jasperPrint);
            ByteArrayOutputStream baos = null;
            try {
                JRPdfExporter pdfexporter;
                JRXlsExporter xlsexporter;
                baos = new ByteArrayOutputStream();

                if (rct.reportType.equalsIgnoreCase(REPORT_TYPE_PDF)) {
                    System.out.println("EXPORT PDF DHUKSE");

                    //*********CODE FROM SPBMU******************
                    pdfexporter = new JRPdfExporter();
                    pdfexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    pdfexporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

//                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//                configuration.setCompressed(true);                
                    pdfexporter.setParameter(JRPdfExporterParameter.IS_COMPRESSED, true);
//                pdfexporter.setConfiguration(configuration);
                    pdfexporter.exportReport();
                    //*********CODE FROM SPBMU******************
                } else {
                    System.out.println("EXPORT XLS DHUKSE");

                    //*********CODE FROM SPBMU******************
                    xlsexporter = new JRXlsExporter();
                    xlsexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    xlsexporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                    xlsexporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 24989);

                    //xlsexporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                    xlsexporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);

//                xlsexporter.set
//                xlsexporter.setParameter(JRXlsExporterParameter.IS_, true);
                    //SimpleXlsExporterConfiguration config=new SimpleXlsExporterConfiguration();
                    xlsexporter.exportReport();
                    //*********CODE FROM SPBMU******************

                }
            } catch (Exception ex) {
                ex.printStackTrace();
                // UsefulMethods.debugPrint(ex);
                // return null;
            }

            if (baos != null) {
                return baos.toByteArray();
            }

            return bArr;
        } catch (Exception ex) {
            //UsefulMethods.debugPrint(ex);
            return null;
        } finally {
            virtualizer.cleanup();
        }

    }

}

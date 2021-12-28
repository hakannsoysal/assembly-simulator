
package com.mycompany._grup_7;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Grup_7_AnaEkran extends javax.swing.JFrame {
    public int selectedValueIndex=0;
    public int selectedValueIndexBackup=0;
    public int c=0;
    public int y=0;
    public int t=0;
    public String microOperation;
    public int memory, programCounter, inputRegister, addressRegister, outputRegister, acumulator, instructionRegister, dataRegister, stackPointer, SC;
    public String[] variables = new String[5];
    public String[] variableName = new String[5];
    public int opcode;
    public String selectedValue;
    public String[] splittedSelectedValue;
    public String[] notSplittedSelectedValue = new String[10];
    public String[] binaryNotSplittedSelectedValue = new String[10];
    public String[] hexNotSplittedSelectedValue = new String[10];
    public String[] octalNotSplittedSelectedValue = new String[10];
    
    static String strToBinary(String s)
    {   String bin = "";
        int n = s.length();
 
        for (int i = 0; i < n; i++)
        {
            
            int val = Integer.valueOf(s.charAt(i));
 
            
            
            while (val > 0)
            {
                if (val % 2 == 1)
                {
                    bin += '1';
                }
                else
                    bin += '0';
                val /= 2;
            }
            bin = reverse(bin);
 
            
        }
        return bin;
    }
    
    static String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;
 
        for (l = 0; l < r; l++, r--)
        {
            
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }
    
    
    public static String ASCIItoHEX(String ascii)
    {
       
        
        String hex = "";
 
        
        for (int i = 0; i < ascii.length(); i++) {
 
            
            char ch = ascii.charAt(i);
 
            
            int in = (int)ch;
 
           
            String part = Integer.toHexString(in);
 
            
            hex += part;
        }
       
        
        return hex;
    }
     
    
    public void detectAsmCodes(String asmCode){
        switch(asmCode){
            case "ORG":
                programCounter = 0000;
                jList5.setSelectedIndex(4);
                selectedValueIndex++;
                
                if(jComboBox1.getSelectedItem().equals("Binary")){
                    jList3.setListData(binaryNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Hex")){
                    jList3.setListData(hexNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Octal")){
                    jList3.setListData(octalNotSplittedSelectedValue);
                }
                else{
                    jList3.setListData(notSplittedSelectedValue);
                }  
                break;
                
            case "LDA":
                instructionRegister = 766865;
                dataRegister = Integer.parseInt(variables[0]);
                acumulator = Integer.parseInt(variables[0]);
                opcode = 2000;
                selectedValueIndex = 5;
                
                if(jComboBox1.getSelectedItem().equals("Binary")){
                    jTextField5.setText(String.valueOf(Integer.toBinaryString(instructionRegister)));
                    jTextField7.setText(String.valueOf(Integer.toBinaryString(dataRegister)));
                    jTextField11.setText(String.valueOf(Integer.toBinaryString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toBinaryString(Integer.parseInt(variables[0]))));
                    jList3.setListData(binaryNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Hex")){
                    jTextField5.setText(String.valueOf(Integer.toHexString(instructionRegister)));
                    jTextField7.setText(String.valueOf(Integer.toHexString(dataRegister)));
                    jTextField11.setText(String.valueOf(Integer.toHexString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toHexString(Integer.parseInt(variables[0]))));
                    jList3.setListData(hexNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Octal")){
                    jTextField5.setText(String.valueOf(Integer.toOctalString(instructionRegister)));
                    jTextField7.setText(String.valueOf(Integer.toOctalString(dataRegister)));
                    jTextField11.setText(String.valueOf(Integer.toOctalString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toOctalString(Integer.parseInt(variables[0]))));
                    jList3.setListData(octalNotSplittedSelectedValue);
                }
                else{
                    jTextField5.setText(String.valueOf(instructionRegister));
                    jList3.setListData(notSplittedSelectedValue);
                    jTextField7.setText(String.valueOf(dataRegister));
                    jTextField11.setText(String.valueOf(opcode));     
                }
                
                acumulator = dataRegister;
                    SC = 0;
                jList5.setSelectedIndex(5);
                jList1.setSelectedIndex(selectedValueIndex);
                microOperation = "DR <-  M[AR]\nAC <- DR, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "ADD":
                selectedValueIndex = 6;
                instructionRegister = 656868;
                dataRegister = Integer.parseInt(variables[1]);
                opcode = 1000;
                
                if(jComboBox1.getSelectedItem().equals("Binary")){
                    jTextField7.setText(String.valueOf(Integer.toBinaryString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toBinaryString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toBinaryString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toBinaryString(Integer.parseInt(variables[1]))));
                    jList3.setListData(binaryNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Hex")){
                    jTextField7.setText(String.valueOf(Integer.toHexString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toHexString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toHexString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toHexString(Integer.parseInt(variables[1]))));
                    jList3.setListData(hexNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Octal")){
                    jTextField7.setText(String.valueOf(Integer.toOctalString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toOctalString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toOctalString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toOctalString(Integer.parseInt(variables[1]))));
                    jList3.setListData(octalNotSplittedSelectedValue);
                }
                else{
                    jTextField7.setText(String.valueOf(dataRegister));
                    jList3.setListData(notSplittedSelectedValue);
                    jList5.setSelectedIndex(6);
                    jList1.setSelectedIndex(selectedValueIndex);
                    jTextField5.setText(String.valueOf(instructionRegister));
                    jTextField11.setText(String.valueOf(opcode));
                    jTextField12.setText(variables[1]);
                }
                
                
                
                acumulator += Integer.parseInt(variables[1]);
                microOperation = "DR <- M[AR] \n AC <- AC + DR, E <- Cout, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "STA":
                jList3.setListData(notSplittedSelectedValue);
                selectedValueIndex = 7;
                instructionRegister = 838465;
                dataRegister = Integer.parseInt(variables[2]);
                opcode = 3000;
                jList5.setSelectedIndex(7);
                jList1.setSelectedIndex(selectedValueIndex);
                
                if(jComboBox1.getSelectedItem().equals("Binary")){
                    jTextField7.setText(String.valueOf(Integer.toBinaryString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toBinaryString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toBinaryString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toBinaryString(acumulator)));
                    
                }
                else if(jComboBox1.getSelectedItem().equals("Hex")){
                    jTextField7.setText(String.valueOf(Integer.toHexString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toHexString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toHexString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toHexString(acumulator)));
                }
                else if(jComboBox1.getSelectedItem().equals("Octal")){
                    jTextField7.setText(String.valueOf(Integer.toOctalString(dataRegister)));
                    jTextField5.setText(String.valueOf(Integer.toOctalString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toOctalString(opcode)));
                    jTextField12.setText(String.valueOf(Integer.toOctalString(acumulator)));
                }
                else{
                    jTextField7.setText(String.valueOf(dataRegister));
                    jTextField5.setText(String.valueOf(instructionRegister));
                    jTextField11.setText(String.valueOf(opcode));
                    jTextField12.setText(String.valueOf(acumulator));
                }

                microOperation = "M[AR] <- AC, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "HLT":
                jList3.setListData(notSplittedSelectedValue);
                selectedValueIndex = 8;
                instructionRegister = 727684;
                opcode = 7001;
                jList1.setSelectedIndex(selectedValueIndex);
                
                if(jComboBox1.getSelectedItem().equals("Binary")){
                    jTextField5.setText(String.valueOf(Integer.toBinaryString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toBinaryString(opcode)));
                    jList3.setListData(binaryNotSplittedSelectedValue);
                    
                }
                else if(jComboBox1.getSelectedItem().equals("Hex")){
                    jTextField5.setText(String.valueOf(Integer.toHexString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toHexString(opcode)));
                    jList3.setListData(hexNotSplittedSelectedValue);
                }
                else if(jComboBox1.getSelectedItem().equals("Octal")){
                    jTextField5.setText(String.valueOf(Integer.toOctalString(instructionRegister)));
                    jTextField11.setText(String.valueOf(Integer.toOctalString(opcode)));
                    jList3.setListData(octalNotSplittedSelectedValue);
                }
                else{
                    jTextField5.setText(String.valueOf(instructionRegister));
                    jTextField11.setText(String.valueOf(opcode));
                }

                microOperation = "S <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                JOptionPane.showMessageDialog(null, "Islem durduruldu !");
                break;
                
            case "SZA":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 839065;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7004;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "If(AC = 0) then (PC <- PC + 1)";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "INC":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 737867;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7020;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "AC <- AC + 1";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "CMA":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 677765;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7200;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "AC <- AC'";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "BUN":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 668578;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 4000;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "PC <- AR, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
             
            case "AND":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 657868;
                jTextField5.setText(String.valueOf(instructionRegister));
                microOperation = "DR <- M[AR] \n AC <- AC & DR, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
           
            case "BSA":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 668365;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 5000;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "M[AR] <- PC, AR <- AR + 1 \n PC <- AR, SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "ISZ":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 738390;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 6000;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "DR <- M[AR] \n DR <- DR + 1 \n M[AR] <- DR, if(DR = 0) then (PC <- PC + 1), SC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "CLA":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 677665;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7800;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "AC <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "SNA":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 837865;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7008;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "If(AC(15) = 1) then (PC <- PC +1)";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "SZE":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 839069;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 7002;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "If(E = 0) then (PC <- PC + 1)";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                
            case "INP":
                jList3.setListData(notSplittedSelectedValue);
                instructionRegister = 737880;
                jTextField5.setText(String.valueOf(instructionRegister));
                opcode = 0xF800;
                jTextField11.setText(String.valueOf(opcode));
                microOperation = "AC(0-7) <- INPR, FGI <- 0";
                jTextArea1.setText("Fetch T0: AR <- PC\nIR <- M[AR], PC <- PC + 1\nDecode T1: D0,..D7 <- Decode IR(12-14), AR <- IR(0-11), I <- IR(15)\nExecute:\n"+microOperation);
                break;
                 
            default:
                String[] data = new String[4];
                data[t] = variables[t];
                t++;
                switch(asmCode){
                    case "A,":
                        
                        if(jComboBox1.getSelectedItem().equals("Binary")){
                            jList3.setListData(binaryNotSplittedSelectedValue);
                        }
                        else if(jComboBox1.getSelectedItem().equals("Hex")){
                            jList3.setListData(hexNotSplittedSelectedValue);
                        }
                        else{
                            jList3.setListData(notSplittedSelectedValue);
                        }  

                        jList2.setListData(data);
                        selectedValueIndex = 2;
                        jList1.setSelectedIndex(selectedValueIndex);
                        break;
                        
                    case "B,":
                        
                         if(jComboBox1.getSelectedItem().equals("Binary")){
                            jList3.setListData(binaryNotSplittedSelectedValue);
                        }
                        else if(jComboBox1.getSelectedItem().equals("Hex")){
                            jList3.setListData(hexNotSplittedSelectedValue);
                        }
                        else{
                            jList3.setListData(notSplittedSelectedValue);
                        }
                        
                        jList2.setListData(data);
                        selectedValueIndex = 3;
                        jList1.setSelectedIndex(selectedValueIndex);
                        break;
                        
                    case "C,":
                        
                         if(jComboBox1.getSelectedItem().equals("Binary")){
                            jList3.setListData(binaryNotSplittedSelectedValue);
                        }
                        else if(jComboBox1.getSelectedItem().equals("Hex")){
                            jList3.setListData(hexNotSplittedSelectedValue);
                        }
                        else{
                            jList3.setListData(notSplittedSelectedValue);
                        }
                         
                        
                        data[2] = String.valueOf(acumulator);
                        jList2.setListData(data);
                        selectedValueIndex = 4;
                        jList1.setSelectedIndex(selectedValueIndex);
                        break;
                            
                }
                jTextField2.setText(String.valueOf(addressRegister));     
                break;
                
                
                
        }
    }
    
    
 
    
    public Grup_7_AnaEkran() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectedIndex(0);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setText("Conversion Type:");
        jToolBar1.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binary", "Hex", "Octal", "Decimal" }));
        jToolBar1.add(jComboBox1);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hakan\\Documents\\NetBeansProjects\\_Grup_7\\src\\main\\java\\com\\mycompany\\_grup_7\\icons\\stop_15px.png")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hakan\\Documents\\NetBeansProjects\\_Grup_7\\src\\main\\java\\com\\mycompany\\_grup_7\\icons\\right_15px.png")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registers"));
        jPanel2.setToolTipText("");

        jLabel2.setText("Program Counter:");

        jLabel3.setText("Address Register:");

        jLabel4.setText("Input Register:");

        jLabel5.setText("Output Register:");

        jLabel6.setText("Data Register:");

        jLabel7.setText("Acumulator:");

        jLabel10.setText("Instruction Register:");

        jLabel11.setText("Stack Pointer:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0000");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0000");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0000");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0000");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0000000000000000");

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("000");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0000");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 192, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(jTextField4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8))
                        .addGap(65, 65, 65)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Micro Operations"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Memories"));

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("Opcode");

        jLabel13.setText("Value");

        jLabel14.setText("Label:");

        jLabel15.setText("Data:");

        jLabel16.setText("Instruction:");

        jLabel17.setText("Stack:");

        jScrollPane1.setViewportView(jList2);

        jScrollPane2.setViewportView(jList3);

        jScrollPane4.setViewportView(jList4);

        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jList5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel12)
                        .addGap(275, 275, 275)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(335, 335, 335))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        jTextPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parsed"));
        jScrollPane6.setViewportView(jTextPane1);

        jMenu1.setText("File");

        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hakan\\Documents\\NetBeansProjects\\_Grup_7\\src\\main\\java\\com\\mycompany\\_grup_7\\icons\\icons8_new_copy_16.png")); // NOI18N
        jMenuItem2.setText("New File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        String asmCodes[] = new String[50];
        int i = 0;
        
        BufferedReader reader;
            try {
                
                reader = new BufferedReader(new FileReader(selectedFile));
                String line = reader.readLine();
                asmCodes[0]=line;
                i++;
                
                while(line != null){

                line = reader.readLine();
                asmCodes[i]= line;
                i++;
            }
                reader.close();

                jList1.setListData(asmCodes);
                
                
                SimpleAttributeSet attributSet = new SimpleAttributeSet();
                jTextPane1.setCharacterAttributes(attributSet, true);
                Font font = new Font("Verdana", Font.BOLD, 15);
                jTextPane1.setFont(font);
                StyledDocument doc = jTextPane1.getStyledDocument();
                Style style = jTextPane1.addStyle("", null);
                Style style1 = jTextPane1.addStyle("",null);
                StyleConstants.setForeground(style, Color.red);
                StyleConstants.setBackground(style, Color.white);
                StyleConstants.setForeground(style1, Color.black);
                StyleConstants.setBackground(style1, Color.white);
                
                
 
                String[] yeter = new String[50];
                String[] labelTable = new String[20];
                String[] labels = new String[20];
                for(int b = 0; b < 21; b++){
                     
                     if(asmCodes[b]!=null){
                      yeter = asmCodes[b].split(" ");
                     
                     if(asmCodes[b].substring(0,2).substring(1).equals(",")){
                         labels[b] = asmCodes[b].substring(0,2);
                         if(labels[b] != null){
                             jList5.setListData(labels);
                         }
                         
                     }
                    }
                     
                     
                    

                 if(yeter.length == 8){
                    doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + " " + yeter[3] + " " + yeter[4] + " " +  yeter[5] + " "+ yeter[6] + " " + yeter[7] + "\n",style1);
                 }
                 else if(yeter.length == 7){
                    doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + " " + yeter[3] + " " + yeter[4] + " " +  yeter[5] + " "+ yeter[6] + "\n",style1);
                 }
                 else if(yeter.length == 6){
                    doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + " " + yeter[3] + " " +  yeter[4] + " " +yeter[5] +"\n",style1);
                 }
                 else if(yeter.length == 5){
                     doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + " " + yeter[3] + " " + yeter[4] +"\n",style1);
                 }
                 else if(yeter.length == 4){
                    doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + " " + yeter[3] +"\n",style1);
                 }
                 else if(yeter.length == 3){
                    
                    doc.insertString(doc.getLength(), yeter[0] + " ", style);
                    doc.insertString(doc.getLength(), yeter[1] + " " + yeter[2] + "\n",style1);
                    variables[c] = yeter[2];
                    variableName[c] = yeter[0].substring(0,1);
                    c++;
                    
                 }
                 else if(yeter.length == 2 ){
                     doc.insertString(doc.getLength(), yeter[0] + " " , style);
                     doc.insertString(doc.getLength(), yeter[1] + "\n", style1);
                 }
                 else if(yeter.length == 1){
                        doc.insertString(doc.getLength(), yeter[0] , style);
                        doc.insertString(doc.getLength(), "\n", style);
                 }
                
                }
                
                jList1.setSelectedIndex(selectedValueIndex);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadLocationException ex) {
                Logger.getLogger(Grup_7_AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
           
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        selectedValue = jList1.getSelectedValue();
        splittedSelectedValue = selectedValue.split(" ");
        try{
            notSplittedSelectedValue[y] = selectedValue;
            binaryNotSplittedSelectedValue[y] = strToBinary(selectedValue);
            hexNotSplittedSelectedValue[y] = ASCIItoHEX(selectedValue);
            
            y++;
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
      
        detectAsmCodes(splittedSelectedValue[0]);
   
        jList1.setSelectedIndex(selectedValueIndex);
        programCounter++;
        jTextField1.setText(String.valueOf(programCounter));
        jTextField8.setText(String.valueOf(acumulator));
        jTextField2.setText(String.valueOf(addressRegister));
        jTextField6.setText(String.valueOf(addressRegister - 1));
        addressRegister = selectedValueIndex;
        
      
        
    
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        
    }//GEN-LAST:event_jList1ValueChanged

   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grup_7_AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grup_7_AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grup_7_AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grup_7_AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grup_7_AnaEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    public javax.swing.JList<String> jList5;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
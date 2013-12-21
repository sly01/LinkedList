/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;


/**
 *
 * @author erkoc
 */
public class Frame extends JFrame {

    JMenuBar mainMenuBar;
    JMenu fileMenu;
    JMenu aboutMenu;
    JMenuItem mnOpen;
    JMenuItem mnClose;
    JMenuItem mnAbout;
    JPanel pnl;
    JLabel lblInsert;
    JLabel lblCommand;
    JTextArea txtArea;
    JTextField txtField;

    LinkedList list;
    
    public Frame() throws HeadlessException {
        //Menu configuration
        mainMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        aboutMenu = new JMenu("About");

        mnOpen = new JMenuItem("Open");
        mnClose = new JMenuItem("Close");

        mnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(mnOpen);
        fileMenu.add(mnClose);


        mnAbout = new JMenuItem("About us");

        mnAbout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AboutUs aboutUs = new AboutUs();
                aboutUs.setVisible(true);
            }
        });

        aboutMenu.add(mnAbout);

        mainMenuBar.add(fileMenu);
        mainMenuBar.add(aboutMenu);

        setJMenuBar(mainMenuBar);

        lblInsert = new JLabel();
        lblInsert.setText("1-Insertion Mode");
        lblCommand = new JLabel();
        lblCommand.setText("2-Command Mode");
        
        txtArea = new JTextArea();
        txtArea.setSize(30, 30);
        
        
        
        txtField = new JTextField();
        // Panel configuration for mode 
        pnl = new JPanel();
        pnl.setLayout(new GridLayout(1, 2));
        pnl.setBorder(new TitledBorder("Mode Selection"));
        pnl.add(lblInsert);
        pnl.add(lblCommand);
        pnl.add(txtField);

        //Asking for mode insertion or command
        int result = JOptionPane.showConfirmDialog(null, pnl,
                "Please Enter the choice", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION && txtField.getText().equals("1")) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Command mode is not created yet :(");
            System.exit(0);
        }
       
        getContentPane().add(txtArea);
        list = new LinkedList();
        String[] lines = txtArea.getText().split("\\n");
        while (!lines.equals("exit")) {            
            System.out.println(lines);
        }
        
        writeInFile("test");
        setTitle("Line-based Text Editor");
        setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);




    }
    public void writeInFile(String filename){
         try {
            File file = new File("/Users/erkoc/Desktop/proje/"+filename+".txt");
            FileWriter fwriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fwriter);
            for (Object satir : list) {
                bw.write(satir.toString() + "\n");
            }
            bw.close();
        } catch (Exception hata) {
            System.out.println("There is error while writing to file");
        }
    }
}

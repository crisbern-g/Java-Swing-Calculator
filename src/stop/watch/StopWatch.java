/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stop.watch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static stop.watch.StopWatch.centerRenderer;


public class StopWatch{
        public static String[] headerName = {"Lap", "Time"};
        public static String[][] data = {};
        public static JFrame mainFrame = new JFrame("Stop Watch");
        public static JPanel panelTimer = new JPanel();
        public static JPanel textTimer = new JPanel();
        public static JButton buttonStart = new JButton("START");
        public static JButton buttonLap = new JButton("LAP");
        public static JButton buttonStop = new JButton("STOP");
        public static JButton buttonReset = new JButton("RESET");
        public static JLabel timeDisplay = new JLabel();
        public static systemTimer progTime = new systemTimer();
        public static boolean startTimer = true;
        public static JPanel panelData = new JPanel();
        public static DefaultTableModel modelData = new DefaultTableModel(data, headerName);
        public static JTable tableData = new JTable(modelData);       
        public static JScrollPane tableScroll = new JScrollPane(tableData);
        public static int lapNumber = 1;
        public static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        
        
public static class timer implements Runnable{
    boolean timerStatus = true;
    public timer(boolean userInput){
        timerStatus=userInput;
    }
    
    public void run(){
        
    while(true){
    if(startTimer){
    try{
    progTime.incrementTime();
    timeDisplay.setText(progTime.displayTime());
    Thread.sleep(100);
    }
    catch(InterruptedException e){}
    }
    else
        timeDisplay.setText(progTime.displayTime());
    }
    }
}
    public static void main(String[] args) {
        
        
        Thread timeThread = new Thread(new timer(true));
        timeDisplay.setSize(100, 100);
        timeDisplay.setLocation(0, 50);
        timeDisplay.setText(progTime.displayTime());
        timeDisplay.setForeground(Color.WHITE);
        timeDisplay.setFont(new Font("Impact", 0, 110));
        timeDisplay.setVisible(true);

        
        textTimer.setLocation(260, 25);
        textTimer.setSize(500, 255);
        textTimer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 3), "STOP WATCH", 
                TitledBorder.CENTER, 0, new Font("Impact", 0, 30), Color.WHITE));
        textTimer.setBackground(Color.BLACK);
        textTimer.setForeground(Color.WHITE);
        textTimer.add(timeDisplay);
        textTimer.setVisible(true);
        
        buttonStart.setSize(200, 50);
        buttonStart.setLocation(40, 43);
        buttonStart.setEnabled(true);
        buttonStart.setBackground(Color.BLACK);
        buttonStart.setForeground(Color.WHITE);
        buttonStart.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        buttonStart.setFont(new Font("Impact", Font.PLAIN,35));
        buttonStart.setFocusPainted(false);
        buttonStart.setVisible(true);
        
        buttonLap.setSize(200, 50);
        buttonLap.setLocation(40, 105);
        buttonLap.setEnabled(false);
        buttonLap.setBackground(Color.BLACK);
        buttonLap.setForeground(Color.WHITE);
        buttonLap.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        buttonLap.setFont(new Font("Impact", Font.PLAIN,35));
        buttonLap.setFocusPainted(false);
        buttonLap.setVisible(true);
        
        buttonStop.setSize(200, 50);
        buttonStop.setLocation(40, 167);
        buttonStop.setEnabled(false);
        buttonStop.setBackground(Color.BLACK);
        buttonStop.setForeground(Color.WHITE);
        buttonStop.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        buttonStop.setFont(new Font("Impact", Font.PLAIN,35));
        buttonStop.setFocusPainted(false);
        buttonStop.setVisible(true);
        
        buttonReset.setSize(200, 50);
        buttonReset.setLocation(40, 229);
        buttonReset.setEnabled(false);
        buttonReset.setBackground(Color.BLACK);
        buttonReset.setForeground(Color.WHITE);
        buttonReset.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        buttonReset.setFont(new Font("Impact", Font.PLAIN,35));
        buttonReset.setFocusPainted(false);
        buttonReset.setVisible(true);        
        
        panelTimer.setLocation(100, 10);
        panelTimer.setSize(800, 300);
        panelTimer.setBackground(Color.BLACK);
        panelTimer.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        panelTimer.setLayout(null);
        panelTimer.add(textTimer);
        panelTimer.add(buttonStart);
        panelTimer.add(buttonLap);
        panelTimer.add(buttonStop);
        panelTimer.add(buttonReset);
        panelTimer.setVisible(true);
        
        tableScroll.setSize(535, 300);
        tableScroll.setLocation(0, 0);
        tableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroll.setVisible(true);
        
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        tableData.setFillsViewportHeight(true);
        tableData.setLocation(0, 0);
        tableData.setSize(535, 300);
        tableData.setRowHeight(30);
        tableData.getTableHeader().setBackground(Color.DARK_GRAY);
        tableData.getTableHeader().setForeground(Color.WHITE);
        tableData.getTableHeader().setFont(new Font("Impact", 0, 20));
        tableData.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        tableData.setEnabled(false);
        tableData.setFont(new Font("Impact", 0, 20));
        tableData.setEditingColumn(0);
        tableData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableData.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);    
        tableData.setForeground(Color.white);
        tableData.setBackground(Color.DARK_GRAY);
        tableData.setForeground(Color.WHITE);
        tableData.setVisible(true);
        
        
        panelData.setLocation(365, 320);
        panelData.setSize(535, 340);
        panelData.setBackground(Color.LIGHT_GRAY);
        panelData.setBorder(BorderFactory.createLoweredBevelBorder());
        panelData.setLayout(null);
        panelData.add(tableScroll);
        panelData.setVisible(true);
        
        mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
        mainFrame.setSize(1000, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.add(panelTimer);
        mainFrame.add(panelData);
        mainFrame.setVisible(true);
        
        buttonStart.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                if(buttonStart.isEnabled())
                    buttonStart.setBackground(Color.GREEN);
            }

            public void mousePressed(MouseEvent me) {
                buttonStart.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent me) {
                if(buttonStart.isEnabled())
                    buttonStart.setBackground(Color.GREEN);
            }

            public void mouseEntered(MouseEvent me) {
                if(buttonStart.isEnabled())
                    buttonStart.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent me) {
               buttonStart.setBackground(Color.BLACK);
            }
        });
        
        buttonStop.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
               if(buttonStop.isEnabled())
                buttonStop.setBackground(Color.RED);
            }

            public void mousePressed(MouseEvent me) {
                buttonStop.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent me) {
               if(buttonStop.isEnabled())
                buttonStop.setBackground(Color.RED);
            }

            public void mouseEntered(MouseEvent me) {
               if(buttonStop.isEnabled())
                buttonStop.setBackground(Color.RED);
            }

            public void mouseExited(MouseEvent me) {
               buttonStop.setBackground(Color.BLACK);
            }
        });
        
        buttonLap.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                if(buttonLap.isEnabled())
                    buttonLap.setBackground(Color.YELLOW);
            }

            public void mousePressed(MouseEvent me) {
                buttonLap.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent me) {
                if(buttonLap.isEnabled())
                    buttonLap.setBackground(Color.YELLOW);
            }

            public void mouseEntered(MouseEvent me) {
                if(buttonLap.isEnabled())
                    buttonLap.setBackground(Color.YELLOW);
            }

            public void mouseExited(MouseEvent me) {
               buttonLap.setBackground(Color.BLACK);
            }
        });
        
        buttonReset.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                 if(buttonReset.isEnabled())               
                    buttonReset.setBackground(Color.BLUE);
            }

            public void mousePressed(MouseEvent me) {
                buttonReset.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent me) {
            if(buttonReset.isEnabled())
                buttonReset.setBackground(Color.BLUE);
            }

            public void mouseEntered(MouseEvent me) {
                if(buttonReset.isEnabled())
                    buttonReset.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent me) {
               buttonReset.setBackground(Color.BLACK);
            }
        });
        
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(!timeThread.isAlive()){
                timeThread.start();
                }
                else
                    startTimer = true;
                buttonReset.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
                buttonReset.setEnabled(false);
                buttonStart.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
                buttonStart.setEnabled(false);
                timeDisplay.setForeground(Color.WHITE);
                buttonStop.setEnabled(true);
                buttonStop.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                buttonLap.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                buttonLap.setEnabled(true);
            }
        });

        
        buttonStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                startTimer = false;
                buttonReset.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
                buttonReset.setEnabled(true);
                buttonStart.setEnabled(true);
                buttonStart.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                timeDisplay.setForeground(Color.RED);
                buttonStop.setEnabled(false);
                buttonStop.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
                buttonLap.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));  
                buttonLap.setEnabled(false);
                            }
                        });
        
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                    progTime.resetTime();
                    timeDisplay.setText(progTime.displayTime());
                    buttonReset.setEnabled(false);
                    buttonReset.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
                    timeDisplay.setForeground(Color.WHITE);
                    buttonStop.setEnabled(false);
                    buttonStop.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
                    modelData.setNumRows(0);
                    lapNumber =  1;
            }
        });
        
        buttonLap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                modelData.addRow(new Object[]{lapNumber, progTime.displayTime()});
                lapNumber++;
                tableData.scrollRectToVisible(new Rectangle(tableData.getCellRect(modelData.getRowCount()-1, modelData.getColumnCount(), true)));
            }
        });
        
    }
    
}

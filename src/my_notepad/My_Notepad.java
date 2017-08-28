package my_notepad;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import java.security.Key;
import javafx.scene.chart.BarChart;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class My_Notepad extends JFrame implements ActionListener {

    JTextArea t;
    JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13;
    JMenu m1, m2, m3, m4, m5, m6;
    JMenuBar bar;
    JMenuItem fontProperties,backGorund;

    My_Notepad() {
        setVisible(true);
        DKmove dk = new DKmove(this, "MY NOTEPAD created By Durgesh ");
        Thread tt = new Thread(dk);
        tt.start();
      
        //setTitle("MyNotepad Created By Duregsh Tiwari");
        setSize(900, 600);
        this.setLocationRelativeTo(null);
        // setLocation(300, 50);

        Font f = new Font("verdana", Font.PLAIN, 15);
        Font f1 = new Font("", Font.PLAIN, 15);
        i1 = new JMenuItem("New");
        i1.setFont(f1);
        i2 = new JMenuItem("Open");
        i2.setFont(f1);
        i3 = new JMenuItem("Save");
        i3.setFont(f1);
        i4 = new JMenuItem("Save As");
        i4.setFont(f1);
        i5 = new JMenuItem("Exit");
        i5.setFont(f1);
        i6 = new JMenuItem("Undo");
        i6.setFont(f1);
        i7 = new JMenuItem("Cut");
        i7.setFont(f1);
        i8 = new JMenuItem("Copy");
        i8.setFont(f1);
        i9 = new JMenuItem("Paste");
        i9.setFont(f1);
        i10 = new JMenuItem("Delete");
        i10.setFont(f1);
        i11 = new JMenuItem("Satus Bar");
        i11.setFont(f1);
        i12 = new JMenuItem("durgeshkumar305@gmail.com");
        i12.setFont(f1);
        i13 = new JMenuItem("Open Help");
        i13.setFont(f1);
        fontProperties = new JMenuItem("Font Properties");
        backGorund=new JMenuItem("Change Backgound Color");
        backGorund.setFont(f1);
        fontProperties.setFont(f1);
        fontProperties.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));

        m1 = new JMenu("File");

        m1.setFont(f);
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m1.add(i4);
        m1.add(i5);
        m2 = new JMenu("Edit");
        m2.setFont(f);
        m2.add(i6);
        m2.add(i7);
        m2.add(i7);
        m2.add(i8);
        m2.add(i9);
        m2.add(i10);
        m3 = new JMenu("Format");
        m3.setFont(f);
        m3.add(fontProperties);
        m3.add(backGorund);
        m4 = new JMenu("View");
        m4.setFont(f);
        m4.add(i11);
        m5 = new JMenu("Help");
        m5.setFont(f);
        m5.add(i13);
        m6 = new JMenu("Contact");
        m6.setFont(f);
        m6.add(i12);
        bar = new JMenuBar();
        bar.add(m1);
        bar.add(m2);
        bar.add(m3);
        bar.add(m4);
        bar.add(m5);
        bar.add(m6);
        setJMenuBar(bar);
        t = new JTextArea();
        t.setLineWrap(true);
        t.setFont(f);
        add(new JScrollPane(t));
        //t.setFont(new Font("", Font.PLAIN, 20));
        
        bar.setMargin(new Insets(200, 200, 700, 100));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        i3.setAccelerator(KeyStroke.getKeyStroke((KeyEvent.VK_S), (KeyEvent.CTRL_MASK)));
        i5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.ALT_MASK));
        i7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
        i8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
        i9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i7.addActionListener(this);
        i10.addActionListener(this);
        i13.addActionListener(this);
        initEvent();
    }
    
     private void initEvent() 
     {
     fontProperties.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e)
     {
    TextAreaFont temp=new TextAreaFont(t);
   
     }
     });
     backGorund.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
             Color c=JColorChooser.showDialog(rootPane,"Select Color", Color.WHITE);
            t.setForeground(c);
         }
     });
     
     

     }
    

    public static void main(String[] args) 
    {
        try
        {
       My_Notepad m =new My_Notepad();
      //// UIManager.setLookAndFeel(new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel());
       //SwingUtilities.updateComponentTreeUI(m);
       UIManager.setLookAndFeel(new AluminiumLookAndFeel());
       SwingUtilities.updateComponentTreeUI(m);
        
    }catch(Exception e)
    {
    e.printStackTrace();
    }}

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if (str.equals("New")) {
            t.setText(null);
        } else if (str.equals("Open")) {
            try {
                JFileChooser jfc = new JFileChooser();
                jfc.showOpenDialog(this);
                File f = jfc.getSelectedFile();
                  FileInputStream fr = new FileInputStream(f);
                ProgressMonitorInputStream pis=new ProgressMonitorInputStream(null, "Reading",fr);
                // byte[] b = new byte[pis.available()];
                pis.getProgressMonitor().setMillisToPopup(10);
               
              //  pis.read(b);
                 String aa = "";
                int i=0;
                while(true)
                {
                    i=pis.read();
                    if(i==-1)
                        break;
                    aa+=(char)i;
                }
               
                t.setText(aa);

            } catch (Exception ex) {

            }

        } else if (str.equals("Exit")) {
            System.exit(11);
        } else if (str.equals("Save")) {
            try {
                JFileChooser jfc = new JFileChooser();
                jfc.showSaveDialog(this);
                File f = jfc.getSelectedFile();
                FileOutputStream out = new FileOutputStream(f);
                String tt = t.getText();
                byte[] b = tt.getBytes();
                out.write(b);

            } catch (Exception exx) {

            }

        } else if (str.equals("Save As")) {
            try {
                JFileChooser jfc = new JFileChooser();
                jfc.showSaveDialog(this);
                File f = jfc.getSelectedFile();
                FileOutputStream out = new FileOutputStream(f);
                String tt = t.getText();
                byte[] b = tt.getBytes();
                out.write(b);

            } catch (Exception exxx) {

            }

        } else if (str.equals("Copy")) {
            String aa = t.getSelectedText();
            if (aa.equals("")) {

            } else {
                StringSelection ss = new StringSelection(aa);
                Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
                clp.setContents(ss, null);
            }

        } else if (str.equals("Cut")) {
            String aa = t.getSelectedText();
            String whole = t.getText();
            String temp1 = whole.replace(aa, "");
            t.setText(temp1);
            StringSelection ss = new StringSelection(aa);
            Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
            clp.setContents(ss, null);
            // t.setText(null);

        } else if (str.equals("Paste")) {
            String result = "";
            Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();

            Transferable content = clp.getContents(null);
            boolean htt = (content != null) && content.isDataFlavorSupported(DataFlavor.stringFlavor);
            if (htt) {
                try {
                    result = (String) content.getTransferData(DataFlavor.stringFlavor);
                    t.setText(result);

                } catch (Exception exxx) {
                    exxx.printStackTrace();
                    JOptionPane.showMessageDialog(null, "error in pasting the content of the clipbord try again");
                }
            }

        } else if (str.equals("Delete")) {
            t.setText(null);
        } else if (str.equals("Open Help")) {
            t.setText("Hi This is notepad created by Durgesh Kumar Tiwari during learing java swing ..."
                    + "\n you can create a file FILE->NEW"
                    + "\n you can save the file FILE-> SAVE"
                    + "\n you can COPY PASTE DELETE the text from the text area by choosing the appropiate option in menus thankyou for any file GOTO contact.");
        }
    }

}

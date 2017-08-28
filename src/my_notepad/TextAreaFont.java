package my_notepad;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author durgesh
 */
public class TextAreaFont extends JFrame {

    JPanel p1, p2;
    JComboBox<String> size;
    JComboBox<String> family;
    JComboBox<String> style;
    JButton b1;
    JTextArea t;

    public TextAreaFont(JTextArea t) {
        this.t = t;
        this.setTitle("Select Font Properties ");
        initComponent();
        initEvent();
        //this.pack();
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponent() {
        p1 = new JPanel(new GridLayout(1, 3, 8, 8));
        p1.setBorder(BorderFactory.createTitledBorder("Choose"));
        p2 = new JPanel(new GridLayout(1, 3, 8, 8));

        size = new JComboBox<String>();
        style = new JComboBox<String>();
        family = new JComboBox<String>();

        for (int i = 1; i <= 50; i++) {
            size.addItem(String.valueOf(i));
        }
      size.setSelectedIndex(25);
        String[] style1 = {"PLAIN", "BOLD", "ITALIC"};
        for (int i = 0; i < style1.length; i++) {
            style.addItem(style1[i]);
        }
        String listFamily[]={"Arial","Courier","Cursive","Sans Serif","DaunPenh","Liberation Serif","URW Chancery L","Times New Roman"};
        for (int i = 0; i < listFamily.length; i++) {
            family.addItem(listFamily[i]);
        }
        b1 = new JButton("OK");
        p1.add(family);
        p1.add(style);
        p1.add(size);
        p2.add(new JLabel());
        p2.add(new JLabel());
        p2.add(b1);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);

    }

    public void initEvent() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String size1 = String.valueOf(size.getSelectedItem());
                    String style1 = String.valueOf(style.getSelectedItem());
                    String family1 = String.valueOf(family.getSelectedItem());
                    //JOptionPane.showMessageDialog(null, family1);
                    Integer ob=null;
                    if(style1.equals("ITALIC"))
                     ob=Font.ITALIC;
                    else if(style1.equals("BOLD"))
                           ob=Font.BOLD;
                    else if(style1.equals("PLAIN"))
                        ob=Font.PLAIN;
                    
                    t.setFont(new Font(family1,ob,(Integer.parseInt(size1))));
                    setVisible(false);
                
            }catch (Exception e) {

                }
            }

        });
    }

}

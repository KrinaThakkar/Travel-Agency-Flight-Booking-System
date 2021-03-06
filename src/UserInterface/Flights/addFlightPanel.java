/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Flights;

import Business.FlightDirectory;
import Business.Flights;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Krina Thakkar
 */
public class addFlightPanel extends javax.swing.JPanel {

    /**
     * Creates new form addFlightPanel
     */
    private FlightDirectory FlightDir;
    private JPanel leftpanel;

    public addFlightPanel(JPanel leftpanel, FlightDirectory FlightDir) {
        initComponents();
        this.leftpanel = leftpanel;
        this.FlightDir = FlightDir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateTxtField = new javax.swing.JTextField();
        fromTxtField = new javax.swing.JTextField();
        toTxtField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        airlineTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        flightNoTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Date:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel2.setText("Departure:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jLabel3.setText("Add Flights");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 45, -1, -1));

        jLabel4.setText("Arrival:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));
        add(dateTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 57, -1));
        add(fromTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 57, -1));
        add(toTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 57, -1));

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 272, -1, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 272, -1, -1));

        jLabel5.setText("Airlines:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));
        add(airlineTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 57, -1));

        jLabel6.setText("Flight Number:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));
        add(flightNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 57, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        //// TODO add your handling code here:
      //  System.out.println("hello");
        Flights flights = FlightDir.addFlight();
         if(flightNoTextField.getText().equals("") || airlineTxtField.getText().equals("") || fromTxtField.getText().equals("") || toTxtField.getText().equals("") || dateTxtField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Field is Mandatory");
            }
        try{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dateTxtField.getText());
        flights.setDate(date);
        Pattern pattern = Pattern.compile("[a-z]*$");
        Matcher m = pattern.matcher(flightNoTextField.getText());
        Pattern p = Pattern.compile("[a-z]*$");
        Matcher ma = p.matcher(airlineTxtField.getText());
        Pattern pat = Pattern.compile("[a-z]*$");
        Matcher mat = pat.matcher(fromTxtField.getText());
        Pattern patt = Pattern.compile("[a-z]*$");
        Matcher matc = patt.matcher(toTxtField.getText());
         if(!(m.matches()) || !(ma.matches()) || !(mat.matches()) || !(matc.matches()))
        {
            JOptionPane.showMessageDialog(null, "Invalid Content!");
        } else{
        flights.setFlightNo(flightNoTextField.getText());
        flights.setDeparture(fromTxtField.getText());
        flights.setArrival(toTxtField.getText());
        flights.setAirlineName(airlineTxtField.getText());
        
        JOptionPane.showMessageDialog(null, "Wuhuu, Flight Added Successfully!!");
        }
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null,"Please enter correct date!");
        }   
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        leftpanel.remove(this);
        CardLayout layout = (CardLayout) leftpanel.getLayout();
        layout.previous(leftpanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airlineTxtField;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField dateTxtField;
    private javax.swing.JTextField flightNoTextField;
    private javax.swing.JTextField fromTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField toTxtField;
    // End of variables declaration//GEN-END:variables
}

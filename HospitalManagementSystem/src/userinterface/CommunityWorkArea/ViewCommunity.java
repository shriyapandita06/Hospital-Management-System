/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.CommunityWorkArea;

import javax.swing.table.DefaultTableModel;
import model.City;
import model.Community;

/**
 *
 * @author Tejas
 */
public class ViewCommunity extends javax.swing.JPanel {

    /**
     * Creates new form SystemViewHospital
     */
    Community community;
    public ViewCommunity(Community community) {
        initComponents();
        this.community = community;
        initCityCmbx();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSearchCommunity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCommunityList = new javax.swing.JTable();
        comboCity = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(102, 0, 51));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("View Community");

        lblSearchCommunity.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchCommunity.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSearchCommunity.setText("City :");

        tblCommunityList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Community Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCommunityList);

        comboCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCityItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(lblSearchCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(comboCity, 0, 213, Short.MAX_VALUE))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCityItemStateChanged
        // TODO add your handling code here:
        populateData();
    }//GEN-LAST:event_comboCityItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCity;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchCommunity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCommunityList;
    // End of variables declaration//GEN-END:variables

    private void populateData() {
       try{
            var selectedCity = comboCity.getSelectedItem().toString();
        City city = City.valueOf(selectedCity);
        
        String[] communities = community.getLstCommunity().get(city);
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{ "Community Name"},0);
        
        for(String c : communities){
            model.addRow(new Object[]{c});
        }
        
        tblCommunityList.setModel(model);
            
       }
       catch(Exception e)
       {
           System.out.println(e);
       }    
    }
    
    private void initCityCmbx() {
       comboCity.removeAllItems();
       int count = 0;
        City[] cities = City.values();
        for (City city_ : cities) {
            comboCity.addItem(cities[count++].toString());
        }
         populateData();
    }
    

}
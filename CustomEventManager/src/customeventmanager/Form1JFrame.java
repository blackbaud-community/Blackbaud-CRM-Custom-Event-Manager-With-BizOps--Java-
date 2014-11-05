/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Form1JFrame.java
 *
 * Created on Jan 9, 2012, 12:46:19 PM
 */
package customeventmanager;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


/**
 *
 * @author TomTr
 */
public final class Form1JFrame extends javax.swing.JFrame {

    final DefaultListModel listModel = new DefaultListModel();
    final DefaultTableModel tableModel = new DefaultTableModel();
    final DefaultTableModel tableModelEventExpense = new DefaultTableModel();
    final Boolean useHttps = false;
    String databaseToUse = "";
    
    //SelectSearchResultsForm searchScreen = new SelectSearchResultsForm (this, false);
    
    public class SelectionListener implements ListSelectionListener {
        JTable table;
        SelectionListener(JTable table) {
            this.table = table;
        }
        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                loadExpenses(jTableEvents.getValueAt(jTableEvents.getSelectedRow(), 9).toString());
            } catch (JAXBException ex) {
                Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setEventsTableModelColumns(){
        tableModel.addColumn("Name");
        tableModel.addColumn("Start date");
        tableModel.addColumn("Start time");
        tableModel.addColumn("End date");        
        tableModel.addColumn("End time");
        tableModel.addColumn("No. of registrants");        
        tableModel.addColumn("Budgeted amount");
        tableModel.addColumn("Actual amount");        
        tableModel.addColumn("Main event");
        tableModel.addColumn("ID");
    }

    public void setEventExpenseListTableModelColumns(){
        tableModelEventExpense.addColumn("Type");
        tableModelEventExpense.addColumn("Vendor");
        tableModelEventExpense.addColumn("Budgeted amount");
        tableModelEventExpense.addColumn("Agreed amount");        
        tableModelEventExpense.addColumn("Amount paid");
        tableModelEventExpense.addColumn("Date due");        
        tableModelEventExpense.addColumn("Date paid");
        tableModelEventExpense.addColumn("Comment");        
        tableModelEventExpense.addColumn("Event");
        tableModelEventExpense.addColumn("ID");
    }
    
    public void loadExpense(String expenseId) throws JAXBException, IOException{
        EventExpenseEditRecordOperation.RecordData expenseData = new EventExpenseEditRecordOperation.RecordData();
                
        //Load the data
        String expenseLoadRequestStr;
        String expenseLoadReplyStr;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/recordedits/7e655536-771c-4249-b366-0f647db170df/soap.asmx";
        }
        
        EventExpenseEditRecordOperation.LoadDataRequest expenseLoadRequestObj = new EventExpenseEditRecordOperation.LoadDataRequest();
        EventExpenseEditRecordOperation.ObjectFactory objectFactoryEventExpenseLoadOperation = new EventExpenseEditRecordOperation.ObjectFactory();
        expenseLoadRequestObj = objectFactoryEventExpenseLoadOperation.createLoadDataRequest();
        expenseLoadRequestObj.setRecordID(expenseId);

        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseEditRecordOperation.LoadDataRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(expenseLoadRequestObj, st);
        expenseLoadRequestStr = st.toString();
        expenseLoadRequestStr = MessageAdjustments.fixSOAPRequestMessage(expenseLoadRequestStr);
        expenseLoadReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(expenseLoadRequestStr, urlString, useHttps);
        expenseLoadReplyStr  = MessageAdjustments.stripSOAPReplyMessage(expenseLoadReplyStr);      
        EventExpenseEditRecordOperation.LoadDataReply expenseLoadReplyObj = new EventExpenseEditRecordOperation.LoadDataReply();
        expenseLoadReplyObj = objectFactoryEventExpenseLoadOperation.createLoadDataReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseEditRecordOperation.LoadDataReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(expenseLoadReplyStr);
        expenseLoadReplyObj = (EventExpenseEditRecordOperation.LoadDataReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        
        //Pass the data to the form
        expenseData = expenseLoadReplyObj.getRecordData();
        //EditExpenseJInternalFrame editExpenseScreen = new EditExpenseJInternalFrame(expenseData);
        EditExpenseJFrame editExpenseScreen = new EditExpenseJFrame(expenseData, expenseId, databaseToUse);
        editExpenseScreen.setEnabled(true);
        editExpenseScreen.setVisible(true);
        editExpenseScreen.toFront();
    }
       
    public void addExpense(String eventId, String eventName) throws JAXBException, IOException{
        AddExpenseJFrame addExpenseScreen = new AddExpenseJFrame(eventId, eventName, databaseToUse);
        addExpenseScreen.setEnabled(true);
        addExpenseScreen.setVisible(true);
        addExpenseScreen.toFront();
    }
    
    public void deleteExpense(String expenseId) throws JAXBException, IOException {
        String expenseDeleteReq;
        String expenseDeleteReply;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/recordoperations/eeba73b6-8878-41c5-9730-a3c7f9e64a9f/soap.asmx ";
        }
        
        EventExpenseDeleteRecordOperation.ExecuteRecordOperationRequest expenseDeleteRequestObj = new EventExpenseDeleteRecordOperation.ExecuteRecordOperationRequest();
        EventExpenseDeleteRecordOperation.ObjectFactory objectFactoryEventExpenseRecordOperation = new EventExpenseDeleteRecordOperation.ObjectFactory();
        expenseDeleteRequestObj = objectFactoryEventExpenseRecordOperation.createExecuteRecordOperationRequest();
        expenseDeleteRequestObj.setRecordID(expenseId);
        
        //System.out.println(expenseDeleteRequestObj);
        //System.out.println(expenseDeleteRequestObj.getRecordIDList());
        //System.out.println(expenseDeleteRequestObj.getSecurityContext());
        //expenseDeleteRequestObj.setSecurityContext(null);
        
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseDeleteRecordOperation.ExecuteRecordOperationRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(expenseDeleteRequestObj, st);
        expenseDeleteReq = st.toString();
        expenseDeleteReq = MessageAdjustments.fixSOAPRequestMessage(expenseDeleteReq);
        expenseDeleteReply = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(expenseDeleteReq, urlString, useHttps);
        expenseDeleteReply = MessageAdjustments.stripSOAPReplyMessage(expenseDeleteReply);      
        EventExpenseDeleteRecordOperation.ExecuteRecordOperationReply expenseDeleteReplyObj = new EventExpenseDeleteRecordOperation.ExecuteRecordOperationReply();
        expenseDeleteReplyObj = objectFactoryEventExpenseRecordOperation.createExecuteRecordOperationReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseDeleteRecordOperation.ExecuteRecordOperationReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(expenseDeleteReply);
        expenseDeleteReplyObj = (EventExpenseDeleteRecordOperation.ExecuteRecordOperationReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        JOptionPane.showMessageDialog(this,expenseDeleteReplyObj.getStatusMessage().toString());
        loadExpenses(jTableEvents.getValueAt(jTableEvents.getSelectedRow(), 9).toString());
    }
    
    public void loadDatabases() throws JAXBException, IOException{
        String dbNamesReq;
        String dbNamesReply;
        
        String urlString = "";
        if (useHttps){
            urlString = "https://altrurig01bo3.blackbaudhosting.com/5740Altru_9a731bb7-0e50-48e3-b8c3-e03e16a5ac15/DBList.asmx";
        }
        else{
            urlString = "http://localhost/bbAppFx/DBList.asmx";
        }
        
        blackbaud_appfx_ws_getdblist.GetDBListRequest dbListRequest = new blackbaud_appfx_ws_getdblist.GetDBListRequest();
        blackbaud_appfx_ws_getdblist.ObjectFactory objectFactoryDbList = new blackbaud_appfx_ws_getdblist.ObjectFactory();
        dbListRequest = objectFactoryDbList.createGetDBListRequest();
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(blackbaud_appfx_ws_getdblist.GetDBListRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(dbListRequest, st); 
        dbNamesReq = st.toString();
        dbNamesReq = MessageAdjustments.fixSOAPRequestMessage(dbNamesReq);
        dbNamesReply = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(dbNamesReq, urlString, useHttps);
        dbNamesReply = MessageAdjustments.stripSOAPReplyMessage(dbNamesReply);      
        blackbaud_appfx_ws_getdblist.GetDBListReply dbListReply = new blackbaud_appfx_ws_getdblist.GetDBListReply();
        dbListReply = objectFactoryDbList.createGetDBListReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(blackbaud_appfx_ws_getdblist.GetDBListReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(dbNamesReply);
        dbListReply = (blackbaud_appfx_ws_getdblist.GetDBListReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        List<String> dbList = dbListReply.getDatabases().getDb();
        for (String item : dbList){jComboBox_cbo_Databases.addItem(item);}; 
    }
    
    public void loadEvents() throws JAXBException, IOException{
        String eventsDlLoadReq;
        String eventsDlLoadReply;

        String urlString = "";
        if (useHttps){
            urlString = "https://altrurig01bo3.blackbaudhosting.com/5740Altru_9a731bb7-0e50-48e3-b8c3-e03e16a5ac15/vpp/bizops/db%5B10399621-5E99-4916-8625-2703496B1C41%5D/dataLists/cf479f2c-5657-42ca-8ed6-edde97c6a9ac/soap.asmx?SITEINFOID=9a731bb7-0e50-48e3-b8c3-e03e16a5ac15&HOSTEDSITEINFOID=9a731bb7-0e50-48e3-b8c3-e03e16a5ac15";
        }
        else{
            urlString = "http://localhost//bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/datalists/cf479f2c-5657-42ca-8ed6-edde97c6a9ac/soap.asmx";
        }
        EventCalendarEventListService.GetAllRowsRequest dlRowsRequest = new EventCalendarEventListService.GetAllRowsRequest();
        EventCalendarEventListService.ObjectFactory objectFactoryListService = new EventCalendarEventListService.ObjectFactory();
        dlRowsRequest = objectFactoryListService.createGetAllRowsRequest();
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventCalendarEventListService.GetAllRowsRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(dlRowsRequest, st); 
        eventsDlLoadReq = st.toString();
        eventsDlLoadReq = MessageAdjustments.fixSOAPRequestMessage(eventsDlLoadReq);
        eventsDlLoadReply = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(eventsDlLoadReq, urlString, useHttps);
        eventsDlLoadReply = MessageAdjustments.stripSOAPReplyMessage(eventsDlLoadReply);

        EventCalendarEventListService.GetAllRowsReply dlRowsReply = new EventCalendarEventListService.GetAllRowsReply();

        dlRowsReply = objectFactoryListService.createGetAllRowsReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventCalendarEventListService.GetAllRowsReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(eventsDlLoadReply);
        dlRowsReply = (EventCalendarEventListService.GetAllRowsReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));

        tableModel.setRowCount(0);
        
        for (int i = 0; i < dlRowsReply.getGetRowsReply().getTotalRowsInReply(); i++){
            Vector v = new Vector();
            
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getName());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getStartDate());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getStartTime());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getEndDate());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getEndTime());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getNoOfRegistrants());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getBudgetedAmount());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getActualAmount());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getMainEvent());            
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getID()); 
            tableModel.addRow(v);

        }              
    }

    public void loadExpenses(String eventID) throws JAXBException, IOException{
        String lvEventID = eventID;
        String eventsDlLoadReq;
        String eventsDlLoadReply;

        String urlString = "";
        if (useHttps){
            //urlString = "";
        }
        else{
            urlString = "http://localhost//bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/datalists/a62332d9-3f64-4b44-8b66-cfedfc747587/soap.asmx";
        }
        EventExpenseListService.GetAllRowsRequest dlRowsRequest = new EventExpenseListService.GetAllRowsRequest();
        EventExpenseListService.ObjectFactory objectFactoryListService = new EventExpenseListService.ObjectFactory();
        dlRowsRequest = objectFactoryListService.createGetAllRowsRequest();
        dlRowsRequest.setContextRecordID(lvEventID);
        
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseListService.GetAllRowsRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(dlRowsRequest, st); 
        eventsDlLoadReq = st.toString();
        eventsDlLoadReq = MessageAdjustments.fixSOAPRequestMessage(eventsDlLoadReq);
        eventsDlLoadReply = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(eventsDlLoadReq, urlString, useHttps);
        eventsDlLoadReply = MessageAdjustments.stripSOAPReplyMessage(eventsDlLoadReply);

        EventExpenseListService.GetAllRowsReply dlRowsReply = new EventExpenseListService.GetAllRowsReply();

        dlRowsReply = objectFactoryListService.createGetAllRowsReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseListService.GetAllRowsReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(eventsDlLoadReply);
        System.out.println(xmlStr);
        dlRowsReply = (EventExpenseListService.GetAllRowsReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));

        tableModelEventExpense.setRowCount(0);
        
        for (int i = 0; i < dlRowsReply.getGetRowsReply().getTotalRowsInReply(); i++){
            Vector v = new Vector();
            
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getType());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getVendor());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getBudgetedAmount());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getAgreedAmount());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getAmountPaid());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getDateDue());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getDatePaid());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getComment());
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getEVENTNAME());            
            v.add(dlRowsReply.getGetRowsReply().getRows().getListRow().get(i).getID()); 
            tableModelEventExpense.addRow(v);

        }
    }

    /** Creates new form Form1JFrame */
    public Form1JFrame() throws JAXBException, IOException {

        initComponents();
        loadDatabases();
        setEventsTableModelColumns();
        loadEvents();
        setEventExpenseListTableModelColumns();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_cbo_Databases = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonGetEvents = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonAddExpense = new javax.swing.JButton();
        jButtonEditExpense = new javax.swing.JButton();
        jButtonDeleteExpense = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEvents = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEventExpense = new javax.swing.JTable();
        jButtonLoadExpenses = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Select Database");

        jComboBox_cbo_Databases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_cbo_DatabasesActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Event to Display Expenses");

        jButtonGetEvents.setText("Get Events");
        jButtonGetEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetEventsActionPerformed(evt);
            }
        });

        jLabel3.setText("Expenses for");

        jButtonAddExpense.setText("Add Expense");
        jButtonAddExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedAddExpense(evt);
            }
        });
        jButtonAddExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddExpenseActionPerformed(evt);
            }
        });

        jButtonEditExpense.setText("Edit Expense");
        jButtonEditExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedEditExpense(evt);
            }
        });
        jButtonEditExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditExpenseActionPerformed(evt);
            }
        });

        jButtonDeleteExpense.setText("Delete Expense");
        jButtonDeleteExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedDeleteExpense(evt);
            }
        });
        jButtonDeleteExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteExpenseActionPerformed(evt);
            }
        });

        jTableEvents.setModel(tableModel);
        jTableEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jTableEvents);
        //SelectionListener listener = new SelectionListener(jTableEvents);
        //jTableEvents.getSelectionModel().addListSelectionListener(listener);
        //jTableEvents.getColumnModel().getSelectionModel()
        //    .addListSelectionListener(listener);

        jTableEventExpense.setModel(tableModelEventExpense);
        jTableEventExpense.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTableEventExpense);

        jButtonLoadExpenses.setText("Load Expenses");
        jButtonLoadExpenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedLoadExpenses(evt);
            }
        });
        jButtonLoadExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadExpensesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonLoadExpenses)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddExpense)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditExpense)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteExpense))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 614, Short.MAX_VALUE)
                        .addComponent(jButtonGetEvents))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_cbo_Databases, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox_cbo_Databases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jButtonGetEvents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteExpense)
                    .addComponent(jButtonEditExpense)
                    .addComponent(jButtonAddExpense)
                    .addComponent(jButtonLoadExpenses))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonGetEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetEventsActionPerformed
        try {
            // TODO add your handling code here:
            loadEvents();
        } catch (JAXBException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButtonGetEventsActionPerformed

private void jComboBox_cbo_DatabasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_cbo_DatabasesActionPerformed

    databaseToUse = jComboBox_cbo_Databases.getSelectedItem().toString();
}//GEN-LAST:event_jComboBox_cbo_DatabasesActionPerformed

private void mouseClickedLoadExpenses(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedLoadExpenses
    try {
        // TODO add your handling code here:
            loadExpenses(jTableEvents.getValueAt(jTableEvents.getSelectedRow(), 9).toString());
    } catch (JAXBException ex) {
        Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_mouseClickedLoadExpenses

private void mouseClickedAddExpense(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedAddExpense
        try {
            addExpense(jTableEvents.getValueAt(jTableEvents.getSelectedRow(), 9).toString(), jTableEvents.getValueAt(jTableEvents.getSelectedRow(), 0).toString());
        } catch (JAXBException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_mouseClickedAddExpense

private void jButtonAddExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddExpenseActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonAddExpenseActionPerformed

private void jButtonEditExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditExpenseActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonEditExpenseActionPerformed

private void mouseClickedEditExpense(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedEditExpense
        try {
            loadExpense(jTableEventExpense.getValueAt(jTableEventExpense.getSelectedRow(), 9).toString());
        } catch (JAXBException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_mouseClickedEditExpense

private void jButtonLoadExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadExpensesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonLoadExpensesActionPerformed

private void jButtonDeleteExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteExpenseActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonDeleteExpenseActionPerformed

private void mouseClickedDeleteExpense(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedDeleteExpense
        try {
            deleteExpense(jTableEventExpense.getValueAt(jTableEventExpense.getSelectedRow(), 9).toString());
        } catch (JAXBException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_mouseClickedDeleteExpense

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new Form1JFrame().setVisible(true);
                } catch (JAXBException ex) {
                    Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddExpense;
    private javax.swing.JButton jButtonDeleteExpense;
    private javax.swing.JButton jButtonEditExpense;
    private javax.swing.JButton jButtonGetEvents;
    private javax.swing.JButton jButtonLoadExpenses;
    private javax.swing.JComboBox jComboBox_cbo_Databases;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableEventExpense;
    private javax.swing.JTable jTableEvents;
    // End of variables declaration//GEN-END:variables
}

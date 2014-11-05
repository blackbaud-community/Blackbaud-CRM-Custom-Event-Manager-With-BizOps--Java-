/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEditExpenseJFrame.java
 *
 * Created on Jan 12, 2012, 9:40:36 AM
 */
package customeventmanager;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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


public class AddExpenseJFrame extends javax.swing.JFrame {
    static String eventId;
    static String eventName;
    static boolean useHttps = false;
    static DefaultTableModel tableModelConstituents = new DefaultTableModel();
    List<EventExpenseType.TableEntryListRow> typeList;
    static String databaseToUse = "";
    
    public void setConstituentsTableModelColumns(){
        tableModelConstituents.addColumn("Name");
        tableModelConstituents.addColumn("ID");
    }
    
    public static List<EventExpenseType.TableEntryListRow> loadExpenseTypeCodes() throws JAXBException, IOException{
        String expenseTypeListRequestStr;
        String expenseTypeListReplyStr;
        
        String urlString = "";
        if (useHttps){
            //missing URL String here
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/codetables/EVENTEXPENSETYPECODE/soap.asmx";
        }
        
        EventExpenseType.GetTableEntryListRequest eventExpenseTypeListRequestObj = new EventExpenseType.GetTableEntryListRequest();
        EventExpenseType.ObjectFactory objectFactoryEventExpenseType = new EventExpenseType.ObjectFactory();
        eventExpenseTypeListRequestObj = objectFactoryEventExpenseType.createGetTableEntryListRequest();
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseType.GetTableEntryListRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(eventExpenseTypeListRequestObj, st); 
        expenseTypeListRequestStr = st.toString();
        expenseTypeListRequestStr = MessageAdjustments.fixSOAPRequestMessage(expenseTypeListRequestStr);
        expenseTypeListReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(expenseTypeListRequestStr, urlString, useHttps);
        expenseTypeListReplyStr = MessageAdjustments.stripSOAPReplyMessage(expenseTypeListReplyStr);      
        EventExpenseType.GetTableEntryListReply eventExpenseTypeListReplyObj = new EventExpenseType.GetTableEntryListReply();
        eventExpenseTypeListReplyObj = objectFactoryEventExpenseType.createGetTableEntryListReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseType.GetTableEntryListReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(expenseTypeListReplyStr);
        eventExpenseTypeListReplyObj = (EventExpenseType.GetTableEntryListReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        List<EventExpenseType.TableEntryListRow> typeList = eventExpenseTypeListReplyObj.getRows().getTableEntryListRow();
        return typeList;
        
    }
    
    public String getVendorSingle(String constId) throws JAXBException, IOException{
        String constTranslateIDRequestStr;
        String constTranslateIDReplyStr;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/searchlists/23c5c603-d7d8-4106-aecc-65392b563887/soap.asmx";
        }
        
        ConstituentSearch.TranslateIDRequest constTranslateIDRequestObj = new ConstituentSearch.TranslateIDRequest();
        ConstituentSearch.ObjectFactory objectFactoryConstSearch = new ConstituentSearch.ObjectFactory();
        constTranslateIDRequestObj = objectFactoryConstSearch.createTranslateIDRequest();
        constTranslateIDRequestObj.setIDToTranslate(constId);
        
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(ConstituentSearch.TranslateIDRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(constTranslateIDRequestObj, st); 
        constTranslateIDRequestStr = st.toString();
        constTranslateIDRequestStr = MessageAdjustments.fixSOAPRequestMessage(constTranslateIDRequestStr);
        constTranslateIDReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(constTranslateIDRequestStr, urlString, useHttps);
        constTranslateIDReplyStr = MessageAdjustments.stripSOAPReplyMessage(constTranslateIDReplyStr);      
        ConstituentSearch.TranslateIDReply constTranslateIDReplyObj = new ConstituentSearch.TranslateIDReply();
        constTranslateIDReplyObj = objectFactoryConstSearch.createTranslateIDReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(ConstituentSearch.SearchReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(constTranslateIDReplyStr);
        constTranslateIDReplyObj = (ConstituentSearch.TranslateIDReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        String constituentName = constTranslateIDReplyObj.getTranslation();
        return constituentName;
    }
    
   public void getVendors() throws JAXBException, IOException{
        String constSearchRequestStr;
        String constSearchReplyStr;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/searchlists/23c5c603-d7d8-4106-aecc-65392b563887/soap.asmx";
        }
        
        ConstituentSearch.SearchRequest constSearchRequestObj = new ConstituentSearch.SearchRequest();
        ConstituentSearch.ObjectFactory objectFactoryConstSearch = new ConstituentSearch.ObjectFactory();
        constSearchRequestObj = objectFactoryConstSearch.createSearchRequest();
        System.out.println(jTextFieldVendor.getText());
        ConstituentSearch.SearchCriteria criteria = new ConstituentSearch.SearchCriteria();
        criteria.setKEYNAME(jTextFieldVendor.getText());
        criteria.setFUZZYSEARCHONNAME(true);
        constSearchRequestObj.setCriteria(criteria);
        constSearchRequestObj.setMaxRows(50);
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(ConstituentSearch.SearchRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(constSearchRequestObj, st); 
        constSearchRequestStr = st.toString();
        constSearchRequestStr = MessageAdjustments.fixSOAPRequestMessage(constSearchRequestStr);
        constSearchReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(constSearchRequestStr, urlString, useHttps);
        constSearchReplyStr = MessageAdjustments.stripSOAPReplyMessage(constSearchReplyStr);      
        ConstituentSearch.SearchReply constSearchReplyObj = new ConstituentSearch.SearchReply();
        constSearchReplyObj = objectFactoryConstSearch.createSearchReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(ConstituentSearch.SearchReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(constSearchReplyStr);
        constSearchReplyObj = (ConstituentSearch.SearchReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        
        tableModelConstituents.setRowCount(0);

        for (int i = 0; i < 50; i++){
            Vector v = new Vector();
            
            v.add(constSearchReplyObj.getRows().getListRow().get(i).getName());
            v.add(constSearchReplyObj.getRows().getListRow().get(i).getID());
            tableModelConstituents.addRow(v);
        } 
    }
   
    public void addExpense(String eventId) throws JAXBException, IOException{
        String expenseAddRequestStr;
        String expenseAddReplyStr;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/recordadds/f9c684ed-0c9d-4dc9-88b0-c9eb9e336e70/soap.asmx";
        }
        
        EventExpenseAddRecordOperation.SaveDataRequest expenseAddRequestObj = new EventExpenseAddRecordOperation.SaveDataRequest();
        EventExpenseAddRecordOperation.ObjectFactory objectFactoryEventExpenseAddOperation = new EventExpenseAddRecordOperation.ObjectFactory();
        expenseAddRequestObj = objectFactoryEventExpenseAddOperation.createSaveDataRequest();
        expenseAddRequestObj.setContextRecordID(eventId);
        expenseAddRequestObj.setUseValueTranslations(false);
        
        EventExpenseAddRecordOperation.RecordData expenseData = new EventExpenseAddRecordOperation.RecordData();               
        expenseData.setSELECTEDEVENTID(eventId);
        expenseData.setEVENTEXPENSETYPECODEID(jLabelTypeId.getText());
        expenseData.setVENDORID(jLabelVendorId.getText());
        BigDecimal budAmt = new BigDecimal(jFormattedTextFieldBudgetedAmount.getText());
        expenseData.setBUDGETEDAMOUNT(budAmt);
        BigDecimal amtPaid = new BigDecimal(jFormattedTextFieldAmountPaid.getText());
        expenseData.setAMOUNTPAID(amtPaid);
        //expenseData.setDATEDUE(null);
        //expenseData.setDATEPAID(null);
        expenseData.setCOMMENT(jTextAreaComment.getText());
        expenseAddRequestObj.setRecordData(expenseData);

        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseAddRecordOperation.SaveDataRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(expenseAddRequestObj, st);
        expenseAddRequestStr = st.toString();
        expenseAddRequestStr = MessageAdjustments.fixSOAPRequestMessage(expenseAddRequestStr);
        expenseAddReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(expenseAddRequestStr, urlString, useHttps);
        expenseAddReplyStr  = MessageAdjustments.stripSOAPReplyMessage(expenseAddReplyStr);      
        EventExpenseAddRecordOperation.SaveDataReply expenseAddReplyObj = new EventExpenseAddRecordOperation.SaveDataReply();
        expenseAddReplyObj = objectFactoryEventExpenseAddOperation.createSaveDataReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseAddRecordOperation.SaveDataReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(expenseAddReplyStr);
        expenseAddReplyObj = (EventExpenseAddRecordOperation.SaveDataReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        JOptionPane.showMessageDialog(this,expenseAddReplyObj.getStatusMessage().toString());
    }
    
    public void editExpense(EventExpenseEditRecordOperation.RecordData exDa, String exId) throws JAXBException, IOException{
        EventExpenseEditRecordOperation.RecordData expenseData = exDa;
        //Update the record
        String expenseEditRequestStr;
        String expenseEditReplyStr;
        
        String urlString = "";
        if (useHttps){
            urlString = "";
        }
        else{
            urlString = "http://localhost/bbAppFx/vpp/bizops/db%5B" + databaseToUse + "%5D/recordedits/7e655536-771c-4249-b366-0f647db170df/soap.asmx";
        }
        
        EventExpenseEditRecordOperation.SaveDataRequest expenseEditRequestObj = new EventExpenseEditRecordOperation.SaveDataRequest();
        EventExpenseEditRecordOperation.ObjectFactory objectFactoryEventExpenseEditOperation = new EventExpenseEditRecordOperation.ObjectFactory();
        expenseEditRequestObj = objectFactoryEventExpenseEditOperation.createSaveDataRequest();
        expenseEditRequestObj.setUseValueTranslations(false);
        
        
        expenseEditRequestObj.setRecordID(exId);
        BigDecimal budAmt = new BigDecimal(jFormattedTextFieldBudgetedAmount.getText());
        expenseData.setBUDGETEDAMOUNT(budAmt);
        BigDecimal amtPaid = new BigDecimal(jFormattedTextFieldAmountPaid.getText());
        expenseData.setAMOUNTPAID(amtPaid);
        expenseData.setCOMMENT(jTextAreaComment.getText());
        expenseData.setVENDORID(jLabelVendorId.getText());
        expenseData.setEVENTEXPENSETYPECODEID(jLabelTypeId.getText());
        expenseEditRequestObj.setRecordData(expenseData);
        
        JAXBContext contextForRequest = 
        JAXBContext.newInstance(EventExpenseEditRecordOperation.SaveDataRequest.class);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter st = new StringWriter(); 
        m.marshal(expenseEditRequestObj, st);
        expenseEditRequestStr = st.toString();
        expenseEditRequestStr = MessageAdjustments.fixSOAPRequestMessage(expenseEditRequestStr);
        expenseEditReplyStr = HttpURLConnectionTechnique.createHttpURLConnectionAndMakeRequest(expenseEditRequestStr, urlString, useHttps);
        expenseEditReplyStr  = MessageAdjustments.stripSOAPReplyMessage(expenseEditReplyStr);      
        EventExpenseEditRecordOperation.SaveDataReply expenseEditReplyObj = new EventExpenseEditRecordOperation.SaveDataReply();
        expenseEditReplyObj = objectFactoryEventExpenseEditOperation.createSaveDataReply();
        JAXBContext contextForReply = 
            JAXBContext.newInstance(EventExpenseEditRecordOperation.SaveDataReply.class);
        Unmarshaller u = contextForReply.createUnmarshaller();
        StringBuilder xmlStr = new StringBuilder(expenseEditReplyStr);
        expenseEditReplyObj = (EventExpenseEditRecordOperation.SaveDataReply) u.unmarshal(new StreamSource( new StringReader(xmlStr.toString())));
        JOptionPane.showMessageDialog(this,expenseEditReplyObj.getStatusMessage().toString());
    }
    
    
    /** Creates new form AddEditExpenseJFrame */
    public AddExpenseJFrame(String evId, String evName, String dbToUse) throws JAXBException, IOException {
        databaseToUse = dbToUse;
        initComponents();
        setConstituentsTableModelColumns();
        eventId = evId;
        eventName = evName;
        jFormattedTextFieldBudgetedAmount.setText(BigDecimal.ZERO.toString());
        jTextAreaComment.setText("");
        jFormattedTextFieldAmountPaid.setText(BigDecimal.ZERO.toString());
        jComboBoxType.setSelectedItem(jLabelVendorId);
        jLabelEventId.setText(eventId);
        jLabelEventName.setText(eventName);
        jTextFieldVendor.setText("");
        jLabelVendorId.setText("");
        typeList = loadExpenseTypeCodes();
        for (EventExpenseType.TableEntryListRow item : typeList){jComboBoxType.addItem(item.getDescription());};

        for (EventExpenseType.TableEntryListRow i : typeList) {
            if (i.getDescription().equals(jComboBoxType.getSelectedItem().toString())) {
                    System.out.println(i.getDescription());
                    //jLabelTypeId.setText(i.getId());
                }
            };
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldBudgetedAmount = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEventName = new javax.swing.JLabel();
        jLabelEventId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldAmountPaid = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComment = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVendor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();
        jButtonSaveExpense = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVendorSearch = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButtonSelect = new javax.swing.JButton();
        jLabelVendorId = new javax.swing.JLabel();
        jLabelTypeId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 0));

        jLabel1.setText("Budgeted Amount:");

        jFormattedTextFieldBudgetedAmount.setText("jFormattedTextField1");

        jLabel2.setText("Event Name:");

        jLabel3.setText("Event ID:");

        jLabelEventName.setText("jLabel6");

        jLabelEventId.setText("jLabel6");

        jLabel6.setText("Amount Paid:");

        jFormattedTextFieldAmountPaid.setText("jFormattedTextField1");

        jLabel7.setText("Comment:");

        jTextAreaComment.setColumns(20);
        jTextAreaComment.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComment);

        jLabel8.setText("Vendor:");

        jTextFieldVendor.setText("jTextField1");

        jLabel9.setText("Type:");

        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });

        jButtonSaveExpense.setText("Save");
        jButtonSaveExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveExpenseMouseClicked(evt);
            }
        });
        jButtonSaveExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveExpenseActionPerformed(evt);
            }
        });

        jTableVendorSearch.setModel(tableModelConstituents);
        jTableVendorSearch.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTableVendorSearch);

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel10.setText("Vendors");

        jButtonSelect.setText("Select");
        jButtonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSelectMouseClicked(evt);
            }
        });
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        jLabelVendorId.setText("jLabel11");

        jLabelTypeId.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEventId)
                            .addComponent(jLabelEventName)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSaveExpense)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxType, 0, 211, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVendor, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(jLabelVendorId)
                                    .addComponent(jLabelTypeId)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextFieldBudgetedAmount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldAmountPaid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(181, 181, 181)
                                .addComponent(jButtonSelect))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelEventName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelEventId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTypeId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(jButtonSearch))
                            .addComponent(jButtonSelect))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabelVendorId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jFormattedTextFieldAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextFieldBudgetedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                                .addComponent(jButtonSaveExpense))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonSaveExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveExpenseActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonSaveExpenseActionPerformed

private void jButtonSaveExpenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveExpenseMouseClicked
        try {
            // TODO add your handling code here:
                addExpense(eventId);
        } catch (JAXBException ex) {
            Logger.getLogger(AddExpenseJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExpenseJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButtonSaveExpenseMouseClicked

private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
            // TODO add your handling code here:
                getVendors();
        } catch (JAXBException ex) {
            Logger.getLogger(AddExpenseJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExpenseJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButtonSearchActionPerformed

private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButtonSelectActionPerformed

private void jButtonSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelectMouseClicked
// TODO add your handling code here:
    jLabelVendorId.setText(jTableVendorSearch.getValueAt(jTableVendorSearch.getSelectedRow(), 1).toString());
    jTextFieldVendor.setText(jTableVendorSearch.getValueAt(jTableVendorSearch.getSelectedRow(), 0).toString());
}//GEN-LAST:event_jButtonSelectMouseClicked

private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
// TODO add your handling code here:
    for (EventExpenseType.TableEntryListRow i : typeList) {
        if (i.getDescription().equals(jComboBoxType.getSelectedItem().toString())) {
            jLabelTypeId.setText(i.getID());
        }
    }
    
}//GEN-LAST:event_jComboBoxTypeActionPerformed

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
            java.util.logging.Logger.getLogger(AddExpenseJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddExpenseJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddExpenseJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddExpenseJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveExpense;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JFormattedTextField jFormattedTextFieldAmountPaid;
    private javax.swing.JFormattedTextField jFormattedTextFieldBudgetedAmount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEventId;
    private javax.swing.JLabel jLabelEventName;
    private javax.swing.JLabel jLabelTypeId;
    private javax.swing.JLabel jLabelVendorId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVendorSearch;
    private javax.swing.JTextArea jTextAreaComment;
    private javax.swing.JTextField jTextFieldVendor;
    // End of variables declaration//GEN-END:variables
}

package view;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import controller.Features;
import utils.Utils;

public class JStrategyView extends JPanel implements PanelView {

  private JLabel titleLabel;
  private JLabel portfolioLabel;
  private JTextField amountField;
  private JTextField intervalField;
  private JTextField startDateField;
  private JTextField endDateField;
  private JTextField commissionField;
  private JButton addButton;
  private JButton homeButton;
  private JLabel messageLabel;
  private JButton submitButton;
  private JComboBox<String> comboBox;
  private JTextField weightageField;

  private final Map<String, Double> weightsMap;

  public JStrategyView(String title) {
    this.setPreferredSize(new Dimension(500, 500));
    this.setLayout(new BorderLayout(8, 16));

    this.weightsMap = new HashMap<>();

    // North panel -> Title
    this.titleLabel = new JLabel(title);
    this.portfolioLabel = new JLabel("No portfolio Selected");

    JPanel northPanel = new JPanel();
    northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 8));
    northPanel.add(this.titleLabel);
    northPanel.add(this.portfolioLabel);
    this.add(northPanel, BorderLayout.NORTH);

    // Center panel -> Text input fields
    this.amountField = new JTextField("0.0", 6);
    this.intervalField = new JTextField("0", 4);
    this.startDateField = new JTextField(8);
    this.endDateField = new JTextField(8);
    this.commissionField = new JTextField("0.0", 6);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
    centerPanel.add(new JLabel("Amount: "));
    centerPanel.add(this.amountField);
    centerPanel.add(new JLabel("Interval (in days): "));
    centerPanel.add(this.intervalField);
    centerPanel.add(new JLabel("Start date (yyyy-mm-dd): "));
    centerPanel.add(this.startDateField);
    centerPanel.add(new JLabel("End date (yyyy-mm-dd): "));
    centerPanel.add(this.endDateField);
    centerPanel.add(new JLabel("Commission: "));
    centerPanel.add(this.commissionField);
    this.add(centerPanel, BorderLayout.CENTER);

    // South panel -> Stock weightage addition
    // ComboBox panel
    JPanel boxPanel = new JPanel();
    boxPanel.setBorder(BorderFactory.createTitledBorder("Stock Weightage"));
    boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.X_AXIS));

    // TODO: Remove
    Utils.loadValidStocks();
    String[] options = new String[Utils.VALID_STOCKS.size()];
    options = Utils.VALID_STOCKS.toArray(options);
    Arrays.sort(options);

    this.comboBox = new JComboBox<>();
    this.weightageField = new JTextField("0.0", 8);
    this.comboBox.addItem("--none--");
    for (String option : options) {
      this.comboBox.addItem(option);
    }
    boxPanel.add(this.comboBox);
    boxPanel.add(this.weightageField);

    this.homeButton = new JButton("HOME");
    this.addButton = new JButton("ADD");
    JPanel sectionPanel = new JPanel();
    sectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 16));
    sectionPanel.add(boxPanel);
    sectionPanel.add(this.addButton);
    sectionPanel.add(this.homeButton);

    this.messageLabel = new JLabel("<Message comes here>");
    this.messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.submitButton = new JButton("SUBMIT");
    this.submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel southPanel = new JPanel();
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
    southPanel.add(sectionPanel);
    southPanel.add(this.messageLabel);
    southPanel.add(new JLabel("      "));
    southPanel.add(this.submitButton);
    southPanel.add(new JLabel("      "));

    this.add(southPanel, BorderLayout.SOUTH);
  }

  @Override
  public void addActionListener(Features features) {
    addButton.addActionListener(event -> {
      // Reset the message
      this.messageLabel.setText("");
      // Get the selected stock name
      String stockName = (String) this.comboBox.getSelectedItem();
      // Parse stock name
      if (stockName.equals("--none--")) {
        this.messageLabel.setText("ERROR: Please select a stock!");
      }
      // Get the weightage quantity
      double weightage;

      // Parse weightage text
      try {
        weightage = Double.parseDouble(this.weightageField.getText());
        weightsMap.put(stockName,weightsMap.getOrDefault(stockName,0.0)+weightage);
      } catch (NumberFormatException nfe) {
        this.messageLabel.setText("ERROR: Invalid weightage!");
      }
    });

    submitButton.addActionListener(event ->{
      try{
        String status = features.addStrategy(Double.parseDouble(this.amountField.getText())
                ,Integer.parseInt(intervalField.getText())
                ,startDateField.getText(),endDateField.getText()
                ,Double.parseDouble(commissionField.getText())
                ,weightsMap);
        messageLabel.setText(status);
//        this.clearInput();
      }catch (Exception e){
        messageLabel.setText(e.getMessage());
      }
    });
  }

  public void setPortfolioName(String portfolioName) {
    portfolioLabel.setText(portfolioName);
  }

  @Override
  public void clearInput() {
    this.comboBox.setSelectedItem("--none--");
    this.weightageField.setText("");
    this.amountField.setText("");
    this.intervalField.setText("");
    this.startDateField.setText("");
    this.endDateField.setText("");
    this.commissionField.setText("");
  }
}

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import calculator.CalculatorLogic;
import calculator.Operand;

/**
 * This class represents the base frame of the Calculator GUI.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class Calculator extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;

  private JPanel mainPanel;
  private InputField inputField;
  private DisplayField displayField;
  private ButtonPanel buttonPanel;
  private CalculatorLogic logic;

  /**
   * Initializes the calculator to contain all of the required elements.
   */
  public Calculator()
  {
    // NOTE: If the evaluated expression returns an error, you should display ERROR and reset
    super ("unitED");

    this.mainPanel = new JPanel();
    this.inputField = new InputField();
    this.displayField = new DisplayField();
    this.buttonPanel = new ButtonPanel();
    this.logic = new CalculatorLogic();

    for (int i = 0; i < this.buttonPanel.getLength(); i++)
    {
      this.buttonPanel.getButtonsList(i).addActionListener(this);
    }
    
    BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(boxlayout);  
    mainPanel.add(displayField);
    mainPanel.add(inputField);
    mainPanel.add(buttonPanel);

    // add components to main panel
    add(mainPanel);

    // attributes of frame
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  }

  /**
   * Starts the calculator.
   */
  public void run()
  {
    setVisible(true);
  }

  /**
   * This method will clear the display of the calculator.
   */
  public void clear()
  {
    inputField.clear();
  }

  /**
   * Clears the saved result and the display.
   */
  public void reset()
  {
    clear();
    displayField.reset();
  }

  /**
   * Shows text on the display.
   * @param text
   */
  public void display(String text)
  {
    if (text == null) {
      text = "null";
    }
    
    displayField.setText(text);
  }

  // TODO: Handle button presses
  
//TODO -------------------------- Added this because I created action listeners here


@Override
public void actionPerformed(ActionEvent e)
{
  JButton btn = (JButton) e.getSource();
  String text = btn.getText();
  
  if ( text.equals( "R" ) ) {
    
    reset();
    
  } else if (text.equals( "C" )) {
    
    clear();
  } else if (text.equals( "\uFF0B" )) {
    
    String number = inputField.getText();
    displayField.addText(number + " + ");
    inputField.keepFocus();
    clear();
    
  } else if (text.equals( "\uFF0D" )) {
    
    String number = inputField.getText();
    displayField.addText(number + " - ");
    inputField.keepFocus();
    clear();
  } else if (text.equals( "\u00d7" )) {
    
    String number = inputField.getText();
    displayField.addText(number + " \u00d7 ");
    inputField.keepFocus();
    clear();
  } else if (text.equals( "\u00f7" )) {
    
    String number = inputField.getText();
    displayField.addText(number + " \u00f7 ");
    inputField.keepFocus();
    clear();
  } else if (text.equals( "=" )) {
    
    String expression = displayField.getText();
    String operand = logic.evaluate( expression + inputField.getText() ).toString();
    display(operand);
  }
  
}
}

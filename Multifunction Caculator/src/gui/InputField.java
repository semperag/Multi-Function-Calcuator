package gui;

import java.awt.ComponentOrientation;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class represents a GUI element used to input the current operand.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class InputField extends JPanel
{

  private static final long serialVersionUID = 1L;
  private JTextField inputField;

  /**
   * JTextField used for user input of the current operand.
   */
  public InputField() 
  {
    
    inputField = new JTextField(20);
    
    // attributes of input field
    inputField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
    // add display to panel for CalculatorFrame
    add(inputField);
  }
  
  public String getText() 
  {
    return inputField.getText();
  }
  
  public void addText(String operand) 
  {
    String text = inputField.getText() + " " + operand + " ";
    inputField.setText(text);
  }
  
  public void clear()
  {
    inputField.setText("");
  }
  
  public void keepFocus()
  {
    inputField.grabFocus();
  }
}

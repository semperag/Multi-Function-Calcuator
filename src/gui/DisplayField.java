package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class represents a GUI element used to display the results of calculations and the ongoing
 * calculations.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class DisplayField extends JPanel
{

  private static final long serialVersionUID = 1L;
  
  // TODO: May need to place this inside of a panel for formatting purposes.
  private JTextField display;

  public DisplayField() 
  {
    // TODO: Finish me.
    // NOTE: If the evaluated expression returns an error, your should display ERROR and reset
    
    display = new JTextField(20);
    
    // attributes of display
    display.setEditable(false);
    
    // add display to panel for CalculatorFrame
    add(display);
  }
  
  public void addText(String expression) 
  {
    String text = display.getText();
    display.setText(text + expression);
  }
  
  public void setText(String text) 
  {
    display.setText(text);
  }
  
  public String getText() 
  {
    return display.getText();
  }
  
  public void reset() {
    
    display.setText("");
  }
  
}

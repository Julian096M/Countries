//Julian Moreno 
//01/27/25
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() {
    File file = new File("/workspace/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
        scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine() && i < countryArray.length) {
            String input = scan.nextLine();
            String[] data = input.split(",");
            System.out.println("Read in " + data[0]);
            countryArray[i] = new Country(data[0], data[1], data[2], data[3]);
            i++;
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } finally {
        if (scan != null) {
            scan.close();
        }
    }
}
     

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  public void showCountry() {
    Country c = countryArray[index];
    String imagefile = c.getImageFile();
    img = new ImageIcon("/workspace/Countries/workspace/" + imagefile);
    imageLabel.setIcon(img);
  }
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  public void nextButtonClick() {
    index++;
    if (index >= countryArray.length) {
        index = 0; // Reinicia al primer país
    }
    outputLabel.setText(""); // Limpia el texto
    showCountry();
}
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  public void reviewButtonClick() {
    Country c = countryArray[index];
    String details = c.toString();
    outputLabel.setText(details); // Muestra los detalles del país
    System.out.println(details);
}
  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick() {
    outputLabel.setText(""); // Limpia el texto
    Scanner scan = new Scanner(System.in); // Crea el Scanner para leer entrada del usuario
    try {
        Country c = countryArray[index];
        System.out.println("What country is this?");
        String answer = scan.nextLine(); // Lee la respuesta del usuario
        if (answer.equalsIgnoreCase(c.getName())) {
            outputLabel.setText("Correct!");
        } else {
            outputLabel.setText("Incorrect. The correct answer is " + c.getName());
        }
    } finally {
        scan.close(); // Cierra el Scanner al final del método
    }
}

  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}

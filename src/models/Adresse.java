package models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Christof Weickhardt
 * Main Address Model to store address info and print or fill the object recusively
 */
public class Adresse {

  protected String name;
  protected String vorname;
  protected String strasse;
  protected int plz;
  protected String ortschaft;
  protected String email;
  protected ArrayList<String> telefonnummern;

  public Adresse(String name, String vorname, String strasse, int plz, String ortschaft) {
    this.name = name;
    this.vorname = vorname;
    this.strasse = strasse;
    this.plz = plz;
    this.ortschaft = ortschaft;
    this.telefonnummern = new ArrayList<>();
  }

  public Adresse() {
    this.telefonnummern = new ArrayList<>();
  }

  /**
   * Sets the email address
   *
   * @param email The email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * Adds a phone number to the array
   *
   * @param telefonnummer Phone number to set
   */
  public void addTelefonnummer(String telefonnummer) {
    this.telefonnummern.add(telefonnummer);
  }

  /**
   * Prints all the values of all the fields of that object
   */
  public void printToConsole() {
    for (Field field : this.getFields(this.getClass())) {
      try {
        System.out.println(field.getName() + "(" + field.getType().getSimpleName() + ")" + ": " + field.get(this));
      } catch (IllegalAccessException e) {
        System.out.println("Couldn't read object properties");
      }
    }
  }

  /**
   * Get all of the fields, asks the user to give a input for that field until every field has its proper value
   */
  public void readFromConsole() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> setFields = new ArrayList<>();
    for (Field field : getFields(this.getClass())) {
      System.out.println("Enter your " + field.getName() + ": ");
      while (true) {
        if (setFields.contains(field.getName())) break;
        try {
          String input = scanner.nextLine();
          if (field.getType().getSimpleName().equals("int")) {
            field.set(this, new Integer(input));
          } else if (field.getType().getSimpleName().equals("ArrayList")) {
            if (field.get(this) == null) {
              field.set(this, new ArrayList<String>());
            }
            ((ArrayList) field.get(this)).add(input);
          } else {
            field.set(this, input);
          }
          setFields.add(field.getName());
        } catch (Exception e) {
          System.out.println("Seems to be an invalid input, check if its a " + field.getType().getSimpleName());
        }
      }
    }
  }

  /**
   * Gets all the fields of the class specified and its super classes (recursive)
   *
   * @param clazz The class to get the fields of and its super class
   * @return Returns all the fields recursive
   */
  public ArrayList<Field> getFields(Class clazz) {
    ArrayList<Field> array = new ArrayList<Field>();
    if (clazz.getSuperclass() != null) {
      array.addAll(getFields(clazz.getSuperclass()));
    }
    array.addAll(Arrays.asList(clazz.getDeclaredFields()));
    return array;
  }

}

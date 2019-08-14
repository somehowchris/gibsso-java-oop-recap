package models;

/**
 * @author Christof Weickhardt
 * An extended address class to store private data
 */
public class PrivateAdresse extends Adresse {

  protected String thema;

  public PrivateAdresse(String name, String vorname, String strasse, int plz, String ortschaft) {
    super(name, vorname, strasse, plz, ortschaft);
  }

  public PrivateAdresse() {
    super();
  }

  /**
   * @param thema The Thema to set
   */
  public void setThema(String thema) {
    this.thema = thema;
  }

}

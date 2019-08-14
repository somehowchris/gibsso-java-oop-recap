package models;

/**
 * @author Christof Weickhardt
 * An extended address class to store company data
 */
public class GeschaeftsAdresse extends Adresse {

  String firma;
  String website;

  public GeschaeftsAdresse(String name, String vorname, String strasse, int plz, String ortschaft, String firma) {
    super(name, vorname, strasse, plz, ortschaft);
    this.firma = firma;
  }

  public GeschaeftsAdresse() {
    super();
  }


  /**
   * Sets the website
   *
   * @param website The website to set
   */
  public void setWebsite(String website) {
    this.website = website;
  }
}

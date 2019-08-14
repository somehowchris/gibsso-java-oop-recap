import models.Adresse;
import models.GeschaeftsAdresse;
import models.PrivateAdresse;

/**
 * @author Christof Weickhardt
 * Main class to initialize everything, testing if both extended classes work properly
 */
public class Main {

  /**
   * Well hell yeah. hit it.
   * @param args Params for java
   */
  public static void main(String[] args) {
    System.out.println("Testing GeschaeftsAdresse");
    testAddress(new GeschaeftsAdresse());
    System.out.println("");
    System.out.println("Testing PrivateAdresse");
    testAddress(new PrivateAdresse());
  }

  /**
   * Just a bit more generic to have some lines killed. Tests a generic address input and output
   *
   * @param address Address object to fill and print out
   */
  public static void testAddress(Adresse address) {
    address.readFromConsole();
    address.printToConsole();
  }
}

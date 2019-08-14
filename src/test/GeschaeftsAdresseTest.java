package test;

import models.GeschaeftsAdresse;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeschaeftsAdresseTest {

  GeschaeftsAdresse address = new GeschaeftsAdresse();

  @Test()
  public void outputTest() {
    address.printToConsole();
  }

  @Test()
  public void inputTest() throws IllegalAccessException {
    address.readFromConsole();
    for (Field field : address.getFields(address.getClass())) assertNotNull(field.get(address));
  }

}

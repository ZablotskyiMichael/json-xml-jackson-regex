package parsers;

import model.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SAXParserDemo {

  public static void main(String[] args) throws Exception {
    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    SAXParser parser = parserFactor.newSAXParser();
    SAXHandler handler = new SAXHandler();
    parser.parse(ClassLoader.getSystemResourceAsStream("employees.xml"), handler);

    //Printing the list of employees obtained from XML
    for (Employee emp : handler.empList) {
      System.out.println(emp);
    }
  }
}

/**
 * The Handler for SAX Events.
 */
class SAXHandler extends DefaultHandler {

  List<Employee> empList = new ArrayList<>();
  Employee emp = null;
  String content = null;

  @Override
  //Triggered when the start of tag is found.
  public void startElement(String uri, String localName,
                           String qName, Attributes attributes) {

    switch (qName) {
      //Create a new Employee object when the start tag is found
      case "employee" -> {
        emp = new Employee();
        emp.id = attributes.getValue("id");
      }
    }
  }

  @Override
  public void endElement(String uri, String localName,
                         String qName) {
    switch (qName) {
      //Add the employee to list once end tag is found
      case "employee" -> empList.add(emp);

      //For all other end tags the employee has to be updated.
      case "firstName" -> emp.firstName = content;
      case "lastName" -> emp.lastName = content;
      case "location" -> emp.location = content;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    content = String.copyValueOf(ch, start, length).trim();
  }

}


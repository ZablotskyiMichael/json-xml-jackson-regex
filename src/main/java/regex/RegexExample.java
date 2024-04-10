package regex;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
  public static void main(String[] args) {
    example1();
    example2();
    example3();
  }

  private static void example1 () {
    Pattern digitsPattern = Pattern.compile("\\+380\\d{9}");
    Matcher matcher = digitsPattern.matcher("+380685552244");
    System.out.println("Matches:" + matcher.matches());
  }


  private static void example2 () {
    List<String> log = List.of(
        "В групі A-1 знайдено 20 студентів",
        "В групі A-2 знайдено 22 студентів",
        "В групі B-1 знайдено 30 студентів");

    Pattern logPattern = Pattern.compile(
        "В групі (\\S+) знайдено (\\d+) студентів");

    for (String logItem : log) {
      Matcher matcher = logPattern.matcher(logItem);
      if (matcher.matches()) {
        String group =  matcher.group(1);
        String count = matcher.group(2);
        System.out.println(group + ": " + count);
      }
    }

  }

  private static void example3 () {
    List<String> transactionAttributes = List.of(
        "from='John Smith'",
        " to = 'Jane Smith'",
        "sum =  '1000$' ",
        " comment = ''");

    Pattern attributePattern =
        Pattern.compile("\\s*(\\S+)\\s*=\\s*'([^']*)'\\s*");

    for (String logItem : transactionAttributes) {
      Matcher matcher = attributePattern.matcher(logItem);
      if (matcher.matches()) {
        String group = matcher.group(1);
        String count = matcher.group(2);
        System.out.println(group + ": \"" + count + "\"");
      }
    }

  }
}

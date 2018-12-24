package java8.regex;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageFormatEx {
  public static void main(String args[]) throws Exception {
    String raw = "${param1}K was deleted on ${param2}.";
    Pattern pattern = Pattern.compile("\\{.*?\\}");
    Matcher matcher = pattern.matcher(raw);
    List<String> list= new ArrayList<String>();
    while (matcher.find())
    {
        int start = matcher.start();
        int end = matcher.end();
        String template = raw.substring(start + 1, end - 1); // + 1 and - 1 to cut off the { and }
        list.add(template);
    }
    System.out.println(list);
  }
}

package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextDumperTest {

  @Test
  public void textDumperWritesCustomerName() throws IOException {
    StringWriter writer = new StringWriter();
    TextDumper dumper =  new TextDumper(writer);

    String customerName = "Customer";
    PhoneBill bill = new PhoneBill(customerName);

    dumper.dump(bill);

    String text = writer.toString();
    assertThat(text, containsString(customerName));

  }
}

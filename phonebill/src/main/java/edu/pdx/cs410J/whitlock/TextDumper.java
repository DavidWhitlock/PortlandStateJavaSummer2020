package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.IOException;
import java.io.Writer;

public class TextDumper implements PhoneBillDumper<PhoneBill> {
  private final Writer writer;

  public TextDumper(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void dump(PhoneBill bill) throws IOException {
    this.writer.append(bill.getCustomer());
  }
}

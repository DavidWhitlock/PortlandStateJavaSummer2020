package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.PrintWriter;

public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {
  private final PrintWriter pw;

  public PrettyPrinter(PrintWriter pw) {
    this.pw = pw;
  }

  @Override
  public void dump(PhoneBill bill) {
    this.pw.println(bill.getCustomer());
    for (PhoneCall call : bill.getPhoneCalls()) {
      this.pw.println(call.toString());
    }
    this.pw.flush();
  }
}

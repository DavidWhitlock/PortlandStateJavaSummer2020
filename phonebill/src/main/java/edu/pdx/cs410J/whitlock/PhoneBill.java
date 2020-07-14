package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private final String customerName;

  public PhoneBill(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public String getCustomer() {
    return this.customerName;
  }

  @Override
  public void addPhoneCall(PhoneCall call) {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }
}

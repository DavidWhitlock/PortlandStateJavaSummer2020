package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
  @Override
  public String getCaller() {
    return "From";
  }

  @Override
  public String getCallee() {
    return "To";
  }

  @Override
  public String getStartTimeString() {
    return "Then";
  }

  @Override
  public String getEndTimeString() {
    return "Now";
  }
}

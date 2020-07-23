package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
  private final String caller;

  public PhoneCall(String caller) {
    this.caller = caller;
  }

  @Override
  public String getCaller() {
    return this.caller;
  }

  @Override
  public String getCallee() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getStartTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getEndTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }
}

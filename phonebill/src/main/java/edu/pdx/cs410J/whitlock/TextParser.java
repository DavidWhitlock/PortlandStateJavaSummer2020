package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class TextParser implements PhoneBillParser<PhoneBill> {
  private final Reader reader;

  TextParser(Reader reader) {
    this.reader = reader;
  }

  @Override
  public PhoneBill parse() throws ParserException {
    BufferedReader br = new BufferedReader(this.reader);

    try {
      String customerName = br.readLine();
      return new PhoneBill(customerName);

    } catch (IOException e) {
      throw new ParserException("While parsing text", e);
    }
  }
}

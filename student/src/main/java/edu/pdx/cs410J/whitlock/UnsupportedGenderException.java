package edu.pdx.cs410J.whitlock;

class UnsupportedGenderException extends RuntimeException {
  UnsupportedGenderException(String genderString) {
    super(genderString);
  }
}

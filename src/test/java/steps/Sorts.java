package steps;

public enum Sorts {
  по_умолчанию("101"),
  дешевле("1"),
  дороже("2"),
  по_дате("104");

  public String value;

  public String getValue() {
    return value;
  }

  Sorts(String value) {
    this.value = value;
  }
}

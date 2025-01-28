//Julian Moreno 
//01/27/25
public class Country {
  // Variables privadas
  private String name;
  private String capital;
  private String language;
  private String imageFile;

  // Constructor por defecto
  public Country() {
      this.name = "";
      this.capital = "";
      this.language = "";
      this.imageFile = "";
  }

  // Constructor con 4 argumentos
  public Country(String name, String capital, String language, String imageFile) {
      this.name = name;
      this.capital = capital;
      this.language = language;
      this.imageFile = imageFile;
  }

  // Métodos get
  public String getName() {
      return name;
  }

  public String getCapital() {
      return capital;
  }

  public String getLanguage() {
      return language;
  }

  public String getImageFile() {
      return imageFile;
  }

  // Método toString
  @Override
  public String toString() {
      return name + "'s capital is " + capital + " and its primary language is " + language + ".";
  }
}
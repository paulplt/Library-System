public class Author {
    String full_name;
    int birth_year;
    String nationality;

    public Author(String full_name, int birth_year, String nationality) {
        this.full_name = full_name;
        this.birth_year = birth_year;
        this.nationality = nationality;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

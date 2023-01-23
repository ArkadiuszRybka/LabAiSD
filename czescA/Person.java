package czescA;

public class Person {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Person(){
        imie="";
        nazwisko="";
        wiek=0;
    }

    public Person(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    public int compareTo(Person p) {
        if(this.getWiek()<p.getWiek()) return -1;
        else if (this.getWiek()>p.getWiek()) return 1;
        else if (this.getWiek()==p.getWiek() && this.getNazwisko().compareTo(p.getNazwisko())!=0) return this.getNazwisko().compareTo(p.getNazwisko());
        else if(this.getWiek()==p.getWiek()&& this.getNazwisko().compareTo(p.getNazwisko())==0)  return this.getImie().compareTo(p.getImie());
        return 0;
    }
}

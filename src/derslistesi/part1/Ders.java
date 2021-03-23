package derslistesi.part1;

public class Ders {
    String dersAdi;
    String dersKodu;
    int somestrNo;
    private static int count = 0;
    private int ID;
    Ders next;


    public Ders(String dersAdi, String dersKodu, int somestrNo ) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.somestrNo = somestrNo;
        setID(++count);
        this.next = null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Ders adı :'" + dersAdi + '\'' +
                ", Ders kodu: '" + dersKodu + '\'' +
                ", Sömestr no : " + somestrNo ;

    }
}

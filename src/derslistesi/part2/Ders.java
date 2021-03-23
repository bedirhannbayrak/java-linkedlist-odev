package derslistesi.part2;

public class Ders {
    String dersAdi;
    String dersKodu;
    int somestrNo;
    private static int count = 0;
    private int ID;
    derslistesi.part1.Ders next;


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
        return "Ders ID : '" + getID() + '\'' +
                " , Ders adı :'" + dersAdi + '\'' +
                ", Ders kodu: '" + dersKodu + '\'' +
                ", Sömestr no : " + somestrNo ;

    }
}

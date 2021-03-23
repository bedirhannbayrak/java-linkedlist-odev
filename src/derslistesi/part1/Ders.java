package derslistesi.part1;

/**
 * Ders adı, ders kodu, sömestr numarası ve ders ID'lerinden oluşan bir sınıf yaratıldı
 * Her sınıf üyesine otomatik olarak ID ataması yapılması için static bir sayaç eklendi.
 * ID için get ve set metodları oluşturuldu.
 */
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
        return "Ders ID : '" + getID() + '\'' +
                " , Ders adı :'" + dersAdi + '\'' +
                ", Ders kodu: '" + dersKodu + '\'' +
                ", Sömestr no : " + somestrNo ;

    }
}

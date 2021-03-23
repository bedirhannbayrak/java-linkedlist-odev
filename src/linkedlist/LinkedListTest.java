package linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println("basa ekle");
        linkedList.basaEkle(2);
        linkedList.listeyiYazdir();
        System.out.println("bastan sil");
        linkedList.bastanSil();
        linkedList.listeyiYazdir();
        System.out.println("basa ekle");
        linkedList.basaEkle(3);
        linkedList.basaEkle(52);
        linkedList.basaEkle(2124);
        linkedList.listeyiYazdir();
        System.out.println("sona ekle");
        linkedList.sonaEkle(98);
        System.out.println();
        linkedList.listeyiYazdir();
        System.out.println("indekse ekle 60");
        linkedList.indekseEkle(45,60);
        System.out.println();
        linkedList.listeyiYazdir();
        System.out.println("indekse ekle 0");
        linkedList.indekseEkle(225,0);
        linkedList.listeyiYazdir();
        System.out.println("indekse ekle -1");
        linkedList.indekseEkle(-1,-1);
        System.out.println();
        linkedList.listeyiYazdir();
        System.out.println("indekse ekle 3");
        linkedList.indekseEkle(300,3);
        System.out.println();
        linkedList.listeyiYazdir();
        System.out.println("sondan sil");
        linkedList.sondanSil();
        linkedList.listeyiYazdir();
        System.out.println("indeks sil 0");
        linkedList.indekstenSil(0);
        linkedList.listeyiYazdir();
        System.out.println("indeks sil 2");
        linkedList.indekstenSil(2);
        linkedList.listeyiYazdir();
        System.out.println("indeks sil 15");
        linkedList.indekstenSil(15);
        linkedList.listeyiYazdir();


    }
}

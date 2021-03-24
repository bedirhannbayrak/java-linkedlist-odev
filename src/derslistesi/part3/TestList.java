package derslistesi.part3;

public class TestList {

    public static DersListesi dersListesi;

    public static void main(String[] args) {

        dersListesi = new DersListesi();

        dersleriEkle();
       /* dersListesi.listeyiYazdir();
        dersListesi.listSemesterCourses(4);
        dersListesi.size();
        dersListesi.dersSilByDersKodu("YDI2025");
        dersListesi.next(3);
        dersListesi.getByCode("BLMxxx");
        dersListesi.dersSilByDersID(2);
        dersListesi.listeyiYazdir();
        dersListesi.getByRange(37,45);*/
        //dersListesi.listeyiYazdir();
        /*dersListesi.linkSomestr(1);
        dersListesi.linkSomestr(2);
        dersListesi.linkSomestr(3);
        dersListesi.linkSomestr(4);
        dersListesi.linkSomestr(5);
        dersListesi.linkSomestr(6);
        dersListesi.linkSomestr(7);*/
        dersListesi.linkSomestr(8);
        dersListesi.listeyiYazdir();
        System.out.println(dersListesi.bas.nextSomestr.nextSomestr);
    }

    /**
     * main fonksiyonu içersinde kod kirliliği olmaması için tüm dersleri ekleyen fonksiyon
     */
    public static void dersleriEkle(){
        dersListesi = new DersListesi();
        dersListesi.sonaEkle("Bilgisayar Mühendisliğine Giriş" , "BLM1001" , 1);
        dersListesi.sonaEkle("Bilgisayar Programlama I " , "BLM1002" , 2);
        dersListesi.sonaEkle("Fizik I" , "FZK1071" , 1);
        dersListesi.sonaEkle("Kimya" , "KMY1020" , 1);
        dersListesi.sonaEkle("Matematik I " , "MAT1085" , 1);
        dersListesi.sonaEkle("Lineer Cebir " , "MAT1087" , 1);
        dersListesi.sonaEkle("Türk Dili I " , "TRD121" , 1);
        dersListesi.sonaEkle("Yabancı Dil I " , "YDZx121" , 1);
        dersListesi.sonaEkle("Algoritma ve Programlamaya Giriş","BLM1003",1);
        dersListesi.sonaEkle("Bilgisayar Donanımı" , "BLM1004" , 2);
        dersListesi.sonaEkle("Fizik II " , "FZK1072" , 1);
        dersListesi.sonaEkle("Matematik II","MAT1086",2);
        dersListesi.sonaEkle("İş Sağlığı ve Güvenliği","ISG1081",2);
        dersListesi.sonaEkle("Bilgisayar Programlama II ","BLM2001",3);
        dersListesi.sonaEkle("İnsan-Bilgisayar Etkileşimi ve Görsellik ","BLM2003",3);
        dersListesi.sonaEkle("Nesne Yönelimli Programlama ","BLM2005",3);
        dersListesi.sonaEkle("Ayrık Matematik ","MAT2019",3);
        dersListesi.sonaEkle("Veri Yapıları ve Algoritmalar","BLM2002",4);
        dersListesi.sonaEkle("Mühendisler için İstatistik","IST3045",4);
        dersListesi.sonaEkle("Mikroişlemciler ","BLM2008",4);
        dersListesi.sonaEkle("Veritabanı Yönetim Sistemleri " , "BLM3001" , 5);
        dersListesi.sonaEkle("İşletim Sistemleri " , "BLM3003" , 5);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 3 " , "BLMxxx" , 5);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 1 " , "BLMxxx" , 5);
        dersListesi.sonaEkle("Mikrodenetleyiciler " , "BLM3007" , 5);
        dersListesi.sonaEkle("Sinyaller ve Sistemlere Giriş" , "BLM3005" , 5);
        dersListesi.sonaEkle("Bilgisayar Organizasyonu ve Mimarisi", "BLM3004",6);
        dersListesi.sonaEkle("Web Programlama", "BLM3006",6);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 4 ", "BLMxxx",6);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 5", "BLMxxx",6);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 6 ", "BLMxxx",6);
        dersListesi.sonaEkle("Staj II ", "BLM4000",7);
        dersListesi.sonaEkle("İş Yeri Eğitimi ", "BLM4001",7);
        dersListesi.sonaEkle("Atatürk İlkeleri ve İnkılap Tarihi I ", "ATA121",7);
        dersListesi.sonaEkle("Sistem ve Sunucu Yönetimi", "BLM4002",8);
        dersListesi.sonaEkle("Bitirme Projesi ", "BLM4098",8);
        dersListesi.sonaEkle("Üniversite Seçimlik Ders", "T F-USD",8);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 7 ", "BLMxxx",8);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 8 ", "BLMxxx",8);
        dersListesi.sonaEkle("Teknik Seçimlik Ders - 9 ", "BLMxxx",8);
        dersListesi.sonaEkle("Atatürk İlkeleri ve İnkılap Tarihi II ", "ATA122",8);
        dersListesi.sonaEkle("Teknik İngilizce", "YDI2025",8);
    }
}

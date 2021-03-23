package linkedlist;

public class LinkedList {
    Eleman bas;
    Eleman son;


    public LinkedList() {
        bas = null;
        son = null;
    }


    public void basaEkle(int sayi) {
        Eleman yeniEleman = new Eleman(sayi);
        if(doluMu()) {
            // liste dolu
            yeniEleman.siradaki = bas;
            bas = yeniEleman;

        } else {
            // liste boş
           bas = yeniEleman;
           son = yeniEleman;
        }
    }

    public void sonaEkle(int sayi) {
        Eleman yeniEleman = new Eleman(sayi);
        if(doluMu()) {

            son.siradaki = yeniEleman;
            son = yeniEleman;


        } else {
            // liste boş
            bas = yeniEleman;
            son = yeniEleman;
        }
    }

    public void bastanSil() {
        if (doluMu()) {
            if (bas == son) {
                bas = null;
                son = null;
            } else{
                Eleman yeniBas = bas.siradaki;
                bas.siradaki = null;
                bas = yeniBas;
            }
        }




    }

    public void sondanSil() {
        if(doluMu()) {
            if (bas == son) {
                bas=null;
                son=null;
            } else{
                Eleman isaretci = bas;
                while (isaretci.siradaki!=son) {
                    isaretci=isaretci.siradaki;
                }
                isaretci.siradaki=null;
                son=isaretci;


            }

        }
    }

    public boolean doluMu() {
        return bas != null;
    }

    public void listeyiYazdir() {
         Eleman isaretci = bas;
         int count = 0;
         while(isaretci!=null){
             System.out.print(isaretci.sayi + " ");
             isaretci=isaretci.siradaki;
             count++;
         }
        System.out.println();
        System.out.println("toplam eleman sayısı " + count);
    }

    public void indekseEkle(int sayi, int index) {

        Eleman yeniEleman = new Eleman(sayi);

        if(doluMu()) {
            if (index<=0) {
                // başa eklemekle aynı
                yeniEleman.siradaki = bas;
                bas = yeniEleman;
            } else {
                //orta bir yere ekliyoruz
                Eleman isaretci1 = null;
                Eleman isaretci2 = bas;
                int mevcutIndeks = 0 ;
                while(isaretci2!=null && (mevcutIndeks < index)){
                    isaretci1=isaretci2;
                    isaretci2=isaretci2.siradaki;

                    mevcutIndeks++;
                }
                if(isaretci2==null ){
                    //son elemana eklemeyle aynı
                    son.siradaki=yeniEleman;
                    son=yeniEleman;
                } else {
                    yeniEleman.siradaki=isaretci2;
                    isaretci1.siradaki=yeniEleman;
                }
            }
        } else {
            bas = yeniEleman;
            son = yeniEleman;
        }

    }

    public void indekstenSil(int indeks) {
        if (doluMu()) {
            if (bas ==son ) {
                //tek eleman var
                bas = null;
                son = null;
            }else {
                //en az iki eleman var
                if (indeks == 0 ) {
                    //baştakini sil
                    Eleman yeniBas = bas.siradaki;
                    bas.siradaki = null;
                    bas = yeniBas;
                } else {
                    //sildiğimiz eleman başta değil
                    Eleman isaretci1 = null;
                    Eleman isaretci2 = bas;
                    int mevcutIndeks = 0;
                    while(isaretci2!=null && mevcutIndeks < indeks){
                        isaretci1 = isaretci2;
                        isaretci2 =isaretci2.siradaki;
                        mevcutIndeks++;
                    } if (isaretci2!=null) {
                        if (isaretci2==son ){
                            son = isaretci1;
                            isaretci1.siradaki=null;
                        }else {
                            //ortadan silmee
                            Eleman isaretc3 = isaretci2.siradaki;
                            isaretci2.siradaki = null;
                            isaretci1.siradaki=isaretc3;
                        }
                    }


                }
            }
        }
    }

   /* public void verilenDegSil(int sayi) {
        Eleman isaretci = bas;
        int sayac = 0;
        while (bas != sayi) {
            isaretci = isaretci.siradaki;
        }
    }

*/

}

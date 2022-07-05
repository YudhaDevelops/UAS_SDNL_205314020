package uas_sdnl_205314020;
public class UAS_SDNL_205314020 {
    public static void main(String[] args) {
        Tree phn = new Tree();

        int[] a = {75, 30, 20, 65, 89, 80, 90};
        for (int i= 0; i < a.length ; i++){
            phn.insert(a[i]);
        }

        //nomor 1a
        //Insertkan sebuah data dengan NIM 3 DIGIT TERAKHIR ANDA 
        //(Jika digit depan 0 maka digit 0 dihilangkan).
        //NIM 205314020
        phn.insert(20);
        
        System.out.println("");
        System.out.println("Pre-Order  : ");
        phn.preorderTraversal();
        System.out.println("");
        
        System.out.println("\nIn-Order   : ");
        phn.inOrderTraversal();
        System.out.println("");
        
        System.out.println("\nPost-Order : ");
        phn.postOrderTraversal();
        System.out.println("");
        
        //nomor 1b
        //Cara untuk menghapus node 75 adalah dengan menggunakan method successor 
        //atau method predecessor. Berdasarkan hasil soal 1a :
        
        //ii.Khusus NIM GENAP : 
        //Buatlah method predeccessor yang berfungsi untuk 
        //menampilkan node predeccessor beserta node-node yang dilaluinya. 
        //Contoh: node yang akan di hapus adalah 75, 
        //maka node predeccessor adalah 65 serta node yang dilalui yaitu 75, 30 dan 65.
        System.out.println("\nDelete : 75");
        phn.delete(75);
        System.out.println("\nNode yang dilalui yaitu : "+ phn.getDataPredeccessor());
        System.out.println("");
        
        //nomor 1c
        //Berdasarkan hasil soal 1a tampilkan hasil transversal pre-order, in-order dan post-order.
        System.out.println("");
        System.out.println("Pre-Order  : ");
        phn.preorderTraversal();
        System.out.println("");
        
        System.out.println("\nIn-Order   : ");
        phn.inOrderTraversal();
        System.out.println("");
        
        System.out.println("\nPost-Order : ");
        phn.postOrderTraversal();
        System.out.println("");
    }    
}

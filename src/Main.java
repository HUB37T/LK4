import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();
        Buku b1 = new Buku("A","Hubert","2025");
        Buku b2 = new Buku("B","Orie","2024");
        Buku b3 = new Buku("C","Adit","2023");
        Buku b4 = new Buku("D","Fahry","2022");

        perpustakaan.tambahBuku(b1);
        perpustakaan.tambahBuku(b2);
        perpustakaan.tambahBuku(b3);
        perpustakaan.tambahBuku(b4);

        System.out.print("Masukkan Jumlah Peminjam: ");
        int x = input.nextInt();
        input.nextLine();
        Anggota a[] = new Anggota[x];
        for (int i = 0; i < x; i++) {
            System.out.print("Masukkan Nama Peminjam: ");
            String nama = input.nextLine();
            System.out.print("Masukkan ID Peminjam: ");
            String id = input.nextLine();
            a[i] = new Anggota(nama, id);
            perpustakaan.tambahAnggota(a[i]);
        }
        for (int i = 0; i < x; i++) {
            System.out.print("Masukkan Judul Buku yang ingin Dipinjam untuk anggota dengan id "+a[i].getIdAnggota()+" : ");
            String judul = input.nextLine();
            try{
                perpustakaan.pinjamBuku(a[i].getIdAnggota(), judul);
                System.out.println("Buku berhasil dipinjam!");
            }
            catch(Exception e){
                System.out.println("Terdapat Kesalahan: " + e.getMessage());
                return;
            }
        }
        System.out.println("Apakah ingin mengembalikan buku? Y/N");
        String tes = input.nextLine();
        if(tes.equalsIgnoreCase("y")){
            try{
            System.out.print("Masukkan ID Peminjam: ");
            String id = input.nextLine();
            System.out.print("Masukkan judul Buku yang ingin Dikembalikan: ");
            String judul = input.next();
            perpustakaan.kembaliBuku(id, judul);
            System.out.println("Buku berhasil dikembalikan!");
            }
            catch(Exception e){
                System.out.println("Terdapat Kesalahan: " + e.getMessage());
            }
            finally {
                System.out.println("Terima Kasih!");
            }
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Perpustakaan {
    private List <Buku> daftarBuku = new ArrayList<>();
    private Map <String, Anggota> daftarAnggota = new HashMap<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }
    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.put(anggota.getIdAnggota(), anggota);
    }
    public void pinjamBuku(String idAnggota, String judul) throws Exception{
        if(!daftarAnggota.containsKey(idAnggota)) {
            throw new AnggotaTidakDitemukanException("Anggota tidak ditemukan!");
        }
        boolean ada = false;
        for(Buku buku : daftarBuku) {
            if(buku.getJudul().equalsIgnoreCase(judul)) {
                ada = true;
                buku.pinjamBuku(daftarAnggota.get(idAnggota).getNama());
                return;
            }
        }
        if(!ada){
            throw new BukuTidakTersediaException("Buku tidak tersedia!");
        }
    }

    public void kembaliBuku(String idAnggota, String judul) throws Exception {
        if(!daftarAnggota.containsKey(idAnggota)) {
            throw new AnggotaTidakDitemukanException("Anggota tidak ditemukan!");
        }
        for(Buku buku : daftarBuku) {
            if(buku.getJudul().equals(judul) && daftarAnggota.containsKey(idAnggota)) {
                buku.kembaliBuku();
                return;
            }
            else{
                throw new BukuTidakTersediaException("Buku tidak sesuai!");
            }
        }
        throw new BukuTidakDipinjamException("Buku tidak dipinjam!");
    }
}
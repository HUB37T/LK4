public class Buku {
    private String judul;
    private String penulis;
    private String thn;
    private boolean tersedia = true;
    private String peminjam;
    public Buku(String judul, String penulis, String tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.thn = tahunTerbit;
    }
    public String getJudul() {
        return judul;
    }
    public String getPenulis() {
        return penulis;
    }
    public String getThn() {
        return thn;
    }
    public boolean isTersedia() {
        return tersedia;
    }
    public void pinjamBuku(String nama) throws BukuTidakTersediaException{
        if(!tersedia){
            throw new BukuTidakTersediaException("Buku " + judul + " tidak tersedia");
        }
        tersedia = false;
        this.peminjam = nama;
    }
    public void kembaliBuku() throws BukuTidakDipinjamException {
        if (tersedia) {
            throw new BukuTidakDipinjamException("Buku " + judul + " belum pernah dipinjam.");
        }
        tersedia = true;
        peminjam = null;
    }
}

class BukuTidakTersediaException extends Exception {
    public BukuTidakTersediaException(String message) {
        super(message);
    }
}

class BukuTidakDipinjamException extends Exception {
    public BukuTidakDipinjamException(String message) {
        super(message);
    }
}

class AnggotaTidakDitemukanException extends Exception {
    public AnggotaTidakDitemukanException(String message) {
        super(message);
    }
}

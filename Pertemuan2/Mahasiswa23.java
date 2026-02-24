public class Mahasiswa23 {
    String nama;
    String nim;
    String kelas;
    double ipk;

    void tampilkanInformasi(){
        System.out.println("Nama: " + nama);
        System.out.println("Nim: " + nim);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK: " + ipk);
    }
    void ubahKelas(String kelasBaru){
        kelas = kelasBaru;
    }
    void updateIPK(double ipkBaru){
        if ( ipk < 0.0 || ipk > 4.0){
            System.out.println("Nilai tidak valid");
            return;
        } else{
            ipk = ipkBaru;
        }
        
    }
    String nilaiKinerja(){
        if (ipk >= 3.5){
            return "Kinerja sangat baik";
        }else if(ipk >= 3.0){
            return "Kinerja baik";
        }else if(ipk >= 2.0){
            return "Kinerja cukup";
        }else{
            return "Kinerja buruk";
        }
    }

    public Mahasiswa23(){

    }

    public Mahasiswa23(String nm, String nim, double ipk, String kls){
        nama = nm;
        this.nim = nim;
        this.ipk = ipk;
        kelas = kls;
    }
    public static void main(String[] args) {

        
    }
}
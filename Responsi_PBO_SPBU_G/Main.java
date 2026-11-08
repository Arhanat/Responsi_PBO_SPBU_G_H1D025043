// 6. Class Main (Pengujian Seluruh Persyaratan Teknis)
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SIMULASI SISTEM SPBU (RESPONSI AKHIR PBO)");
        System.out.println("==================================================\n");

        // --- 1. Testing Polimorfisme Interface & Overloaded Constructor ---
        System.out.println(">>> 1. Inisialisasi Objek & Polimorfisme Interface");
        Operasional bbmSubsidi = new BahanBakarSubsidi("BBM-01", "Pertalite", 10000, 200.0, 20.0);
        BahanBakarNonSubsidi bbmNonSubsidi = new BahanBakarNonSubsidi("BBM-02", "Pertamax", 13500, 500.0);

        // --- 2. Testing Transaksi Subsidi (Logika State Percabangan) ---
        System.out.println("\n>>> 2. Pengujian BBM Subsidi");
        // Uji transaksi 1: Melebihi kuota (Harus Gagal)
        bbmSubsidi.isiBahanBakar(25.0);

        // Uji transaksi 2: Sesuai kuota (Harus Sukses)
        bbmSubsidi.isiBahanBakar(15.0);

        // --- 3. Testing Multiple Interface ---
        System.out.println("\n>>> 3. Pengujian Multiple Interface (Layanan Tambahan)");
        if (bbmSubsidi instanceof LayananTambahan) {
            LayananTambahan layanan = (LayananTambahan) bbmSubsidi;
            layanan.isiAnginGratis();
        }

        // --- 4. Testing Transaksi Non-Subsidi (Pajak & Poin) ---
        System.out.println("\n>>> 4. Pengujian BBM Non-Subsidi");
        bbmNonSubsidi.isiBahanBakar(30.0);

        // --- 5. Status Akhir BBM ---
        System.out.println("\n==================================================");
        System.out.println("                INFORMASI STOK AKHIR              ");
        System.out.println("==================================================");
        bbmSubsidi.cetakStruk();
        System.out.println("--------------------------------------------------");
        bbmNonSubsidi.cetakStruk();
        System.out.println("==================================================");
    }
}

public class BahanBakarSubsidi extends BahanBakar implements LayananTambahan {
    private double kuotaMaksimal;

    public BahanBakarSubsidi(String kodeBBM, String namaBBM, double hargaPerLiter, double stok, double kuotaMaksimal) {
        super(kodeBBM, namaBBM, hargaPerLiter, stok);
        this.kuotaMaksimal = kuotaMaksimal;
    }

    public BahanBakarSubsidi(String kodeBBM, String namaBBM, double hargaPerLiter) {
        super(kodeBBM, namaBBM, hargaPerLiter);
        this.kuotaMaksimal = 20.0; // Default kuota 20 liter
    }

    public double getKuotaMaksimal() {
        return kuotaMaksimal;
    }

    @Override
    public boolean prosesTransaksi(double liter) {
        if (liter > kuotaMaksimal) {
            System.out.println("[GAGAL] Pembelian " + liter + "L melebihi kuota maksimal subsidi (" + kuotaMaksimal + "L)!");
            return false;
        } else if (getStok() < liter) {
            System.out.println("[GAGAL] Stok " + getNamaBBM() + " tidak mencukupi!");
            return false;
        } else {
            setStok(getStok() - liter);
            return true;
        }
    }

    @Override
    public void isiBahanBakar(double liter) {
        System.out.println("\n--- Transaksi BBM Subsidi (" + super.getNamaBBM() + ") ---");
        if (prosesTransaksi(liter)) {
            double total = liter * getHargaPerLiter();
            System.out.println("[SUKSES] Pengisian " + liter + " Liter berhasil.");
            System.out.println("Total Bayar (Subsidi Bebas Pajak): Rp " + total);
        }
    }

    @Override
    public void isiAnginGratis() {
        System.out.println("[FASILITAS] Pengisian angin nitrogen gratis untuk konsumen BBM Subsidi (" + super.getNamaBBM() + ").");
    }
}

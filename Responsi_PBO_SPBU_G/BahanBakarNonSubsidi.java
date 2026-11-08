public class BahanBakarNonSubsidi extends BahanBakar {
    private int poinLoyalitas;

    public BahanBakarNonSubsidi(String kodeBBM, String namaBBM, double hargaPerLiter, double stok) {
        super(kodeBBM, namaBBM, hargaPerLiter, stok);
        this.poinLoyalitas = 0;
    }

    public BahanBakarNonSubsidi(String kodeBBM, String namaBBM, double hargaPerLiter) {
        super(kodeBBM, namaBBM, hargaPerLiter);
        this.poinLoyalitas = 0;
    }

    public int getPoinLoyalitas() {
        return poinLoyalitas;
    }

    @Override
    public boolean prosesTransaksi(double liter) {
        if (getStok() < liter) {
            System.out.println("[GAGAL] Stok " + getNamaBBM() + " tidak mencukupi!");
            return false;
        } else {
            setStok(getStok() - liter);
            this.poinLoyalitas += (int)(liter * 2); // 2 poin per liter
            return true;
        }
    }

    @Override
    public void isiBahanBakar(double liter) {
        System.out.println("\n--- Transaksi BBM Non-Subsidi (" + super.getNamaBBM() + ") ---");
        if (prosesTransaksi(liter)) {
            double subtotal = liter * getHargaPerLiter();
            double pajak = subtotal * PAJAK; 
            double total = subtotal + pajak;
            System.out.println("[SUKSES] Pengisian " + liter + " Liter berhasil.");
            System.out.println("Subtotal  : Rp " + subtotal);
            System.out.println("Pajak (11%): Rp " + pajak);
            System.out.println("Total Bayar: Rp " + total);
            System.out.println("Poin Loyalitas diperoleh: " + (int)(liter * 2) + " (Total Poin: " + this.poinLoyalitas + ")");
        }
    }
}

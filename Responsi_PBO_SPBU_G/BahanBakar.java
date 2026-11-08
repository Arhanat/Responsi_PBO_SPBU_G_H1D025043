public abstract class BahanBakar implements Operasional {
    public static final double PAJAK = 0.11;
    
    private final String kodeBBM;

    private String namaBBM;
    private double hargaPerLiter;
    private double stok;

    public BahanBakar(String kodeBBM, String namaBBM, double hargaPerLiter, double stok) {
        this.kodeBBM = kodeBBM;
        this.namaBBM = namaBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.stok = stok;
    }

    public BahanBakar(String kodeBBM, String namaBBM, double hargaPerLiter) {
        this(kodeBBM, namaBBM, hargaPerLiter, 1000.0); // Default stok 1000 liter
    }

    public String getKodeBBM() {
        return kodeBBM;
    }

    public String getNamaBBM() {
        return namaBBM;
    }

    public void setNamaBBM(String namaBBM) {
        this.namaBBM = namaBBM;
    }

    public double getHargaPerLiter() {
        return hargaPerLiter;
    }

    public void setHargaPerLiter(double hargaPerLiter) {
        this.hargaPerLiter = hargaPerLiter;
    }

    public double getStok() {
        return stok;
    }

    public void setStok(double stok) {
        this.stok = stok;
    }

    public abstract boolean prosesTransaksi(double liter);

    @Override
    public void cetakStruk() {
        System.out.println("Kode BBM  : " + this.kodeBBM);
        System.out.println("Nama BBM  : " + this.namaBBM);
        System.out.println("Harga/L   : Rp " + this.hargaPerLiter);
        System.out.println("Stok Sisa : " + this.stok + " Liter");
    }
}

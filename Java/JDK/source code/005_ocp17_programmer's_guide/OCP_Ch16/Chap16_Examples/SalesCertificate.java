// Fictive cd sales certificates.
// LOWSALES: less than 5000.
// GOLD: over 5000 less than 10000.
// PLATINUM: over 10000, less than 20000.
// DIAMOND: over 20000.
public enum SalesCertificate {
  LOWSALES, GOLD, PLATINUM, DIAMOND;

  public static SalesCertificate determineSC(int sales) {
    if (sales < 5000) return LOWSALES;
    if (sales < 10000) return GOLD;
    if (sales < 20000) return PLATINUM;
    return DIAMOND;
  }
}
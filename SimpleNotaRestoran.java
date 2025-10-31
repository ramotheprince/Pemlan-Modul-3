import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class SimpleNotaRestoran {

    // ===== Atribut (konfigurasi dan menu) =====
    static final int TAX = 10;     // pajak 10%
    static final int SERVICE = 5;  // service 5%

    // Kode → (nama, harga)
    static final LinkedHashMap<String, MenuItem> MENU = new LinkedHashMap<>();
    static {
        MENU.put("M1", new MenuItem("Nasi Goreng", 25000));
        MENU.put("M2", new MenuItem("Mie Ayam", 20000));
        MENU.put("D1", new MenuItem("Es Teh", 8000));
        MENU.put("D2", new MenuItem("Jus Mangga", 15000));
        MENU.put("S1", new MenuItem("Pisang Goreng", 12000));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<OrderLine> cart = new ArrayList<>();

        showMenu();
        while (true) {
            System.out.print("Kode menu (0 = selesai): ");
            String code = sc.nextLine().trim().toUpperCase();
            if (code.equals("0")) break;
            if (!MENU.containsKey(code)) {
                System.out.println("⚠️  Kode tidak ada.");
                continue;
            }
            System.out.print("Qty: ");
            int qty = parseInt(sc.nextLine(), 1);
            if (qty <= 0) qty = 1;
            addToCart(cart, code, qty);
            System.out.println("✅ Ditambahkan.");
        }

        System.out.print("Diskon (%) = ");
        int discPct = parseInt(sc.nextLine(), 0);
        discPct = Math.max(0, Math.min(discPct, 100)); // clamp 0..100

        // Hitung subtotal
        int subtotal = 0;
        for (OrderLine l : cart) subtotal += l.lineTotal(MENU);

        // [LIVE TEMPLATE] tempat expand snippet "calcnota2"
        int discAmt = subtotal * discPct / 100;
        int base = subtotal - discAmt;
        int taxAmt = base * TAX / 100;
        int svcAmt = base * SERVICE / 100;
        int grand = base + taxAmt + svcAmt;

        printReceipt(cart, subtotal, discPct, discAmt, taxAmt, svcAmt, grand);
    }

    // ===== Method util =====
    static void showMenu() {
        System.out.println("==== MENU ====");
        System.out.printf("%-4s %-16s %10s%n", "Kd", "Nama", "Harga");
        for (Map.Entry<String, MenuItem> e : MENU.entrySet()) {
            System.out.printf("%-4s %-16s %10s%n",
                    e.getKey(), e.getValue().name, idr(e.getValue().price));
        }
        System.out.println("==============");
    }

    static void addToCart(List<OrderLine> cart, String code, int qty) {
        for (OrderLine l : cart) {
            if (l.code.equals(code)) { l.qty += qty; return; }
        }
        cart.add(new OrderLine(code, qty));
    }

    static void printReceipt(List<OrderLine> cart, int subtotal, int discPct,
                             int discAmt, int taxAmt, int svcAmt, int grand) {
        System.out.println("\n===== NOTA PEMBELIAN =====");
        System.out.printf("%-16s %5s %10s%n", "Item", "Qty", "Jumlah");
        for (OrderLine l : cart) {
            MenuItem m = MENU.get(l.code);
            System.out.printf("%-16s %5d %10s%n", m.name, l.qty, idr(l.lineTotal(MENU)));
        }
        System.out.println("-------------------------------");
        System.out.printf("%-16s %5s %10s%n", "Subtotal", "", idr(subtotal));
        if (discPct > 0)
            System.out.printf("Diskon (%d%%)         %10s%n", discPct, idr(discAmt));
        else
            System.out.printf("%-16s %5s %10s%n", "Diskon", "", idr(0));
        System.out.printf("Pajak (%d%%)           %10s%n", TAX, idr(taxAmt));
        System.out.printf("Service (%d%%)         %10s%n", SERVICE, idr(svcAmt));
        System.out.println("-------------------------------");
        System.out.printf("%-16s %5s %10s%n", "TOTAL", "", idr(grand));
        System.out.println("Terima kasih!\n");
    }

    static int parseInt(String s, int fallback) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return fallback; }
    }

    static String idr(int value) {
        DecimalFormatSymbols sym = new DecimalFormatSymbols(new Locale("id", "ID"));
        sym.setDecimalSeparator(',');
        sym.setGroupingSeparator('.');
        return "Rp " + new DecimalFormat("#,##0", sym).format(value);
    }

    // ===== Kelas kecil (atribut & method) =====
    static class MenuItem {
        final String name; final int price;
        MenuItem(String name, int price) { this.name = name; this.price = price; }
    }
    static class OrderLine {
        final String code; int qty;
        OrderLine(String code, int qty) { this.code = code; this.qty = qty; }
        int lineTotal(Map<String, MenuItem> menu) { return qty * menu.get(code).price; }
    }
}
import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter2 {

    private static HashMap<String, Double> exchangeRates = new HashMap<>();
    
    static {
    
        exchangeRates.put("USD_INR", 83.00);
        exchangeRates.put("INR_USD", 0.012);
        exchangeRates.put("USD_EUR", 0.85);
        exchangeRates.put("EUR_USD", 1.18);
        exchangeRates.put("USD_GBP", 0.76);
        exchangeRates.put("GBP_USD", 1.31);
  
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        String key = fromCurrency + "_" + toCurrency;
        if (exchangeRates.containsKey(key)) {
            return exchangeRates.get(key);
        } else {
            System.out.println("Exchange rate not available.");
            return -1;
        }
    }

    private static double convertCurrency(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the base currency (e.g., USD, INR, EUR, GBP): ");
        String baseCurrency = scanner.next().toUpperCase();
        
        System.out.println("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        
        double rate = getExchangeRate(baseCurrency, targetCurrency);
        
        if (rate != -1) {
            System.out.println("Enter the amount to convert: ");
            double amount = scanner.nextDouble();
            
            double convertedAmount = convertCurrency(amount, rate);
           
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Conversion could not be performed due to missing exchange rate.");
        }

        scanner.close();
    }
}


package com.areap2.landtransaction.util;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;

public final class LandTransactionFingerprint {

    private LandTransactionFingerprint() {}

    public static String create(
            String district, String circle, String mouza, String lot,
            String village, String dagNo, String nicCode,
            BigDecimal considerationValue, LocalDate transactionDate) {

        String raw = String.join("|",
                normalize(district), normalize(circle), normalize(mouza), normalize(lot),
                normalize(village), normalize(dagNo), normalize(nicCode),
                considerationValue == null ? "" : considerationValue.stripTrailingZeros().toPlainString(),
                transactionDate == null ? "" : transactionDate.toString());

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(raw.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to generate record fingerprint", e);
        }
    }

    private static String normalize(String value) {
        return value == null ? "" : value.trim().replaceAll("\\s+", " ").toUpperCase();
    }
}

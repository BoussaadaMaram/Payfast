package com.paymentqrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class QRCodeService {

    public String generatePaymentLink(Integer amount) {
        // Simulate generating a custom payment link
        return "https://example.com/payment?amount=" + amount + "&id=" + UUID.randomUUID();
    }

    public String saveQRCodeToFile(String paymentUrl, String outputDir) {
        try {
            // Generate the QR code matrix
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(paymentUrl, BarcodeFormat.QR_CODE, 250, 250);

            // Define the file path for the QR code image
            String fileName = "qrcode-" + UUID.randomUUID() + ".png";
            Path filePath = FileSystems.getDefault().getPath(outputDir, fileName);

            // Save the QR code as an image file
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);

            // Return the file path (or URL if needed)
            return "/images/" + fileName;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

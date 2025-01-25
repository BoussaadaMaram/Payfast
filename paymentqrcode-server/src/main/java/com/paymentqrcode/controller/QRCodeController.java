package com.paymentqrcode.controller;

import com.paymentqrcode.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generateQRCode(@RequestBody Map<String, Object> request) {
        try {
            // Retrieve the amount from the request
            Integer amount = Integer.parseInt(request.get("amount").toString());

            // Validate the amount
            if (amount == null || amount <= 0) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Le montant doit être supérieur à zéro."));
            }

            // Generate the payment URL
            String paymentUrl = qrCodeService.generatePaymentLink(amount);

            // Save the QR code to a public directory
            String imageUrl = qrCodeService.saveQRCodeToFile(paymentUrl, "src/main/resources/static/images");

            // Return the image URL to the frontend
            return ResponseEntity.ok(Map.of("paymentUrl", paymentUrl, "qrCodeImageUrl", imageUrl));

        } catch (Exception e) {
            // Handle unexpected errors
            return ResponseEntity.status(500)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}

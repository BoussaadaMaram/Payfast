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
            // Récupérer le montant depuis la requête
            Double amount = (Double) request.get("amount");

            // Validation de la donnée
            if (amount == null || amount <= 0) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Le montant doit être supérieur à zéro."));
            }

            // Générer l'URL du QR code
            String qrCodeUrl = qrCodeService.generateQRCode(amount);

            // Retourner l'URL au front-end
            return ResponseEntity.ok(Map.of("url", qrCodeUrl));

        } catch (Exception e) {
            // Gérer toute erreur inattendue
            return ResponseEntity.status(500)
                    .body(Map.of("error", "Une erreur est survenue lors de la génération du QR code."));
        }
    }
}

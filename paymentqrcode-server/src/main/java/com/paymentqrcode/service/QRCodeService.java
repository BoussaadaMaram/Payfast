package com.paymentqrcode.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QRCodeService {

    public String generateQRCode(Double amount) {
        // Simuler la génération d'une URL de paiement dynamique
        String paymentUrl = "https://example.com/payment/" + UUID.randomUUID();

        // Vous pouvez ici intégrer une bibliothèque pour générer un QR code visuel
        // Exemple : QRCode.from(paymentUrl).to(...);

        return paymentUrl;
    }
}
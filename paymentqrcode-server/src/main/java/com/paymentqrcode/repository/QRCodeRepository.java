package com.paymentqrcode.repository;

import com.paymentqrcode.model.QRCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface QRCodeRepository extends MongoRepository<QRCode, String> {
    List<QRCode> findByIsValidTrue(); // Récupérer tous les QR Codes valides
}

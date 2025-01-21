package com.paymentqrcode.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "qrcodes")
public class QRCode {
    @Id
    private String id;
    private double amount;
    private boolean isValid;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}

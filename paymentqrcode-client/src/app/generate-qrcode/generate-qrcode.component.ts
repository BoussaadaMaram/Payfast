import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-generate-qrcode',
  templateUrl: './generate-qrcode.component.html',
  styleUrls: ['./generate-qrcode.component.css'],
})
export class GenerateQrCodeComponent {
  amount: number = 0;
  qrCodeUrl: string | null = null;

  constructor(private http: HttpClient) {}

  onSubmit() {
    this.http
        .post<{ url: string }>('http://localhost:8081/api/qrcode/generate', { amount: this.amount })
        .subscribe((response) => {
          this.qrCodeUrl = response.url;
        });
  }
}

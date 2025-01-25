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
  baseURL: string = 'http://localhost:8081';

  constructor(private http: HttpClient) {}

  onSubmit() {
    this.http
        .post(this.baseURL + '/api/qrcode/generate', { amount: this.amount })
        .subscribe((response: any) => {
          this.qrCodeUrl = this.baseURL+response.qrCodeImageUrl;
        });
  }
}

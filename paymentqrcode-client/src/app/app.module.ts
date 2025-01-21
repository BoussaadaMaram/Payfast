import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormsModule } from '@angular/forms'; // Ajout de FormsModule
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertComponent } from './_components';
import { HomeComponent } from './home';
import { GenerateQrCodeComponent } from './generate-qrcode/generate-qrcode.component';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        FormsModule, // Ajout de FormsModule
        HttpClientModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        GenerateQrCodeComponent
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }

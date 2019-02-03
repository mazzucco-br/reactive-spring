import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppService } from './app.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { ContratosComponent } from './contratos/contratos.component';
import { AssinaturasComponent } from './assinaturas/assinaturas.component';
import { AssinaturasService } from './assinaturas/assinaturas.service';
import { ContratosService } from './contratos/contratos.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContratosComponent,
    AssinaturasComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AppService,
    AssinaturasService,
  ContratosService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

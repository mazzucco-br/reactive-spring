import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { AssinaturasService } from './assinaturas.service';

@Component({
  selector: 'app-assinaturas',
  templateUrl: './assinaturas.component.html',
  styleUrls: ['./assinaturas.component.css']
})
export class AssinaturasComponent implements OnInit {

  assinaturas = [];

  detailOpened: number;

  constructor(private _assinaturaService: AssinaturasService,
              private _router: Router) {

  }

  ngOnInit(): void {
    this._assinaturaService.onMessage((message: MessageEvent) => {
      const data = message.data;
      this.assinaturas.push(data);
      if (this.assinaturas.length > 100) {
        this.assinaturas.slice(0, 1);
      }
    });

    this._assinaturaService.connectWebsocket();
  }

  openDetails(position) {
    if (position === this.detailOpened) {
      this.detailOpened = null;
    } else {
      this.detailOpened = position;
    }
  }

}

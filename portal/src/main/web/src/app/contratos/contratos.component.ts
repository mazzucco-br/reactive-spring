import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ContratosService} from './contratos.service';

@Component({
  selector: 'app-contratos',
  templateUrl: './contratos.component.html',
  styleUrls: ['./contratos.component.css']
})
export class ContratosComponent implements OnInit {

  contratos = [];

  detailOpened: number;

  constructor(private _contratosService: ContratosService,
              private _router: Router) {

  }

  ngOnInit(): void {

    this._contratosService
      .listarContratos()
      .subscribe(response => {
        this.contratos = response;
        console.log(response);
      });
  }

  openDetails(position) {
    if (position === this.detailOpened) {
      this.detailOpened = null;
    } else {
      this.detailOpened = position;
    }
  }

}

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { ContratosComponent } from './contratos/contratos.component';
import { AssinaturasComponent } from './assinaturas/assinaturas.component';

const routes: Routes = [
  { path: 'app', component: HomeComponent, children: [
      { path: 'contratos', component: ContratosComponent },
      { path: 'assinaturas', component: AssinaturasComponent },
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
  providers: []
})

export class AppRoutingModule {
}

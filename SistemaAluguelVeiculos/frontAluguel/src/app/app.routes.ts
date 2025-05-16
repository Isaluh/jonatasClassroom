import { Routes } from '@angular/router';
import { BaseComponent } from './Layouts/base/base.component';
import { ClientesComponent } from './Views/clientes/clientes.component';

export const routes: Routes = [
    { path: '', redirectTo: '/clientes', pathMatch: 'full' },
    {path: 'clientes' , component : ClientesComponent},
    { path: 'veiculos', component: BaseComponent },
    { path: 'alugueis', component: BaseComponent },
];

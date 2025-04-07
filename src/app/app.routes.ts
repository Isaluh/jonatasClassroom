import { Routes } from '@angular/router';
import { InformacaoViewComponent } from './Views/informacao-view/informacao-view.component';
import { FormularioViewComponent } from './Views/formulario-view/formulario-view.component';

export const routes: Routes = [
    {path: '', component: FormularioViewComponent},
    {path: 'info', component: InformacaoViewComponent}
];

import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { IconChangeComponent } from '../../Icons/icon-change/icon-change.component';

@Component({
  selector: 'ClientesView',
  standalone: true,
  imports: [BaseComponent, IconChangeComponent],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {

}

import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Grupo } from '../../Models/contatos';
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'filtroComponent',
  standalone: true,
  imports: [FormsModule, NgIf, NgFor],
  templateUrl: './filtro.component.html',
  styleUrl: './filtro.component.css'
})
export class FiltroComponent {
  @Input() grupos : Grupo[] = []

  filtro : number | null = null

  @Output() aplicar = new EventEmitter()

  addFiltro(){
    this.aplicar.emit(this.filtro)
  }
}

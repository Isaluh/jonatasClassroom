import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ButtonsComponent } from "../../components/buttons/buttons.component";

@Component({
  selector: 'modalBaseModal',
  standalone: true,
  imports: [ButtonsComponent],
  templateUrl: './modal-base.component.html',
  styleUrl: './modal-base.component.css'
})
export class ModalBaseComponent {
  @Input() titulo: string = '';
  @Output() acao = new EventEmitter()

  cancelar(){
    this.acao.emit('cancelar')
  }

  prosseguir(){
    this.acao.emit('prosseguir')
  }
}

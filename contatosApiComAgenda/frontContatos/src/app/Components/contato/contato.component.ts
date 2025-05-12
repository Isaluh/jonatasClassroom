import { Component, Input } from '@angular/core';
import { Contato } from '../../Models/contatos';

@Component({
  selector: 'contatoComponent',
  standalone: true,
  imports: [],
  templateUrl: './contato.component.html',
  styleUrl: './contato.component.css'
})
export class ContatoComponent {
  @Input() contato : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', grupo: null, favorito: false }
}

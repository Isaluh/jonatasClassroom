import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contato } from '../../Models/contatos';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'fichaComponent',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './ficha.component.html',
  styleUrl: './ficha.component.css'
})
export class FichaComponent {
  @Input() contato : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', favorito: false }
  @Output() editCtt = new EventEmitter()
  @Output() excluirCtt = new EventEmitter()

  contatoEdit : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', favorito: false }
  statusEdit : number = 0
  
  editarContato(id: number | null) {
    if(id != null){
      this.statusEdit = id;
      this.contatoEdit = this.contato
    }
  }

  salvarEdit(){
    this.editCtt.emit(this.contatoEdit)
    this.cancelar()
  }

  cancelar(){
    this.contatoEdit = this.contato;
    this.statusEdit = 0;
  }

  excluir(){
    this.excluirCtt.emit(this.contatoEdit.id)
  }

  favoritar(){
    console.log('favv')
  }
}

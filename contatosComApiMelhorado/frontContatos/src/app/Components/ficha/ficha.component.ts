import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contato, Grupo } from '../../Models/contatos';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'fichaComponent',
  standalone: true,
  imports: [NgIf, FormsModule, NgFor],
  templateUrl: './ficha.component.html',
  styleUrl: './ficha.component.css'
})
export class FichaComponent {
  @Input() grupos : Grupo[] = []
  @Input() contato : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', grupo: null, favorito: false }
  @Output() editCtt = new EventEmitter()
  @Output() excluirCtt = new EventEmitter()
  @Output() toggleFav = new EventEmitter()

  contatoEdit : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', grupo: null, favorito: false }
  statusEdit : number = 0
  

  ngOnInit(){
    this.cancelar()
  }

  editarContato(id: number | null) {
    if(id != null){
      this.statusEdit = id;
    }
  }

  salvarEdit(){
    this.editCtt.emit(this.contatoEdit)
    this.cancelar()
  }

  cancelar(){
    this.contatoEdit = { ...this.contato};
    this.statusEdit = 0;
  }

  excluir(){
    this.excluirCtt.emit(this.contatoEdit.id)
  }

  favoritar(){
    this.toggleFav.emit(this.contato)
  }
}

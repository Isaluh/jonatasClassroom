import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contato, Grupo } from '../../Models/contatos';
import { FormsModule } from '@angular/forms';
import { ContatoServiceService } from '../../Services/Contato/contato-service.service';
import { GrupoServiceService } from '../../Services/Grupo/grupo-service.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'cadastroView',
  standalone: true,
  imports: [FormsModule, NgFor, NgIf],
  templateUrl: './cadastro-view.component.html',
  styleUrl: './cadastro-view.component.css'
})
export class CadastroViewComponent {
  grupoAdd : Grupo = {id: null, nome: ''}
  contatoAdd : Contato = {id: null, nome: '', telefone: null, email: '', profissao: '', grupo: null, favorito: false }
  @Input() grupos : Grupo[] = []
  @Output() reload = new EventEmitter()

  constructor(private contatoService : ContatoServiceService, private grupoService : GrupoServiceService){}

  cadastrar(){
    if(!this.contatoAdd.nome.trim()){
      alert('Campo obrigatório: "Nome" em branco, não foi possível cadastrar o aluno.')
      return
    }
    if(!this.contatoAdd.email.trim() && !this.contatoAdd.telefone){
      alert('Campo obrigatório: "Telefone" ou "E-mail" em branco, não foi possível cadastrar o aluno.')
      return
    }

    this.contatoService.addContato(this.contatoAdd).subscribe(() => {
      this.reload.emit()
      this.contatoAdd = {id: null, nome: '', telefone: null, email: '', profissao: '', grupo: null, favorito: false};
    });
    
  }

  criarGrupo(){
    this.grupoService.addGrupo(this.grupoAdd).subscribe(() => {
      this.reload.emit()
      this.grupoAdd = {id: null, nome: ''}
    })
  }
}

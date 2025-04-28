import { Component, Input } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { ContatoServiceService } from '../../Services/contato-service.service';
import { Contato } from '../../Models/contatos';
import { FormsModule } from '@angular/forms';
import { FichaComponent } from '../../Components/ficha/ficha.component';

@Component({
  selector: 'listagemView',
  standalone: true,
  imports: [NgFor, NgIf, FormsModule, FichaComponent],
  templateUrl: './listagem-view.component.html',
  styleUrl: './listagem-view.component.css'
})
export class ListagemViewComponent {
  @Input() contatos : Contato[] = []

  constructor(private contatoService : ContatoServiceService){}

  reloadCtt(){
    this.contatoService.getContatos().subscribe(ctt => {this.contatos = ctt})
  }

  editarContato(contato : Contato) {
    this.contatoService.editContato(contato).subscribe(() => {
      this.reloadCtt()
    })
  }

  excluirContato(id: number){
    this.contatoService.excluirContato(id).subscribe(() => {
      this.reloadCtt()
    });
  }
}

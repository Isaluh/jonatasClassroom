import { Component, Input } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { ContatoServiceService } from '../../Services/Contato/contato-service.service';
import { Contato, Grupo } from '../../Models/contatos';
import { FormsModule } from '@angular/forms';
import { FichaComponent } from '../../Components/ficha/ficha.component';
import { FiltroComponent } from '../../Components/filtro/filtro.component';

@Component({
  selector: 'listagemView',
  standalone: true,
  imports: [NgFor, NgIf, FormsModule, FichaComponent, FiltroComponent],
  templateUrl: './listagem-view.component.html',
  styleUrl: './listagem-view.component.css'
})
export class ListagemViewComponent {
  @Input() grupos : Grupo[] = []
  @Input() contatos : Contato[] = []

  filtroCtt : string = "null"

  contatosVisiveis : Contato[] = []

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

  toggleFavoritar(contato : Contato){
    contato.favorito = !contato.favorito
    this.contatoService.toggleFav(contato).subscribe(() => {
      this.reloadCtt()
    });
  }

  // fazer com q apareça sem o filtro
  addFiltro(filtro : string){
    this.filtroCtt = filtro
    if(filtro == "null"){
      this.contatosVisiveis = this.contatos
      return
    }

    if (filtro === "0") {
      this.contatosVisiveis = this.contatos.filter(contato => contato.favorito === true);
      return;
    }

    this.contatosVisiveis = this.contatos.filter(contato => contato.grupo?.id == Number(filtro));
  }
}

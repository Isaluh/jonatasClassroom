import { Component } from '@angular/core';
import { ContatoComponent } from "../../Components/contato/contato.component";
import { ContatoServiceService } from '../../Services/Contato/contato-service.service';
import { Contato } from '../../Models/contatos';
import { NgFor } from '@angular/common';

@Component({
  selector: 'listagemView',
  standalone: true,
  imports: [ContatoComponent, NgFor],
  templateUrl: './listagem-view.component.html',
  styleUrl: './listagem-view.component.css'
})
export class ListagemViewComponent {
  contatos : Contato[] = []

  constructor(private contatoService : ContatoServiceService){}

  ngOnInit(){
    this.contatoService.getContatos().subscribe(ctt => {this.contatos = ctt});
  }
}

import { Component, Input, SimpleChanges } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { IconChangeComponent } from '../../Icons/icon-change/icon-change.component';
import { Cliente } from '../../Models/models';
import { NgFor, NgIf } from '@angular/common';
import { ClienteService } from '../../Service/clientes.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalBaseComponent } from '../../Modal/modal-base/modal-base.component';
import { InputsComponent } from "../../components/inputs/inputs.component";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'ClientesView',
  standalone: true,
  imports: [BaseComponent, IconChangeComponent, NgFor, NgIf, ModalBaseComponent, InputsComponent, FormsModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  @Input() clientes : Cliente[] = []
  clienteadd : Cliente = {id: null, nome : '', cpf: ''}
  abrirCadastro = false;

  constructor(private clienteService : ClienteService){}

  ngOnInit(){
    this.puxarClientes()
  }

  puxarClientes(){
    this.clienteService.getClientes().subscribe((cli) => {this.clientes = cli})
  }

  abrirModal(){
    this.abrirCadastro = true;
  }

  acaoModal(acao : string){
    if(acao == 'cancelar'){
      this.limpar()
      return
    }
    
    if(acao == 'prosseguir'){
      // fazer validação
      this.clienteService.addCliente(this.clienteadd).subscribe(() => {
        this.limpar()
        this.puxarClientes()
      })
    }
  }

  limpar(){
    this.abrirCadastro = false;
    this.clienteadd = {id: null, nome : '', cpf: ''}
  }
}

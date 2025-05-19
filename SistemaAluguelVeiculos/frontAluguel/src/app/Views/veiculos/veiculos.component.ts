import { Component, Input } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { IconChangeComponent } from '../../Icons/icon-change/icon-change.component';
import { NgFor, NgIf } from '@angular/common';
import { ModalBaseComponent } from '../../Modal/modal-base/modal-base.component';
import { InputsComponent } from '../../components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { VeiculosService } from '../../Service/veiculos.service';
import { TipoVeiculo, Veiculo } from '../../Models/models';

@Component({
  selector: 'app-veiculos',
  standalone: true,
  imports: [BaseComponent, IconChangeComponent, NgFor, NgIf, ModalBaseComponent, InputsComponent, FormsModule],
  templateUrl: './veiculos.component.html',
  styleUrl: './veiculos.component.css'
})
export class VeiculosComponent {
  @Input() veiculos : Veiculo[] = []
  veiculoadd : Veiculo = {id : null, modelo : '', tipo : TipoVeiculo.CARRO, disponivel : true}
  abrirCadastro = false;

  constructor(private veiculosService : VeiculosService){}

  ngOnInit(){
    this.puxarVeiculos()
  }

  puxarVeiculos(){
    this.veiculosService.getVeiculos().subscribe((vei) => {this.veiculos = vei})
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
      this.veiculosService.addVeiculo(this.veiculoadd).subscribe(() => {
        this.limpar()
        this.puxarVeiculos()
      })
    }
  }

  limpar(){
    this.abrirCadastro = false;
    this.veiculoadd = {id : null, modelo : '', tipo : TipoVeiculo.CARRO, disponivel : true}
  }
}

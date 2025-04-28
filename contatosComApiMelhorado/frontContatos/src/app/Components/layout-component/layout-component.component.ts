import { Component } from '@angular/core';
import { CadastroViewComponent } from '../../Views/cadastro-view/cadastro-view.component';
import { ListagemViewComponent } from '../../Views/listagem-view/listagem-view.component';
import { ContatoServiceService } from '../../Services/contato-service.service';
import { Contato } from '../../Models/contatos';

@Component({
  selector: 'layoutComponent',
  standalone: true,
  imports: [CadastroViewComponent, ListagemViewComponent],
  templateUrl: './layout-component.component.html',
  styleUrl: './layout-component.component.css'
})
export class LayoutComponentComponent {
  contatos : Contato[] = []

  constructor(private contatoService : ContatoServiceService){}

  ngOnInit(){
    this.reloadCtt()
  }

  reloadCtt(){
    this.contatoService.getContatos().subscribe(ctt => {this.contatos = ctt})
  }
}

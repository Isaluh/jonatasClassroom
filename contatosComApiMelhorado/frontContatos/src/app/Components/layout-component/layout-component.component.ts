import { Component } from '@angular/core';
import { CadastroViewComponent } from '../../Views/cadastro-view/cadastro-view.component';
import { ListagemViewComponent } from '../../Views/listagem-view/listagem-view.component';
import { ContatoServiceService } from '../../Services/Contato/contato-service.service';
import { Contato, Grupo } from '../../Models/contatos';
import { GrupoServiceService } from '../../Services/Grupo/grupo-service.service';

@Component({
  selector: 'layoutComponent',
  standalone: true,
  imports: [CadastroViewComponent, ListagemViewComponent],
  templateUrl: './layout-component.component.html',
  styleUrl: './layout-component.component.css'
})
export class LayoutComponentComponent {
  contatos : Contato[] = []
  grupos : Grupo[] = []

  constructor(private contatoService : ContatoServiceService, private grupoService : GrupoServiceService){}

  ngOnInit(){
    this.reloadAll()
  }

  reloadAll(){
    this.contatoService.getContatos().subscribe(ctt => {this.contatos = ctt})
    this.grupoService.getGrupos().subscribe(grp => {this.grupos = grp})
  }
}

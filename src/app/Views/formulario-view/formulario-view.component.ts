import { Component } from '@angular/core';
import { MainComponent } from "../../Components/main/main.component";
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';

type Aluno = {
  nome : String,
  idade: number | null,
  cpf: number | null
}

@Component({
  selector: 'formularioView',
  standalone: true,
  imports: [MainComponent, FormsModule, NgFor, NgIf],
  templateUrl: './formulario-view.component.html',
  styleUrl: './formulario-view.component.css'
})

export class FormularioViewComponent {
  alunos : Aluno[] = []
  alunoAdd : Aluno = {nome : '', idade : null, cpf : null}

  cadastrar(){
    if(this.alunoAdd.nome.trim() == '' || this.alunoAdd.idade == null || this.alunoAdd.cpf == null){
      alert('Há campos em branco, não foi possível cadastrar o aluno.')
      return
    }

    this.alunos.push(this.alunoAdd)
    this.alunoAdd = {nome : '', idade : null, cpf : null}
  }
}

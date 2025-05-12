import { Injectable } from '@angular/core';
import { Contato } from '../../Models/contatos';
import { HttpClient } from '@angular/common/http';
import { forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContatoServiceService {
  public static API_url: string = "http://localhost:8080/contatos"

  constructor(private httpClient : HttpClient) { }

  addContato(contato: Contato) {
    let url : string = ContatoServiceService.API_url + `/add`;
    return this.httpClient.post<Contato>(url, contato)
  }

  getContatos(){
    return this.httpClient.get<Contato[]>(ContatoServiceService.API_url)
  }

  contatoExist(id: number) {
    let url : string = ContatoServiceService.API_url + `/${id}`;
    return this.httpClient.get<Contato>(url)
  }

  editContato(contato: Contato) {
    let url : string = ContatoServiceService.API_url + `/update`;
    return this.httpClient.put<Contato>(url, contato)
  }

  excluirContato(id: number) {
    let url : string = ContatoServiceService.API_url + `/${id}`;
    return this.httpClient.delete<Contato>(url)
  }

  toggleFav(contato : Contato){
    let urlFav : string = ContatoServiceService.API_url.split('/contatos')[0] + `/favoritos/update/${contato.id}`;
    return forkJoin([
      this.editContato(contato),
      this.httpClient.put<Contato>(urlFav, contato)
    ]);
  }

}

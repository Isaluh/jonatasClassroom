import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Grupo } from '../../Models/contatos';

@Injectable({
  providedIn: 'root'
})
export class GrupoServiceService {
  public static API_url: string = "http://localhost:8080/grupos"
  
  constructor(private httpClient : HttpClient) { }

  addGrupo(grupo : Grupo){
    let url : string = GrupoServiceService.API_url + `/add`;
    return this.httpClient.post<Grupo>(url, grupo)
  }

  getGrupos(){
    return this.httpClient.get<Grupo[]>(GrupoServiceService.API_url)
  }
}

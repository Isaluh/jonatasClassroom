import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../Models/models';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  public static API_url: string = "http://localhost:8080/clientes";

  constructor(private httpClient:HttpClient) {}

  getClientes(){
    return this.httpClient.get<Cliente[]>(ClienteService.API_url)
  }

  addCliente(cliente : Cliente){
    return this.httpClient.post<Cliente>(ClienteService.API_url, cliente)
  }
}

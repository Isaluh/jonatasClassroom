import { Injectable } from '@angular/core';
import { Veiculo } from '../Models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
  public static API_url: string = "http://localhost:8080/veiculos";

  constructor(private httpClient:HttpClient) {}

  getVeiculos(){
    return this.httpClient.get<Veiculo[]>(VeiculosService.API_url)
  }

  addVeiculo(veiculo : Veiculo){
    return this.httpClient.post<Veiculo>(VeiculosService.API_url, veiculo)
  }
}

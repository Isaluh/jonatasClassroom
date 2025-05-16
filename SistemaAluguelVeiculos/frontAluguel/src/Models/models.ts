export enum TipoVeiculo {
  CARRO = "CARRO",
  MOTO = "MOTO"
}

export interface Veiculo {
  id: string;
  modelo: string;
  tipo: TipoVeiculo;
  disponivel: boolean;
}

export interface Cliente {
  id: string;
  nome: string;
  cpf: string;
}

export interface Aluguel {
  id: string;
  cliente: Cliente;
  veiculo: Veiculo;
  dataInicio: Date;
  dataFim: Date | null;
}

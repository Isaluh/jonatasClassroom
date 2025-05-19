export enum TipoVeiculo {
  CARRO = "CARRO",
  MOTO = "MOTO"
}

export interface Veiculo {
  id: number | null;
  modelo: string;
  tipo: TipoVeiculo;
  disponivel: boolean;
}

export interface Cliente {
  id: number | null;
  nome: string;
  cpf: string;
}

export interface Aluguel {
  id: number;
  cliente: Cliente;
  veiculo: Veiculo;
  dataInicio: Date;
  dataFim: Date | null;
}

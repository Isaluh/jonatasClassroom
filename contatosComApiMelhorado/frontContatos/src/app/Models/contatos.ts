export interface Contato{
    id: number | null,
    nome : String,
    telefone : number | null,
    email: String,
    profissao: String,
    grupo : Grupo | null,
    favorito: Boolean
}

export interface Grupo{
    id: number | null,
    nome: String
}
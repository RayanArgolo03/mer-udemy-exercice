# Modelo Entidade-Relacionamento (MER)

Este é um modelo entidade-relacionamento (MER) que representa a estrutura de um banco de dados para um sistema de notas fiscais e compras. O MER é composto por várias entidades e seus relacionamentos.

![First_MER_Invoice](https://github.com/RayanArgolo03/mer-udemy-exercice/assets/113947677/d692ae8f-a423-443a-85f8-91ac578b4d69)


## Entidades

### NotaFiscal

- **ID_NotaFiscal** (Chave Primária)
- DataEmissao
- ID_Empresa (Chave Estrangeira referenciando a tabela "Empresa")
- ID_Compra (Chave Estrangeira referenciando a tabela "Compra")

### Compra

- **ID_Compra** (Chave Primária)
- ID_Consumidor (Chave Estrangeira referenciando a tabela "Consumidor")

### Consumidor

- **ID_Consumidor** (Chave Primária)
- Nome
- CPF
- NumeroTelefone
- ID_Endereco (Chave Estrangeira referenciando a tabela "Endereco")

### Empresa

- **ID_Empresa** (Chave Primária)
- NomeFantasia
- RazaoSocial
- CNPJ
- NumeroTelefone
- ID_Endereco (Chave Estrangeira referenciando a tabela "Endereco")

### Endereco

- **ID_Endereco** (Chave Primária)
- Rua
- Numero
- Complemento
- Bairro
- Cidade
- CEP
- ID_UnidadeFederativa (Chave Estrangeira referenciando a tabela "UnidadeFederativa")

### UnidadeFederativa

- **ID_UnidadeFederativa** (Chave Primária)
- SiglaUF
- NomeEstado

## Relacionamentos

- NotaFiscal -> Compra: Uma nota fiscal está associada a uma única compra.
- Compra -> Consumidor: Uma compra pertence a um único consumidor.
- Compra -> NotaFiscal: Uma compra é associada a uma única nota fiscal.
- Consumidor -> Endereco: Um consumidor tem um endereço associado.
- Empresa -> Endereco: Uma empresa tem um endereço associado.

## Justificativas

- O campo "ValorTotal" não é incluído na tabela "NotaFiscal" porque pode ser calculado a partir dos detalhes da compra.
- Cada nota fiscal contém apenas uma compra, que é diferenciada pela data de emissão da nota.
- As entidades estão relacionadas para representar a estrutura de um sistema de notas fiscais e compras.

Este é um modelo básico e pode ser estendido ou adaptado com base nos requisitos específicos do sistema.


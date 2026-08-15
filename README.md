# Sistema de Loja Virtual

Projeto progressivo de um sistema de e-commerce em Java, desenvolvido para estudo e portfólio.

## Objetivo
Praticar Programação Orientada a Objetos com Java, aprofundando o uso de associação entre classes e coleções (listas), evoluindo o projeto por etapas.

## Tecnologias utilizadas
- Java
- IntelliJ IDEA

## Funcionalidades atuais
- Cadastro de produtos (nome, preço, quantidade em estoque)
- Listagem numerada de produtos disponíveis
- Escolha interativa de produto e quantidade via terminal (Scanner)
- Adição de itens ao carrinho
- Cálculo de subtotal por item
- Cálculo do total do carrinho

## Conceitos praticados
- Classes e objetos
- Encapsulamento
- Associação entre classes (Produto, ItemCarrinho e Carrinho)
- Listas e coleções (ArrayList)
- Laços de repetição (for e for-each)
- Entrada de dados via Scanner
- Manipulação de índices de lista (conversão entre escolha do usuário e índice real)

## Aprendizados
Este projeto está me ajudando a evoluir além do que pratiquei no meu primeiro projeto (OGbank), aplicando listas e coleções para representar relações de "um-para-muitos" (um carrinho pode ter vários itens, uma loja tem vários produtos).

Também aprendi a identificar e corrigir um erro comum: reaproveitar o mesmo objeto para representar itens diferentes, o que sobrescreve os dados anteriores em vez de criar registros separados. A solução foi sempre criar uma nova instância de `ItemCarrinho` para cada produto adicionado ao carrinho.

Outro aprendizado importante foi a diferença entre a posição exibida ao usuário (começando em 1) e o índice real da lista (começando em 0), e como fazer a conversão correta entre os dois.

## Próximos passos
- Permitir a escolha de múltiplos produtos antes de finalizar a compra (loop de compra)
- Adicionar as classes Cliente e Pedido
- Implementar remoção de itens do carrinho
- Aplicar herança e polimorfismo (ex: tipos de desconto)
- Evoluir o projeto futuramente com Spring Boot e uma API REST
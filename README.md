# Sudoku em Java

Projeto desenvolvido para o desafio da plataforma DIO
**Criando um Jogo do Sudoku em Java**.

## Objetivo

Desenvolver um jogo de Sudoku utilizando Java,
aplicando conceitos de Programação Orientada a Objetos,
estruturas de dados, validações e organização de código.

## Funcionalidades

O sistema permite:

- Iniciar um jogo de Sudoku
- Visualizar o tabuleiro
- Inserir números
- Remover números
- Manter números fixos
- Verificar erros
- Verificar o status da partida
- Reiniciar o jogo
- Detectar quando o Sudoku foi concluído

## Estrutura

```text
src/
└── br/
    └── com/
        └── dio/
            ├── Main.java
            ├── model/
            │   ├── Board.java
            │   ├── Space.java
            │   └── GameStatusEnum.java
            └── service/
                └── BoardService.java
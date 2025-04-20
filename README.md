# Sudoku Console & GUI Game

Este projeto implementa um jogo de Sudoku com duas interfaces: jogável pelo terminal e com uma interface gráfica (GUI) em Java. A estrutura do código segue os princípios de Programação Orientada a Objetos (POO) e inclui testes automatizados com JUnit 5.

## 🚀 Tecnologias Utilizadas
![Java](https://img.shields.io/badge/Java-21%2B-blue)
![JUnit](https://img.shields.io/badge/JUnit-5-orange)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-darkblue)

- Java 21 ou superior
- JUnit 5 para testes unitários
- Swing para a interface gráfica
- Eclipse IDE (ou qualquer IDE de sua preferência)

## 📂 Estrutura do Projeto

```
com.dio.sudoku
├── Main.java              # Classe principal que inicia o jogo
├── StartMenu.java         # Menu inicial com opção para escolher entre terminal e GUI
├── SudokuGUI.java         # Interface gráfica do jogo (Swing)
├── SudokuBoard.java       # Lógica do jogo e manipulação do tabuleiro
├── Cell.java              # Representa uma célula do Sudoku
└── SudokuBoardTest.java   # Classe de testes automatizados (JUnit)

```

## 🧠 Funcionalidades
- 🎲 **Inicialização de tabuleiro** com valores embaralhados
- 🖥️ **Exibição do tabuleiro** com estrutura visual em ASCII ou GUI
- 🎮 **Jogabilidade via terminal ou interface gráfica**
- ✅ **Validações de jogadas**:
  - 🚫 Células fixas não podem ser alteradas
  - 🔢 Não é permitido repetir valores na mesma linha, coluna ou bloco 3x3
- 🏁 **Verificação automática** se o jogo está completo

## ▶️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/solozabal/dio-bradesco-sudoku
   ```

2. **Abra o projeto no Eclipse IDE:**
   - Vá em `File > Open Projects from File System...`
   - Selecione o diretório do projeto clonado

3. **Execute o `StartMenu.java`:**
   - Clique com o botão direito em `StartMenu.java`
   - Escolha `Run As > Java Application`
   
⚠️ Importante: a classe Main.java é utilizada apenas para a execução direta via terminal. Recomendamos iniciar o jogo sempre por StartMenu.java para acessar ambas as opções de interface.

## ✅ Executando os Testes
1. Certifique-se de que o JUnit 5 está no classpath do projeto.
2. Clique com o botão direito no arquivo `SudokuBoardTest.java`
3. Selecione `Run As > JUnit Test`

## 📌 Exemplo de Jogada
No terminal:
```
📌 Digite sua jogada no formato: linha coluna valor (ex: 0 1 5)
➤ Sua jogada: 0 1 4
```
Isso tentará inserir o número 4 na linha 0, coluna 1.

## 🧱 To-Do / Melhorias Futuras
- Gerador dinâmico de tabuleiros válidos
- Sistema de pontuação ou cronômetro
- Tela de vitória/derrota para GUI
- Melhorias visuais na interface gráfica

---

Feito com 💻 por Pedro Solozabal.


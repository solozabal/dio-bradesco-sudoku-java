# Sudoku Console Game

Este projeto implementa um jogo de Sudoku jogável pelo terminal, utilizando Java. A estrutura do código é orientada a objetos, com funcionalidades de validação de jogadas, verificação de conclusão do jogo e testes automatizados com JUnit 5.

## 🚀 Tecnologias Utilizadas
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![JUnit](https://img.shields.io/badge/JUnit-5-orange)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-darkblue)

- Java 17 ou superior
- JUnit 5 para testes unitários
- Eclipse IDE (ou qualquer IDE de sua preferência)

## 📂 Estrutura do Projeto

```
com.dio.sudoku
├── Main.java              # Classe principal com loop do jogo
├── SudokuBoard.java       # Representa o tabuleiro e contém a lógica do jogo
├── Cell.java              # Representa uma célula do Sudoku
└── SudokuBoardTest.java   # Classe de testes automatizados (JUnit)
```

## 🧠 Funcionalidades
- 🎲 **Inicialização de tabuleiro** com valores embaralhados
- 🖥️ **Exibição do tabuleiro** com estrutura visual em ASCII
- 🎮 **Jogabilidade via terminal**
- ✅ **Validações de jogadas**:
  - 🚫 Células fixas não podem ser alteradas
  - 🔢 Não é permitido repetir valores na mesma linha, coluna ou bloco 3x3
- 🏁 **Verificação automática** se o jogo está completo

## ▶️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/sudoku-terminal-game.git
   ```

2. **Abra o projeto no Eclipse IDE:**
   - Vá em `File > Open Projects from File System...`
   - Selecione o diretório do projeto clonado

3. **Execute o `Main.java`:**
   - Clique com o botão direito em `Main.java`
   - Escolha `Run As > Java Application`

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
- Interface gráfica (GUI)
- Sistema de pontuação ou tempo

---

Feito com 💻 por Pedro Solozabal.


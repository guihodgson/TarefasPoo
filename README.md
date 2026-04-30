# Dragon Warrior

"Dragon Warrior" é um projeto em Java (Gradle) com batalhas de terminal na temática de Kung Fu Panda, organizado no módulo `app`.
A classe principal e `ProjetoPoo.App`.

# Estrutura

- Codigo principal: `app/src/main/java/ProjetoPoo`
- Testes: `app/src/test/java/ProjetoPoo`
- Build e relatorios: `app/build`

# Como executar

No bash (Git Bash/WSL):

``./gradlew :app:run --console=plain``

Observacao: o jogo e interativo e pede escolha de opcoes no terminal.

# Como rodar testes

No bash (Git Bash/WSL):

``./gradlew test``

# Cobertura de testes (JaCoCo)

Depois de rodar os testes, o relatorio HTML pode ser aberto em:

- `app/build/reports/jacoco/test/html/index.html`

O projeto tambem possui verificacao minima de cobertura no `check`.

# Build completo

``./gradlew clean check``
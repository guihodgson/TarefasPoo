# ProjetoPoo

Projeto em Java (Gradle) com foco em batalhas em modo texto, organizado no modulo `app`.
A classe principal e `ProjetoPoo.App`.

## Requisitos

- Java 21
- Gradle Wrapper (ja incluso no repositorio)

## Estrutura

- Codigo principal: `app/src/main/java/ProjetoPoo`
- Testes: `app/src/test/java/ProjetoPoo`
- Build e relatorios: `app/build`

## Como executar

No Windows (PowerShell/CMD):

```bat
gradlew.bat :app:run --console=plain
```

No bash (Git Bash/WSL):

```bash
./gradlew :app:run --console=plain
```

Observacao: o jogo e interativo e pede escolha de opcoes no terminal.

## Como rodar testes

No Windows (PowerShell/CMD):

```bat
gradlew.bat test
```

No bash (Git Bash/WSL):

```bash
./gradlew test
```

## Cobertura de testes (JaCoCo)

Depois de rodar os testes, o relatorio HTML pode ser aberto em:

- `app/build/reports/jacoco/test/html/index.html`

O projeto tambem possui verificacao minima de cobertura no `check`.

## Build completo

```bash
./gradlew clean check
```

No Windows, use `gradlew.bat clean check`.

## Notas

- O repositorio possui uma lista de pendencias em `Todo.txt`.
- Dependencias e versoes ficam em `gradle/libs.versions.toml`.

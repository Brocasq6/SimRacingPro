<div align="center">

# 🏁 SimRacingPro

**Gestão de equipa de sim racing / endurance em Java**

Projeto prático de **Programação Orientada aos Objectos** desenvolvido durante as férias 25/26 como exercício de consolidação do paradigma OO.

[![Skills](https://skillicons.dev/icons?i=java,git,github,vscode,idea)](https://skillicons.dev)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-21+-orange)


</div>

---

## 📖 Sobre o projeto

O **SimRacingPro** é uma aplicação de gestão de uma equipa de sim racing inspirada em plataformas como *iRacing*, *Assetto Corsa Competizione* e *Le Mans Ultimate*.

Permite criar e gerir equipas, pilotos e uma frota de carros de diferentes categorias (GT3, LMP2, Hypercar, GT4, TCR), e simular corridas com gestão de combustível, desgaste de pneus e paragens nas boxes.

Os utilizadores podem operar individualmente cada carro ou automatizar comportamentos através de **estratégias**, **planos de stint** e **configurações de sessão**.

## ✨ Funcionalidades

### Gestão de entidades
- 👥 Utilizadores com dois papéis: **chefes de equipa** (admin) e **engenheiros de corrida** (operadores)
- 🏎️ Hierarquia extensível de carros com comportamentos polimórficos por categoria
- 🏁 Equipas, pilotos e atribuição carro–piloto

### Simulação
- ⏱️ Simulação volta-a-volta com avanço de tempo controlado
- ⛽ Gestão de combustível e desgaste de pneus por categoria
- 🔧 Operações sobre carros: colocar em pista, chamar às boxes, mudar setup

### Automação
- ⚡ **Estratégias** condicionais (ex: pit se combustível < 2 voltas, mudar para *wets* em chuva)
- 📋 **Planos de stint** com distribuição de ritmo (push / fuel saving / push final)
- 🎯 **Configurações de sessão**: *Qualifying*, *Race Start*, *Safety Car*, *Full Wet*

### Análise e persistência
- 📊 Estatísticas: equipa com mais voltas, carros mais utilizados, melhores tempos médios, consumo total
- 💾 Persistência em ficheiros binários (load/save do estado completo)
- 🤖 Sugestão automática de estratégias e planos de stint baseada no histórico

## 🛠️ Stack

- **Java 21+**
- `java.util` — `Map`, `List`, `Set`, `Comparator`
- Serialização binária com `ObjectInputStream` / `ObjectOutputStream`
- Interação por menus em modo texto

## 🎓 Conceitos OO aplicados

- **Herança** e **classes abstractas** (hierarquia de carros)
- **Polimorfismo** (comportamento específico por categoria)
- **Interfaces** — `Comparable`, `Serializable`, interfaces funcionais para estratégias
- **Encapsulamento** e *deep cloning*
- **Streams** e **lambdas** para queries estatísticas
- **Padrões de design** — Factory para criação de carros, Strategy para estratégias

## 📁 Estrutura do projeto

```
SimRacingPro/
├── src/
│   ├── main/
│   │   ├── Main.java
│   │   │
│   │   ├── data/                          # Domínio (POJOs + lógica de negócio)
│   │   │   ├── carros/
│   │   │   │   ├── Carro.java             # abstract — base da hierarquia
│   │   │   │   ├── GT3.java
│   │   │   │   ├── GT4.java
│   │   │   │   ├── LMP2.java
│   │   │   │   ├── Hypercar.java          # com lógica híbrida (override)
│   │   │   │   ├── TCR.java
│   │   │   │   ├── Pneu.java
│   │   │   │   ├── TipoPneu.java          # enum: SLICK, INTER, WET
│   │   │   │   ├── EstadoCarro.java       # enum: BOX, PISTA, AVARIADO
│   │   │   │   └── CarroFactory.java      # Factory para criar por categoria
│   │   │   │
│   │   │   ├── equipas/
│   │   │   │   ├── Equipa.java
│   │   │   │   ├── Piloto.java
│   │   │   │   ├── Utilizador.java        # abstract
│   │   │   │   ├── ChefeEquipa.java       # admin
│   │   │   │   └── EngenheiroCorrida.java # operador
│   │   │   │
│   │   │   ├── corrida/
│   │   │   │   ├── Corrida.java           # "motor" da simulação
│   │   │   │   ├── Volta.java
│   │   │   │   ├── Stint.java
│   │   │   │   ├── Sessao.java
│   │   │   │   ├── Pista.java
│   │   │   │   └── CondicoesMeteo.java    # enum: SECO, CHUVA, MISTO
│   │   │   │
│   │   │   ├── estrategias/
│   │   │   │   ├── Estrategia.java        # interface funcional
│   │   │   │   ├── EstrategiaPit.java
│   │   │   │   ├── EstrategiaMudancaPneus.java
│   │   │   │   ├── PlanoStint.java
│   │   │   │   └── Ritmo.java             # enum: PUSH, NORMAL, FUEL_SAVING
│   │   │   │
│   │   │   ├── configuracoes/
│   │   │   │   ├── ConfiguracaoSessao.java # abstract
│   │   │   │   ├── ConfigQualifying.java
│   │   │   │   ├── ConfigRaceStart.java
│   │   │   │   ├── ConfigSafetyCar.java
│   │   │   │   └── ConfigFullWet.java
│   │   │   │
│   │   │   └── estatisticas/
│   │   │       ├── EstatisticasEquipa.java
│   │   │       ├── EstatisticasPiloto.java
│   │   │       └── HistoricoCorridas.java
│   │   │
│   │   ├── controllers/                   # Lógica entre menus ↔ domínio
│   │   │   ├── AppController.java         # estado global da aplicação
│   │   │   ├── EquipaController.java
│   │   │   ├── CarroController.java
│   │   │   ├── CorridaController.java
│   │   │   └── EstatisticasController.java
│   │   │
│   │   ├── menus/                         # Interface texto
│   │   │   ├── MenuPrincipal.java
│   │   │   ├── MenuEquipas.java
│   │   │   ├── MenuCarros.java
│   │   │   ├── MenuCorrida.java
│   │   │   ├── MenuEstrategias.java
│   │   │   └── utils/
│   │   │       └── Input.java             # leitura segura do Scanner
│   │   │
│   │   ├── persistencia/
│   │   │   ├── GestorPersistencia.java    # save/load com ObjectStreams
│   │   │   └── EstadoApp.java             # wrapper Serializable do estado
│   │   │
│   │   └── exceptions/
│   │       ├── CarroNaoEncontradoException.java
│   │       ├── EquipaNaoEncontradaException.java
│   │       ├── PilotoIndisponivelException.java
│   │       └── EstrategiaInvalidaException.java
│   │
│   └── tests/                             # JUnit
│       ├── CarroTest.java
│       ├── EquipaTest.java
│       ├── CorridaTest.java
│       └── EstrategiaTest.java
│
├── data/
│   └── estado_teste.dat                   # estado pré-carregado para testar
│
├── docs/
│   ├── diagrama-classes.png
│   ├── enunciado.pdf
│   └── relatorio.pdf
│
├── lib/                                   # JUnit jars (se não usares Maven)
├── bin/                                   # compilados (ignorado pelo git)
├── Makefile
├── .gitignore
└── README.md
```

## 🚀 Como executar

### Pré-requisitos
- JDK 21 ou superior
- Make (opcional, para usar o Makefile)

### Compilar e correr

```bash
# Clonar o repositório
git clone https://github.com/Brocasq6/SimRacingPro.git
cd SimRacingPro

# Compilar
javac -d bin src/main/**/*.java

# Executar
java -cp bin main.Main
```

### Carregar estado de teste

Na primeira execução, escolher no menu principal:
```
> Carregar estado > data/estado_teste.dat
```

## 📋 Estado de desenvolvimento

- [x] Estrutura base e diagrama de classes
- [ ] Gestão de entidades (utilizadores, equipas, carros, pilotos)
- [ ] Operações sobre carros e simulação volta-a-volta
- [ ] Estatísticas e persistência em ficheiro
- [ ] Estratégias, planos de stint e configurações de sessão
- [ ] Geração automática de sugestões
- [ ] Relatório final e diagrama de classes

## 👤 Autor

**Bruno Freitas (Bino)** — Licenciatura em Ciências da Computação @ Universidade do Minho

[![GitHub](https://img.shields.io/badge/GitHub-Brocasq6-181717?style=flat&logo=github)](https://github.com/Brocasq6)

---

<div align="center">
<sub>🏎️ Made with caffeine and the sound of a V8 at 8000 rpm</sub>
</div>

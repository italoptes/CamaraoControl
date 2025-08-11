# 🦐 Gerenciador de Fazendas de Camarão (CamaraoControl)

Um sistema web para auxiliar proprietários e funcionários de fazendas aquícolas no **controle de dados, métricas e processos** relacionados ao cultivo de camarões.  
Com ele, é possível monitorar **qualidade da água**, **gestão de ração** e **biometria dos camarões**, ajudando a melhorar a eficiência e a sustentabilidade da produção.

---

## 📋 Sumário
- [🚀 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🎯 Funcionalidades](#-funcionalidades)
- [📐 Arquitetura do Sistema](#-arquitetura-do-sistema)
- [📂 Estrutura de Pastas](#-estrutura-de-pastas)
- [⚙️ Instalação e Execução](#️-instalação-e-execução)
- [📊 Cálculos Importantes](#-cálculos-importantes)
- [📌 Status do Projeto](#-status-do-projeto)
- [📜 Licença](#-licença)

---

## 🚀 Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework Web:** [Javalin](https://javalin.io/)
- **Template Engine:** [Thymeleaf](https://www.thymeleaf.org/)
- **Arquitetura:** MVC (Model-View-Controller)
- **Gerenciamento de dependências:** Maven
- **Banco de Dados:** (Definir conforme implementação)
- **Plataforma:** Servidor Web

---

## 🎯 Funcionalidades

### 1. Controle da Qualidade da Água
- Registro e consulta de parâmetros:
    - Amônia
    - Nitrito
    - pH
    - Alcalinidade
    - Salinidade
    - Oxigênio Dissolvido
- Histórico e análise comparativa dos dados

### 2. Gestão de Ração
- Controle de estoque de ração
- Registro do consumo diário
- Atualização automática das quantidades disponíveis

### 3. Biometria dos Camarões
- Coleta de dados de crescimento (peso médio, amostragens)
- Estimativa de sobrevivência com base no consumo de ração
- Cálculo automático do **FCA (Fator de Conversão Alimentar)**

---

## 📊 Cálculos Importantes
O sistema calcula automaticamente o **FCA**:

```
FCA = Ração Fornecida / Biomassa Produzida
```

- **Ração Fornecida**: total de alimento disponibilizado aos camarões (em kg)
- **Biomassa Produzida**: peso total de camarões vivos no tanque (em kg)

Esse indicador é essencial para medir a eficiência alimentar e otimizar custos.

---

## 📐 Arquitetura do Sistema
O projeto segue o padrão **MVC**:

- **Model** → Representa os dados e regras de negócio (`src/main/java/model`)
- **View** → Interface web construída com HTML + Thymeleaf (`src/main/resources/templates`)
- **Controller** → Camada intermediária que recebe as requisições e coordena as respostas (`src/main/java/controller`)
- **Service** → Camada de lógica e regras de negócio (`src/main/java/service`)
- **Repository** → Acesso e manipulação dos dados (`src/main/java/repository`)

---

## 📂 Estrutura de Pastas

```
CamaraoControl
 ├── pom.xml
 ├── src
 │   ├── main
 │   │   ├── java
 │   │   │   ├── controller
 │   │   │   ├── model
 │   │   │   ├── repository
 │   │   │   ├── service
 │   │   │   └── Main.java
 │   │   └── resources
 │   │       ├── templates (Thymeleaf)
 │   │       └── static (CSS, JS, imagens)
 │   └── test (testes unitários)
 └── README.md
```

---

## ⚙️ Instalação e Execução

1. **Clonar o repositório**
```bash
git clone https://github.com/seu-usuario/CamaraoControl.git
```

2. **Acessar o diretório do projeto**
```bash
cd CamaraoControl
```

3. **Compilar e executar**
```bash
mvn clean install
mvn exec:java
```

4. **Acessar no navegador**
```
http://localhost:7000
```

---

## 📌 Status do Projeto
🚧 **Em desenvolvimento** – novas funcionalidades e melhorias estão sendo implementadas.

---

## 📜 Licença
Este projeto é distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

💡 *Desenvolvido para ajudar fazendas de camarão a produzirem de forma mais eficiente e sustentável.*

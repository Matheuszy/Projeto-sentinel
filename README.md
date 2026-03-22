# 🛡️ Sentinel: Real-Time Fraud Detection System

O **Sentinel** é uma solução completa para monitoramento de transações financeiras. Ele utiliza uma arquitetura baseada em eventos para garantir baixa latência e alta escalabilidade.

## 🏗️ Arquitetura do Sistema
O sistema é dividido em dois serviços principais que se comunicam via mensageria:

1.  **Sentinel API (Java/Spring Boot):** Recebe as transações via REST, persiste no PostgreSQL e as encaminha para uma fila de análise.
2.  **Sentinel ML (Python/Scikit-Learn):** Consome as transações da fila e aplica um modelo de *Isolation Forest* para classificar a transação como Legítima ou Fraude.



## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot, Spring Data JPA, Spring AMQP.
- **Machine Learning:** Python 3.12, Scikit-Learn, Pandas, Joblib.
- **Infraestrutura:** RabbitMQ (Mensageria), PostgreSQL (Banco de Dados), Docker & Docker Compose.

## 🚀 Como Executar
### Pré-requisitos
- Docker e Docker Compose instalados.
- Python 3.10+ instalado.

### Passo 1: Subir a Infraestrutura e API
Na raiz do projeto, execute:
```bash
docker-compose up --build -d

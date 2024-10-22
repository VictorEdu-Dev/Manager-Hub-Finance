# ManagerHubFinance

## Descrição

Este projeto é um módulo financeiro de um sistema ERP, desenvolvido em Java com Maven. Gerencia transações financeiras e contábeis, incluindo contas a pagar/receber, fluxo de caixa, faturas, relatórios financeiros e planejamento. Utiliza Hibernate como ORM para interação com o banco de dados.

## Tecnologias Utilizadas

- Java 17
- Maven 3.9.6
- Jakarta Persistence API (JPA) 3.1
- Hibernate 7.0.0.Alpha2
- WildFly 32
- PostgreSQL 16.3

## Configuração do Ambiente de Desenvolvimento

### Instalação do Maven:

Para instalar o Maven, siga as instruções disponíveis na documentação oficial.
Pode ser utilizado um ambiente de desenvolvimento com Maven integrado como Eclipse IDE ou IntelliJ IDE.

### Configuração do PostgreSQL:

- Instale o PostgreSQL 16.3 ou outra versão compatível através do site oficial PostgreSQL.
- Crie um banco de dados para o projeto:
  
  ```sql
  CREATE DATABASE manager_hub_finance;
  ```

  - Ou permita que o Hibernate gerencie esse recurso que já está configurado no persistence.xml, por meio do auto schema generation.

### Configuração do WildFly 32:

- Baixe e instale o WildFly 32 a partir do site oficial WildFly.
- Adicione o driver JDBC do PostgreSQL ao WildFly:

  ```bash
  cp postgresql-42.x.xx.jar $WILDFLY_HOME/standalone/deployments/
  ```

- Configurar o Datasource no WildFly:

  No standalone.xml, adicione a configuração do datasource:

  ```xml
  <datasource jndi-name="java:/jdbc/PostgreSQL" pool-name="PostgreSQL" enabled="true" use-java-context="true">
      <connection-url>jdbc:postgresql://localhost:5432/erp_finance</connection-url>
      <driver>postgresql</driver>
      <security>
          <user-name>seu_usuario</user-name>
          <password>sua_senha</password>
      </security>
  </datasource>
  ```

- Estas configurações podem ser feitas por meio do console de administração do WildFly. Pode-se consultar a documentação oficial para mais informações.

## Como Executar

Siga os passos abaixo para executar o projeto:

1. **Compile o projeto com Maven:**

   ```bash
   mvn clean install
   ```

2. **Implante no WildFly:**

   Copie o arquivo WAR gerado na pasta target para o diretório de deployments do WildFly:

   ```bash
   cp target/erp-finance.war $WILDFLY_HOME/standalone/deployments/
   ```

3. **Inicie o servidor WildFly:**

   ```bash
   $WILDFLY_HOME/bin/standalone.sh
   ```

4. **Acesse a aplicação:**

   Abra o navegador e vá para [http://localhost:8080/ManagerHubFinance](http://localhost:8080/ManagerHubFinance).

5. **Alternativa:**

Basta integrar ao ambiente de desenvolvimento o clone do projeto, o servidor de banco de dados do PostgreSQL, o servidor de aplicação e iniciá-lo. 
Pode ser executado em contêiner como Docker. Consulte a documentação oficial do Docker.

## Como Contribuir

Se você deseja contribuir com o projeto, siga os passos abaixo:

1. **Faça um fork do repositório.**
2. **Clone o seu fork:**

   ```bash
   git clone https://github.com/seu-usuario/repositorio.git
   ```

3. **Crie uma branch para sua feature ou correção de bug:**

   ```bash
   git checkout -b minha-feature
   ```

4. **Faça as alterações necessárias e commit:**

   ```bash
   git commit -m "Descrição das mudanças"
   ```

5. **Envie as alterações para o seu fork:**

   ```bash
   git push origin minha-feature
   ```

6. **Abra um Pull Request no repositório original.**

## Licença

Este projeto está licenciado sob a [Eclipse Public License - v 2.0](LICENSE).

## Contato

Para mais informações ou dúvidas, entre em contato:

- **Nome:** Victor Eduardo
- **Email:** [victorepc.dev@gmail.com](mailto:victorepc.devdev@gmail.com)


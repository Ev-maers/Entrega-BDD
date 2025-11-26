# História de Usuário -- Favoritar Produtos

## 1. A História de Usuário (User Story)

**Título:** Favoritar Produtos para Lista de Interesses

**Narrativa:**\
Como um comprador logado no Marketplace, quero favoritar produtos, para
que eu possa criar uma lista de interesse e acessá-los mais tarde.

### Princípios INVEST

-   **Independent:** A funcionalidade de favoritar é autônoma e não
    depende diretamente de outras funções como carrinho ou checkout.\
-   **Negotiable:** Detalhes da interface podem ser alterados sem afetar
    a funcionalidade principal.\
-   **Valuable:** Permite organização e facilita compras futuras.\
-   **Estimable:** Esforço estimável --- envolve adicionar botão/ícone e
    persistência.\
-   **Small:** Escopo inicial limitado a adicionar/remover favoritos.\
-   **Testable:** Fácil de testar com BDD.

### Princípios SMART

-   **Specific:** Define claramente a ação de favoritar.\
-   **Measurable:** Medido pela capacidade de favoritar, desfavoritar e
    visualizar.\
-   **Achievable:** Funcionalidade comum e viável.\
-   **Relevant:** Aumenta retenção e engajamento.\
-   **Time-bound:** Pode ser entregue em um sprint.

------------------------------------------------------------------------

## 2. Cenários de Uso (Gherkin)

Os cenários Gherkin foram criados com base na história e levam em conta
as interações típicas de um usuário em uma aplicação desktop Swing.

*(Conteúdo dos cenários em `favorite.feature`.)*

------------------------------------------------------------------------

## 3. Implementação de Teste (BDD)

### Dependências no `pom.xml`

-   `io.cucumber:cucumber-java`
-   `io.cucumber:cucumber-junit-platform-engine`
-   `io.cucumber:cucumber-spring`

### Arquivos adicionados

-   `favorite.feature` --- cenários Gherkin\
-   `CucumberSpringConfiguration.java` --- ativa contexto SpringBoot\
-   `RunCucumberTest.java` --- runner do JUnit Platform\
-   `FavoriteSteps.java` --- step definitions

### Fluxo do cenário "Adicionar produto aos favoritos"

-   **Background:** garante que existe produto (via `data.sql`).\
-   **Quando:** faz POST para `/api/favorites`.\
-   **Então:** faz GET em `/api/favorites?username=alice` e verifica
    presença do produto.

### Pontos importantes

-   Runner usa glue `com.replayce.backend.bdd`.\
-   `CucumberSpringConfiguration` usa
    `@SpringBootTest(webEnvironment = RANDOM_PORT)` para habilitar
    `TestRestTemplate`.

### Como rodar os testes

``` bash
mvn test
```

Para saída mais verbosa:

``` bash
mvn -DskipTests=false test
```

------------------------------------------------------------------------

## 4. Repositório do Projeto BDD

Repositório: **https://github.com/Ev-maers/Entrega-BDD** (branch `main`)

### Arquivos adicionados/alterados

-   `pom.xml`
-   `favorite.feature`
-   `CucumberSpringConfiguration.java`
-   `RunCucumberTest.java`
-   `FavoriteSteps.java`

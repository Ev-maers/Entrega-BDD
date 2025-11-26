# Documentação do Projeto BDD: Favoritar Produtos

## 1. A História de Usuário (User Story)

### Título
Favoritar Produtos para Lista de Interesses

### Narrativa
> Como um comprador logado no Marketplace,
> Quero favoritar produtos,
> Para que eu possa criar uma lista de interesse e acessá-los mais tarde.

### Princípios INVEST

* **Independent:** A funcionalidade de favoritar é autônoma e não depende diretamente de outras funções como carrinho de compras ou processo de checkout.
* **Negotiable:** Detalhes da interface (como o ícone de coração, estrela, cor) podem ser discutidos e alterados sem afetar o core da funcionalidade.
* **Valuable:** Agrega valor ao usuário, permitindo organização e facilitando futuras compras.
* **Estimable:** O esforço pode ser razoavelmente estimado, pois envolve a adição de um botão/ícone e a lógica de persistência.
* **Small:** O escopo inicial é limitado a adicionar/remover favoritos.
* **Testable (BDD):** Facilmente testável usando BDD, como demonstrado a seguir.

### Princípios SMART

* **Specific:** Claramente define a ação (favoritar produtos).
* **Measurable:** O sucesso pode ser medido pela capacidade de favoritar, desfavoritar e visualizar a lista de favoritos.
* **Achievable:** É uma funcionalidade comum em e-commerce e totalmente viável.
* **Relevant:** Ajuda na retenção de usuários e no engajamento com a plataforma.
* **Time-bound:** Pode ser entregue dentro de um sprint, junto com o fluxo de navegação ou exibição de produtos.

***

## 2. Os Cenários de Uso (Gherkin)

Com base na história e nas suas descrições, criei os cenários Gherkin. Para uma aplicação desktop Swing, é importante pensar nas interações do usuário com a interface gráfica.

*(Nota: Os cenários Gherkin não foram fornecidos no texto original para esta seção)*

***

## 3. Como Implementar o Teste para pelo menos um dos cenários?

### Dependências no pom.xml:

(Assegure que a propriedade `cucumber.version` esteja definida)

```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit-platform-engine</artifactId>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-spring</artifactId>
</dependency>

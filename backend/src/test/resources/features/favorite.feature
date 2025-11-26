Feature: Favoritar Produtos
  Como um comprador logado
  Eu quero favoritar produtos para criar uma lista de interesse e acessá-los depois

  Background:
    Dado que existe um produto com id 1
    E o usuário "alice" está logado

  Scenario: Adicionar produto aos favoritos
    Quando o usuário "alice" favoritar o produto com id 1
    Então o produto com id 1 deve aparecer na lista de favoritos de "alice"

  Scenario: Remover produto dos favoritos
    Quando o usuário "alice" favoritar o produto com id 1
    E o usuário "alice" remover o favorito do produto com id 1
    Então o produto com id 1 não deve aparecer na lista de favoritos de "alice"

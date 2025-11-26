package com.replayce.backend.bdd;

import com.replayce.backend.model.Product;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FavoriteSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<?> lastResponse;

    @Dado("que existe um produto com id {long}")
    public void existe_um_produto(Long id) {
        ResponseEntity<Product> r = restTemplate.getForEntity("/api/products/" + id, Product.class);
        assertTrue(r.getStatusCode().is2xxSuccessful(), "Produto com id " + id + " deve existir");
    }

    @Dado("o usuário {string} está logado")
    public void usuario_esta_logado(String username) {
        // Autenticação não implementada neste projeto; usar apenas o identificador username
        assertNotNull(username);
    }

    @Quando("o usuário {string} favoritar o produto com id {long}")
    public void favoritar_produto(String username, Long productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String body = String.format("{\"username\":\"%s\",\"productId\":%d}", username, productId);
        lastResponse = restTemplate.postForEntity("/api/favorites", new HttpEntity<>(body, headers), Object.class);
        assertTrue(lastResponse.getStatusCode().is2xxSuccessful(), "POST /api/favorites deve retornar 200 OK");
    }

    @Quando("o usuário {string} remover o favorito do produto com id {long}")
    public void remover_favorito(String username, Long productId) {
        String url = String.format("/api/favorites?username=%s&productId=%d", username, productId);
        lastResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
        assertTrue(lastResponse.getStatusCode().is2xxSuccessful() || lastResponse.getStatusCode().is2xxSuccessful());
    }

    @Então("o produto com id {long} deve aparecer na lista de favoritos de {string}")
    public void produto_deve_estar_nos_favoritos(Long productId, String username) {
        String url = String.format("/api/favorites?username=%s", username);
        ResponseEntity<Product[]> r = restTemplate.getForEntity(url, Product[].class);
        assertTrue(r.getStatusCode().is2xxSuccessful());
        Product[] products = r.getBody();
        assertNotNull(products);
        boolean found = Arrays.stream(products).anyMatch(p -> p.getId().equals(productId));
        assertTrue(found, "Produto com id " + productId + " deveria estar nos favoritos de " + username);
    }

    @Então("o produto com id {long} não deve aparecer na lista de favoritos de {string}")
    public void produto_nao_deve_estar_nos_favoritos(Long productId, String username) {
        String url = String.format("/api/favorites?username=%s", username);
        ResponseEntity<Product[]> r = restTemplate.getForEntity(url, Product[].class);
        assertTrue(r.getStatusCode().is2xxSuccessful());
        Product[] products = r.getBody();
        if (products != null) {
            boolean found = Arrays.stream(products).anyMatch(p -> p.getId().equals(productId));
            assertFalse(found, "Produto com id " + productId + " não deveria estar nos favoritos de " + username);
        }
    }
}

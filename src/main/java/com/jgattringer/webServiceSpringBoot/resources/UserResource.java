package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.User;
import com.jgattringer.webServiceSpringBoot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// Define esta classe como um controlador REST
@RestController
// Define o mapeamento de URL base para todas as solicitações nesta classe
@RequestMapping(value = "/users")
public class UserResource {

    // Injeta uma instância de UserServices automaticamente gerenciada pelo Spring
    @Autowired
    private UserServices service;

    // Mapeia a solicitação GET para "/users" para retornar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        // Chama o serviço para encontrar todos os usuários
        List<User> list = service.findAll();

        // Retorna uma resposta HTTP com a lista de usuários encontrados
        return ResponseEntity.ok().body(list);
    }

    // Mapeia a solicitação GET para "/users/{id}" para retornar um usuário específico pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        // Chama o serviço para encontrar o usuário pelo ID especificado
        User obj = service.findByI(id);

        // Retorna uma resposta HTTP com o usuário encontrado
        return ResponseEntity.ok().body(obj);
    }

    // Mapeia a solicitação POST para "/users" para inserir um novo usuário
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        // Chama o serviço para inserir o usuário
        obj = service.insert(obj);

        // Cria a URI para o novo usuário inserido
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        // Retorna uma resposta HTTP com o status CREATED e a URI do novo usuário
        return ResponseEntity.created(uri).body(obj);
    }

    // Mapeia a solicitação DELETE para "/users/{id}" para excluir um usuário pelo ID
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        // Chama o serviço para excluir o usuário pelo ID especificado
        service.delete(id);

        // Retorna uma resposta HTTP com o status NO CONTENT
        return ResponseEntity.noContent().build();
    }

    // Mapeia a solicitação PUT para "/users/{id}" para atualizar um usuário pelo ID
    @PutMapping(value = "/{id}")
    public  ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        // Chama o serviço para atualizar o usuário pelo ID especificado
        obj = service.update(id, obj);

        // Retorna uma resposta HTTP com o usuário atualizado
        return ResponseEntity.ok().body(obj);
    }
}

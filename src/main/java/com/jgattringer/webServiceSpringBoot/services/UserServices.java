package com.jgattringer.webServiceSpringBoot.services;

import com.jgattringer.webServiceSpringBoot.entities.User;
import com.jgattringer.webServiceSpringBoot.repositories.UserRepository;
import com.jgattringer.webServiceSpringBoot.services.exceptions.DataBaseException;
import com.jgattringer.webServiceSpringBoot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação para indicar que esta classe é um componente de serviço
@Service
public class UserServices {

    // Injeção de dependência do repositório de usuários
    @Autowired
    private UserRepository repository;

    // Método para buscar todos os usuários
    public List<User> findAll() {
        return repository.findAll();
    }

    // Método para buscar um usuário por ID
    public User findByI(Long id) {
        // Busca o usuário pelo ID no repositório
        Optional<User> obj = repository.findById(id);
        // Retorna o usuário, se presente, ou lança uma exceção se não encontrado
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Método para inserir um novo usuário
    public User insert(User obj){
        // Salva o usuário no repositório
        return repository.save(obj);
    }

    // Método para deletar um usuário por ID
    public void delete(Long id) {
        try {
            // Tenta deletar o usuário pelo ID
            repository.deleteById(id);
        }
        // Captura a exceção de quando não é encontrado nenhum usuário com o ID fornecido
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        // Captura a exceção de violação de integridade de dados
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    // Método para atualizar um usuário
    public User update(Long id, User obj){
        try{
            // Obtém a referência do usuário pelo ID
            User entity = repository.getReferenceById(id);
            // Atualiza os dados do usuário com os fornecidos
            updateData(entity, obj);
            // Salva e retorna o usuário atualizado
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            // Lança exceção se o usuário não for encontrado
            throw new ResourceNotFoundException(id);
        }

    }

    // Método auxiliar para atualizar os dados do usuário
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

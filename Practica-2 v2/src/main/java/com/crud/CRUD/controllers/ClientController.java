package com.crud.CRUD.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CRUD.models.ClientModel;
import com.crud.CRUD.services.ClientServices;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    
    @Autowired
    private ClientServices userService;

    @GetMapping
    public ArrayList<ClientModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public ClientModel saveUser(@RequestBody ClientModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClientModel> getUserById(@PathVariable Long id){
        return this.userService.getById(id); 
    }

    @PutMapping(path = "/{id}")
    public ClientModel updateUserById(@RequestBody ClientModel request, @PathVariable Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUserById(id);
        if(ok){
            return "Usuario eliminado correctamente";
        }else{
            return "El usuario no pudo ser eliminado";
        }
    }
}

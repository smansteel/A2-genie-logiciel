package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.entities.dao.UserEntity;
import fr.genepisep.icompetences.services.EntityService;
import fr.genepisep.icompetences.services.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends EntityController<UserEntity, UserService> {
    protected UserController(UserService entityService) {
        super(entityService);
    }
}

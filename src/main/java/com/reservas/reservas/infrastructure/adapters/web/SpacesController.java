package com.reservas.reservas.infrastructure.adapters.web;

import com.reservas.reservas.domain.model.Space;
import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.in.SpaceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaces")
@AllArgsConstructor
public class SpacesController {
    private final SpaceUseCase spaceUseCase;

    @GetMapping
    public ResponseEntity<List<Space>> getAllSpaces() {
        List<Space> spaces = spaceUseCase.getAllSpaces();
        return ResponseEntity.ok(spaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Space> getSpace(@PathVariable Long id) {
        Space space = spaceUseCase.findById(id);
        return ResponseEntity.ok(space);
    }

    @PostMapping
    public ResponseEntity<Space> createUser(@RequestBody Space space) {
        Space createdSpace = spaceUseCase.createSpace(space);
        return ResponseEntity.ok(createdSpace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Space> updateUser(@PathVariable Long id, @RequestBody Space space) {
        Space updatedSpace = spaceUseCase.updateSpace(space,id);
        return ResponseEntity.ok(updatedSpace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        spaceUseCase.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }
}

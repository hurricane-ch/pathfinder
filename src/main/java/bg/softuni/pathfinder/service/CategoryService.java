package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.model.Category;

import bg.softuni.pathfinder.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Set<Category> getAllByNameIn(Set<CategoryNames> categoryNames) {

        return categoryRepository.getAllByNameIn(categoryNames);
    }
}

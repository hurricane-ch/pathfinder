package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.model.Category;

import bg.softuni.pathfinder.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Set<Category> getAllByNameIn(Set<CategoryNames> categoryNames) {
       Set<Category> categories = new LinkedHashSet<>();
         for (CategoryNames categoryName : categoryNames) {
             Category category = categoryRepository.findByName(categoryName);
              categories.add(category);
         }
        return categories;
    }
}

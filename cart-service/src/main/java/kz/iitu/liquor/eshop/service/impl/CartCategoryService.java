package kz.iitu.liquor.eshop.service.impl;

import kz.iitu.liquor.eshop.dto.CartCategoryDTO;
import kz.iitu.liquor.eshop.model.CartCategory;
import kz.iitu.liquor.eshop.repository.CartCategoryRepository;
import kz.iitu.liquor.eshop.service.ICartCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CartCategoryService implements ICartCategoryService {

    private final CartCategoryRepository categoryRepository;

    @Override
    public CartCategory save(CartCategoryDTO cartCategoryDTO) {
        CartCategory cartCategory;

        log.info("start saving cart category");

        if (cartCategoryDTO.getId() == null) {
            cartCategory = CartCategory.builder()
                    .categoryName(cartCategoryDTO.getCategoryName())
                    .build();
        } else {
            cartCategory = getById(cartCategoryDTO.getId());
            cartCategory.setCategoryName(cartCategoryDTO.getCategoryName());
        }

        CartCategory savedCartCategory = categoryRepository.saveAndFlush(cartCategory);

        log.info("saved cart category = " + savedCartCategory.getId());

        return savedCartCategory;
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CartCategory getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public List<CartCategory> getAll() {
        return categoryRepository.findAll();
    }
}

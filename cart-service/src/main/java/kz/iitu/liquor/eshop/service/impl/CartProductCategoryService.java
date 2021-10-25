package kz.iitu.liquor.eshop.service.impl;

import kz.iitu.liquor.eshop.dto.CartProductCategoryDTO;
import kz.iitu.liquor.eshop.model.CartProductCategory;
import kz.iitu.liquor.eshop.repository.CartProductCategoryRepository;
import kz.iitu.liquor.eshop.service.ICartProductCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartProductCategoryService implements ICartProductCategoryService {

    private final CartProductCategoryRepository productCategoryRepository;

    @Override
    public CartProductCategory save(CartProductCategoryDTO cartProductCategoryDTO) {
        CartProductCategory cartProductCategory;

        if (cartProductCategoryDTO.getId() == null) {
            cartProductCategory = CartProductCategory.builder()
                    .categoryName(cartProductCategoryDTO.getCategoryName())
                    .build();
        } else {
            cartProductCategory = getById(cartProductCategoryDTO.getId());
            cartProductCategory.setCategoryName(cartProductCategoryDTO.getCategoryName());
        }

        CartProductCategory savedCartProductCategory = productCategoryRepository.saveAndFlush(cartProductCategory);

        log.info("savedCartProductCategory " + savedCartProductCategory.getId());

        return savedCartProductCategory;
    }

    @Override
    public void deleteById(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public CartProductCategory getById(Long id) {
        return productCategoryRepository.getById(id);
    }

    @Override
    public List<CartProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }
}

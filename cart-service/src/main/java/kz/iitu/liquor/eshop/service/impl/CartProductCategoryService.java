package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartProductCategoryDTO;
import kz.app.cart.shopping.model.CartProductCategory;
import kz.app.cart.shopping.repository.CartProductCategoryRepository;
import kz.app.cart.shopping.service.ICartProductCategoryService;
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

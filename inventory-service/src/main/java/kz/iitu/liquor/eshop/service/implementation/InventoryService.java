package kz.app.cart.shopping.config;

import kz.iitu.liquor.eshop.dto.InventoryDTO;
import kz.iitu.liquor.eshop.model.InventoryItem;
import kz.iitu.liquor.eshop.repository.InventoryItemRepository;
import kz.iitu.liquor.eshop.service.InventoryServiceI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InventoryService implements InventoryServiceI {

    private final InventoryItemRepository inventoryItemRepository;

    final String orderApi = "http://localhost:8086/order/";


    private Object runGetMethod(String url, Object object) {
        log.info("get method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    object.getClass());
            log.info("responseEntity in GET METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in GET method : " + e.getLocalizedMessage());
            return null;
        }
    }

    private Object runPostMethod(String url, Object body, Object object) {
        log.info("post method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(body, headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    object.getClass());
            log.info("responseEntity in POST METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in POST method : " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Inventory save(InventoryDTO inventoryDTO) {
        Inventory inventory;
        log.info("Start save method");

        if (inventoryDTO.getId() == null) {
            log.info("new inventory");
            inventory = Inventory.builder()
                    .productCode(inventoryDTO.getProductCode())
                    .quantity(inventoryDTO.getQuantity())
                    .build();
        } else {
            log.info("not new inventory");
            inventory = getById(inventoryDTO.getId());

            inventory.setProductCode(inventoryDTO.getProductCode());
            inventory.setQuantity(inventoryDTO.getQuantity());
        }

        Inventory savedInventory = inventoryItemRepository.saveAndFlush(inventory);
        log.info("savedInventory = " + savedInventory.getId());

        return savedInventory;
    }

    @Override
    public void deleteById(Long id) {
        inventoryItemRepository.deleteById(id);
    }

    @Override
    public Inventory getById(Long id) {
        return inventoryItemRepository.getById(id);
    }

    @Override
    public List<Inventory> getAll() {
        return inventoryItemRepository.findAll();
    }
}
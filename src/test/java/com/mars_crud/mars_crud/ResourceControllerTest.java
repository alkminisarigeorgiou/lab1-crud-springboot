package com.mars_crud.mars_crud;

import com.mars_crud.mars_crud.controller.ResourceController;
import com.mars_crud.mars_crud.entity.Resource;
import com.mars_crud.mars_crud.repository.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class resourceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceController resourceController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();
    }

    @Test
    void testShowAddForm() throws Exception {
        mockMvc.perform(get("/resources/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testAddresource() throws Exception {
        when(resourceRepository.save(any(Resource.class))).thenReturn(new Resource(1,"nametest",25,"descriptiontest"));

        mockMvc.perform(post("/resources/add")
                        .param("name", "nametest")
                        .param("quantity", "25")
                        .param("description", "descriptiontest"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testShowEditForm() throws Exception {
        Resource resource = new Resource(2,"nametest2",20,"descriptiontest2");
        resource.setId(3);
        when(resourceRepository.findById(3)).thenReturn(Optional.of(resource));

        mockMvc.perform(get("/resources/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testEditresource() throws Exception {
        Resource resource = new Resource(3,"nametest3",10,"descriptiontest3");
        resource.setId(4);
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);

        mockMvc.perform(post("/resources/edit/1")
                .param("name", "nametest3")
                .param("quantity", "10")
                .param("description", "descriptiontest3"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testDeleteresource() throws Exception {
        mockMvc.perform(get("/resources/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));

        Mockito.verify(resourceRepository).deleteById(1);
    }
}

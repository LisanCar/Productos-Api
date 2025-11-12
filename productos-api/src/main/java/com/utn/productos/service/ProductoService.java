package com.utn.productos.service;

import com.utn.productos.dto.ProductoDTO;
import com.utn.productos.dto.ProductoResponseDTO;
import com.utn.productos.dto.ActualizarStockDTO;
import com.utn.productos.exception.ProductoNotFoundException;
import com.utn.productos.exception.StockInsufficientException;
import com.utn.productos.model.Producto;
import com.utn.productos.model.Categoria;
import com.utn.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoResponseDTO crearProducto(ProductoDTO dto) {
        Producto producto = convertirAEntidad(dto);
        Producto guardado = productoRepository.save(producto);
        return convertirAResponseDTO(guardado);
    }

    public List<ProductoResponseDTO> obtenerTodos() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductoResponseDTO> obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .map(this::convertirAResponseDTO);
    }

    public List<ProductoResponseDTO> obtenerPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria)
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO actualizarProducto(Long id, ProductoDTO dto) {
        return productoRepository.findById(id)
                .map(p -> {
                    p.setNombre(dto.getNombre());
                    p.setDescripcion(dto.getDescripcion());
                    p.setPrecio(dto.getPrecio());
                    p.setStock(dto.getStock());
                    p.setCategoria(dto.getCategoria());
                    Producto actualizado = productoRepository.save(p);
                    return convertirAResponseDTO(actualizado);
                })
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public ProductoResponseDTO actualizarStock(Long id, ActualizarStockDTO dto) {
        return productoRepository.findById(id)
                .map(p -> {
                    if (dto.getStock() < 0) {
                        throw new StockInsufficientException("El stock no puede ser negativo");
                    }
                    p.setStock(dto.getStock());
                    Producto actualizado = productoRepository.save(p);
                    return convertirAResponseDTO(actualizado);
                })
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        productoRepository.deleteById(id);
    }

    private Producto convertirAEntidad(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }

    private ProductoResponseDTO convertirAResponseDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria()
        );
    }
}
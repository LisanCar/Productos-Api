package com.utn.productos.dto;

import com.utn.productos.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para devolver información completa de un producto")
public class ProductoResponseDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Monitor Samsung 27 pulgadas")
    private String nombre;

    @Schema(description = "Descripción detallada del producto", example = "Pantalla LED full HD con frecuencia de 144Hz")
    private String descripcion;

    @Schema(description = "Precio del producto", example = "299.99")
    private Double precio;

    @Schema(description = "Cantidad disponible en stock", example = "20")
    private Integer stock;

    @Schema(description = "Categoría del producto", example = "ELECTRONICA")
    private Categoria categoria;
}
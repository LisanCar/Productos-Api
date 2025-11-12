package com.utn.productos.dto;

import com.utn.productos.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para crear o actualizar productos")
public class ProductoDTO {

    @Schema(description = "Nombre del producto", example = "Notebook Lenovo ThinkPad", minLength = 3, maxLength = 100)
    @NotNull @NotBlank @Size(min = 3, max = 100)
    private String nombre;

    @Schema(description = "Descripción del producto", example = "Notebook empresarial 14 pulgadas", maxLength = 500)
    @Size(max = 500)
    private String descripcion;

    @Schema(description = "Precio del producto en dólares", example = "899.99", minimum = "0.01")
    @NotNull @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private Double precio;

    @Schema(description = "Cantidad disponible en stock", example = "15", minimum = "0")
    @NotNull @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @Schema(description = "Categoría del producto", example = "ELECTRONICA")
    @NotNull
    private Categoria categoria;
}
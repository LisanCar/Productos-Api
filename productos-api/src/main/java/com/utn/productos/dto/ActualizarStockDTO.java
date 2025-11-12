package com.utn.productos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para actualizar únicamente el stock de un producto")
public class ActualizarStockDTO {

    @Schema(description = "Nuevo valor de stock para el producto", example = "30", minimum = "0")
    @NotNull
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
}
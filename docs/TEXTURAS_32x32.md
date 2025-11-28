# Sistema de Texturas 32x32 para Armas Largas

## Configuración de Texturas

### Texturas 16x16 (Estándar)
Partes normales y pequeñas:
- ✅ Hoja de Daga
- ✅ Hoja de Espada
- ✅ Hoja de Hacha
- ✅ Cabeza de Pico
- ✅ Cabeza de Pala
- ✅ Mango Corto
- ✅ Mango Medio
- ✅ Guardas (small, medium, large)
- ✅ Pomo
- ✅ Binding

**Modelo usado**: `item/generated` (estándar de Minecraft)

### Texturas 32x32 (Armas Largas)
Partes de armas de dos manos y largas:
- ✅ Punta de Lanza (spearhead)
- ✅ Hoja de Katana (katana_blade)
- ✅ Mango Largo (long_handle) - Para lanzas y armas de asta

**Modelo usado**: `item/handheld` con transformaciones personalizadas

## Transformaciones Aplicadas

Las armas largas (32x32) tienen transformaciones especiales para verse correctamente:

```json
{
  "parent": "item/handheld",
  "display": {
    "thirdperson_righthand": {
      "rotation": [ 0, 90, 55 ],
      "translation": [ 0, 4, 0.5 ],
      "scale": [ 0.85, 0.85, 0.85 ]
    },
    "gui": {
      "rotation": [ 0, 0, 45 ],
      "translation": [ 0, 0, 0 ],
      "scale": [ 1, 1, 1 ]
    }
  }
}
```

## Capas de Texturas (Layering)

Según indicaste, las texturas están diseñadas para **apilarse correctamente** sin necesidad de calibración:

### Ejemplo: Lanza Completa
```
Layer 0: spearhead.png (32x32) - Punta metálica
Layer 1: long_handle.png (32x32) - Asta/mango largo
```

Las texturas se alinean automáticamente porque fueron diseñadas para encajar.

### Ejemplo: Katana
```
Layer 0: katana_blade.png (32x32) - Hoja larga curva
Layer 1: short_handle.png (16x16) - Tsuka (empuñadura)
Layer 2: small_guard.png (16x16) - Tsuba (guarda)
```

## Ventajas del Sistema Mixto

1. **Flexibilidad**: Partes pequeñas en 16x16, armas largas en 32x32
2. **Rendimiento**: Solo texturas grandes cuando es necesario
3. **Compatibilidad**: Las partes 16x16 funcionan con partes 32x32
4. **Alineación automática**: Sin necesidad de ajustes manuales

## Próximos Pasos

### Armas Modulares que Necesitarán Sistema de Capas:

**Armas 32x32 (Largas):**
1. **Lanza** - spearhead (32x32) + long_handle (32x32)
2. **Katana** - katana_blade (32x32) + short_handle (16x16) + small_guard (16x16)
3. **Espada Larga/Claymore** - sword_blade (16x16) + long_handle (32x32) + medium_guard (16x16)

**Armas 16x16 (Estándar):**
1. **Daga** - knife_blade + short_handle + small_guard
2. **Espada** - sword_blade + medium_handle + medium_guard + pommel
3. **Hacha** - axe_head + short_handle + binding
4. Etc.

## Implementación del Sistema de Renderizado

Cuando implementemos las armas modulares completas, necesitaremos:

1. **ItemRenderer personalizado** para armas con múltiples capas
2. **BakedModel dinámico** que combine las texturas de las partes
3. **Sistema de caché** para modelos pre-generados
4. **Colorización por material** (opcional, para tinting)

## Notas Técnicas

- Las texturas 32x32 se renderizan a escala 1:1 en GUI
- En third person/first person se aplican las transformaciones
- El sistema de capas soporta hasta 4 layers en Minecraft
- Las texturas deben estar en formato PNG con transparencia


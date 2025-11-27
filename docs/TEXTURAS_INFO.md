# MoltenSmith - Información de Texturas y Assets

## 🎨 Estado Actual: Sin Texturas Personalizadas

### Texturas Necesarias (Pendientes)

#### 1. **Partes de Armas** (Sin texturas aún)
Cada parte necesitará texturas para cada material:
- `blade_<material>.png` - Hoja de arma
- `guard_<material>.png` - Guarda
- `handle_<material>.png` - Empuñadura/Mango
- `pommel_<material>.png` - Pomo
- `spearhead_<material>.png` - Punta de lanza
- `crossguard_<material>.png` - Guarda cruzada

**Cantidad estimada**: ~10 materiales × 6 tipos de partes = **~60 texturas de partes**

#### 2. **Armas Completas** (Sin texturas aún)
Armas ensambladas que se generarán dinámicamente o necesitarán texturas compuestas:
- `dagger.png` - Daga
- `sword.png` - Espada
- `longsword.png` - Espada larga
- `katana.png` - Katana
- `spear.png` - Lanza
- `axe.png` - Hacha
- `pickaxe.png` - Pico
- `hoe.png` - Azada

**Cantidad estimada**: 8 tipos de armas × ~10 combinaciones de materiales = **~80 texturas** (si no son dinámicas)

#### 3. **Bloques de Fundición** (Sin texturas aún)
- `smeltery_controller.png` - Controlador de fundición (textura de bloque)
- `smeltery_bricks.png` - Ladrillos de fundición
- `smeltery_tank.png` - Tanque de metal fundido (animado/con fluido)
- `casting_table.png` - Mesa de fundición
- `casting_basin.png` - Cuenca de fundición
- `tool_station.png` - Estación de herramientas
- `tool_forge.png` - Forja de herramientas

**Cantidad estimada**: **~7-10 texturas de bloques**

#### 4. **Moldes** (Sin texturas aún)
- `mold_blank.png` - Molde vacío
- `mold_blade.png` - Molde de hoja
- `mold_guard.png` - Molde de guarda
- `mold_handle.png` - Molde de empuñadura
- `mold_pickaxe_head.png` - Molde de cabeza de pico
- `mold_axe_head.png` - Molde de cabeza de hacha
- `mold_ingot.png` - Molde de lingote

**Cantidad estimada**: **~8-12 texturas de moldes**

#### 5. **Fluidos** (Sin texturas aún)
Metales fundidos que aparecerán en tanques:
- `molten_iron_still.png` / `molten_iron_flow.png`
- `molten_gold_still.png` / `molten_gold_flow.png`
- `molten_copper_still.png` / `molten_copper_flow.png`
- `molten_netherite_still.png` / `molten_netherite_flow.png`
- Etc. (para cada material fundible)

**Cantidad estimada**: **~16-20 texturas de fluidos** (still + flow por cada metal)

#### 6. **GUI (Interfaces)** (Sin texturas aún)
- `smeltery_gui.png` - Interfaz de fundición
- `tool_station_gui.png` - Interfaz de estación de herramientas
- `casting_table_gui.png` - Interfaz de mesa de fundición
- Barras de progreso, iconos, etc.

**Cantidad estimada**: **~5-8 texturas de GUI**

---

## 📊 Resumen Total de Texturas Necesarias

| Categoría | Cantidad Estimada | Estado |
|-----------|------------------|--------|
| Partes de armas | ~60 | ❌ Pendiente |
| Armas completas | ~80 | ❌ Pendiente |
| Bloques | ~10 | ❌ Pendiente |
| Moldes | ~12 | ❌ Pendiente |
| Fluidos | ~20 | ❌ Pendiente |
| GUI | ~8 | ❌ Pendiente |
| **TOTAL** | **~190 texturas** | **0% completo** |

---

## 🎨 Estilo de Arte Recomendado

### Resolución:
- **16x16 pixels** - Estilo vanilla Minecraft
- Opcional: 32x32 para mayor detalle (requiere más trabajo)

### Paleta de Colores:
- Usar colores base definidos en `MaterialRegistry.java`:
  - Oak: RGB(150, 117, 70)
  - Stone: RGB(128, 128, 128)
  - Iron: RGB(200, 200, 200)
  - Gold: RGB(255, 215, 0)
  - Diamond: RGB(0, 255, 255)
  - Etc.

### Consistencia:
- Seguir el estilo de Minecraft vanilla
- Sombreado simple (2-3 tonos por color)
- Bordes definidos sin anti-aliasing

---

## 🔧 Implementación Actual (Placeholders)

Por ahora, el mod puede funcionar sin texturas usando:
1. **Texturas placeholder**: Bloques de colores sólidos
2. **Modelos generados**: Items generados por código
3. **Texturas vanilla**: Reutilizar texturas de Minecraft cuando sea posible

---

## 🛠️ Herramientas Recomendadas para Crear Texturas

### Software de Pixel Art:
- **Aseprite** (Pago, ~$20) - Mejor para pixel art
- **Piskel** (Gratis, web) - https://www.piskelapp.com/
- **GIMP** (Gratis) - Más complejo pero muy potente
- **Paint.NET** (Gratis, Windows) - Simple y efectivo

### Generadores:
- **BlockBench** - Para modelos 3D de bloques (gratis)
- **Nova Skin** - Editor de texturas de Minecraft (web, gratis)

---

## 📁 Estructura de Carpetas para Texturas

```
src/main/resources/assets/moltensmith/
├── textures/
│   ├── item/
│   │   ├── parts/
│   │   │   ├── blade_iron.png
│   │   │   ├── blade_gold.png
│   │   │   ├── handle_oak.png
│   │   │   └── ...
│   │   ├── tools/
│   │   │   ├── dagger.png
│   │   │   ├── sword.png
│   │   │   └── ...
│   │   └── molds/
│   │       ├── mold_blank.png
│   │       └── ...
│   ├── block/
│   │   ├── smeltery_controller.png
│   │   ├── smeltery_bricks.png
│   │   └── ...
│   ├── fluid/
│   │   ├── molten_iron_still.png
│   │   ├── molten_iron_flow.png
│   │   └── ...
│   └── gui/
│       ├── smeltery.png
│       └── tool_station.png
├── models/
│   ├── item/
│   │   └── ...
│   └── block/
│       └── ...
└── blockstates/
    └── ...
```

---

## 🚀 Plan de Desarrollo Sin Texturas

### Fase 2 - Mecánicas sin texturas finales:
1. **Usar texturas placeholder** de colores sólidos
2. **Implementar toda la lógica** del mod
3. **Testear funcionalidad** completa
4. **Crear texturas al final** cuando la mecánica esté lista

### Ventajas de este enfoque:
- ✅ Enfocarse en la programación y mecánicas
- ✅ Evitar rehacer texturas si cambia el diseño
- ✅ Probar rápidamente sin depender de arte
- ✅ Añadir texturas es solo "cambiar archivos PNG"

---

## 💡 Notas para Artistas Futuros

Si quieres contribuir con texturas:
1. Lee los colores base en `MaterialRegistry.java`
2. Mantén el estilo consistente con Minecraft
3. Usa las dimensiones correctas (16x16)
4. Nombra los archivos según la estructura de arriba
5. Prueba las texturas en el mod antes de finalizar

---

**Estado actual**: Mod funcional sin texturas personalizadas. Prioridad en mecánicas primero, arte después.

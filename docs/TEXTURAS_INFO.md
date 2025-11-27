# MoltenSmith - Información de Texturas y Assets

## 🎨 Estado Actual: Sin Texturas Personalizadas

### Texturas Necesarias (Pendientes)

#### 1. **Partes de Armas - SISTEMA OPTIMIZADO** (Sin texturas aún)

**PARTES COMODÍN (5 tipos × 10 materiales = 50 texturas):**
- `rod_<material>.png` - Vara (mango de una mano)
- `pole_<material>.png` - Asta (mango de dos manos)
- `binding_<material>.png` - Ligadura (unión)
- `guard_<material>.png` - Guarda (protección de mano)
- `pommel_<material>.png` - Pomo (contrapeso)

**CABEZAS ÚNICAS (7 tipos × 10 materiales = 70 texturas):**
- `knife_blade_<material>.png` - Hoja de cuchillo (Daga)
- `sword_blade_<material>.png` - Hoja de espada (Espada/Claymore)
- `katana_blade_<material>.png` - Hoja de katana
- `spearhead_<material>.png` - Punta de lanza
- `axe_head_<material>.png` - Cabeza de hacha
- `pickaxe_head_<material>.png` - Cabeza de pico
- `large_plate_<material>.png` - Placa grande (Pala/Escudo futuro)

**Cantidad estimada**: 12 tipos de partes × 10 materiales = **~120 texturas de partes** (vs 60+ del sistema anterior)

#### 2. **Armas Completas** (Sin texturas aún)

**NOTA**: Las texturas de armas completas se generarán **DINÁMICAMENTE** en el renderer combinando las texturas de partes.

**Armas a renderizar:**
- `dagger` - Hoja de Cuchillo + Guarda + Vara
- `sword` - Hoja de Espada + Guarda + Vara + Pomo
- `longsword` - Hoja de Espada + Guarda + Asta + Pomo
- `katana` - Hoja de Katana + Ligadura + Vara
- `spear` - Punta de Lanza + Asta + Pomo
- `halberd` - Cabeza de Hacha + Asta + Ligadura
- `axe` - Cabeza de Hacha + Vara + Ligadura
- `pickaxe` - Cabeza de Pico + Vara + Ligadura
- `shovel` - Placa Grande + Asta + Ligadura
- `hoe` - Cabeza de Hacha + Vara (versión modificada)

**Cantidad estimada**: **0 texturas estáticas** (todo dinámico), pero necesitamos crear las 120 texturas de partes para que funcione

#### 3. **Bloques de Fundición** (Sin texturas aún)
- `smeltery_controller.png` - Controlador de fundición (textura de bloque)
- `smeltery_bricks.png` - Ladrillos de fundición
- `smeltery_tank.png` - Tanque de metal fundido (animado/con fluido)
- `casting_table.png` - Mesa de fundición
- `casting_basin.png` - Cuenca de fundición
- `tool_station.png` - Estación de herramientas
- `tool_forge.png` - Forja de herramientas

**Cantidad estimada**: **~7-10 texturas de bloques**

#### 4. **Moldes - SISTEMA OPTIMIZADO** (Sin texturas aún)

**MOLDES COMODÍN (5):**
- `mold_rod.png` - Molde de vara
- `mold_pole.png` - Molde de asta
- `mold_binding.png` - Molde de ligadura
- `mold_guard.png` - Molde de guarda
- `mold_pommel.png` - Molde de pomo

**MOLDES DE CABEZAS (7):**
- `mold_knife_blade.png` - Molde de hoja de cuchillo
- `mold_sword_blade.png` - Molde de hoja de espada
- `mold_katana_blade.png` - Molde de hoja de katana
- `mold_spearhead.png` - Molde de punta de lanza
- `mold_axe_head.png` - Molde de cabeza de hacha
- `mold_pickaxe_head.png` - Molde de cabeza de pico
- `mold_large_plate.png` - Molde de placa grande

**MOLDES EXTRA (2):**
- `mold_blank.png` - Molde vacío (material base)
- `mold_ingot.png` - Molde de lingote

**Cantidad estimada**: **14 texturas de moldes** (vs 8-12 del sistema anterior)

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

| Categoría | Cantidad Estimada | Estado | Notas |
|-----------|------------------|--------|-------|
| Partes de armas | ~120 | ❌ Pendiente | Sistema optimizado: 12 tipos × 10 materiales |
| Armas completas | ~0 | ✅ No necesarias | Renderizado dinámico de partes |
| Bloques | ~10 | ❌ Pendiente | Smeltery, casting, stations |
| Moldes | ~14 | ❌ Pendiente | 5 comodín + 7 cabezas + 2 extra |
| Fluidos | ~20 | ❌ Pendiente | Still + flow por material |
| GUI | ~8 | ❌ Pendiente | Interfaces de bloques |
| **TOTAL** | **~172 texturas** | **0% completo** | Reducido de ~190 gracias al sistema optimizado |

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

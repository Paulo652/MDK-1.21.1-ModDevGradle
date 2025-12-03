# MoltenSmith - Checklist de Assets (Sprites & Modelos 3D)

**Versión**: 1.0  
**Fecha**: 2 Diciembre 2025  
**Estado**: Para implementar nuevo concepto táctil

---

## 📋 RESUMEN EJECUTIVO

### Total de Assets Necesarios:
- **Items 2D (Sprites)**: 20 items (Hot Parts usan tint dinámico, no sprites separados)
- **Bloques 3D (Blockbench)**: 6 bloques multibloque
- **Renders Especiales (BER)**: 4 sistemas de renderizado con color dinámico

---

## 🎨 1. SPRITES DE ITEMS (16x16 y 32x32)

### A. Herramientas del Herrero (3 items)

| Item | Tamaño | Estado Actual | Prioridad | Notas |
|------|--------|---------------|-----------|-------|
| **Tongs** (Tenazas) | 16x16 | ❌ Falta | 🔴 ALTA | Pinzas largas, mango de madera |
| **Hammer** (Martillo) | 16x16 | ❌ Falta | 🔴 ALTA | Cabeza de hierro grande, mango largo |
| **Template Base** | 16x16 | ❌ Falta | 🟡 MEDIA | Papel con líneas guía |

---

### B. Templates (Plantillas) - 7 items

Todas 16x16, mismo diseño base con silueta diferente

| Template | Estado | Silueta a Mostrar |
|----------|--------|-------------------|
| Knife Blade Template | ❌ Falta | Hoja corta triangular |
| Sword Blade Template | ❌ Falta | Hoja recta mediana |
| Katana Blade Template | ❌ Falta | Hoja curva |
| Spearhead Template | ❌ Falta | Punta de lanza |
| Axe Head Template | ❌ Falta | Cabeza de hacha |
| Pickaxe Head Template | ❌ Falta | Pico triangular |
| Shovel Head Template | ❌ Falta | Pala cuadrada |

**Estilo sugerido**: Fondo de papel beige, silueta negra/gris de la pieza

---

### C. Parts Frías (REUTILIZAR EXISTENTES) - 15 items

Ya tienes estos sprites del sistema anterior:

| Part | Tamaño | Estado | Acción Requerida |
|------|--------|--------|------------------|
| Knife Blade | 16x16 | ✅ Existe | Reutilizar |
| Sword Blade | 16x16 | ✅ Existe | Reutilizar |
| Katana Blade | 32x32 | ✅ Existe | Reutilizar |
| Spearhead | 32x32 | ⚠️ Temporal | Reemplazar sprite |
| Axe Head | 16x16 | ✅ Existe | Reutilizar |
| Pickaxe Head | 16x16 | ✅ Existe | Reutilizar |
| Shovel Head | 16x16 | ✅ Existe | Reutilizar |
| Short Handle | 16x16 | ✅ Existe | Reutilizar |
| Medium Handle | 16x16 | ✅ Existe | Reutilizar |
| Long Handle | 32x32 | ⚠️ Temporal | Reemplazar sprite |
| Small Guard | 16x16 | ✅ Existe | Reutilizar |
| Medium Guard | 16x16 | ✅ Existe | Reutilizar |
| Large Guard | 16x16 | ⚠️ Temporal | Reemplazar sprite |
| Binding | 16x16 | ⚠️ Temporal | Reemplazar sprite |
| Pommel | 16x16 | ✅ Existe | Reutilizar |

---

### D. ~~Hot Parts (Versiones Calientes)~~ - ⚠️ NO NECESARIOS

**✅ SOLUCIÓN OPTIMIZADA: Sistema de Tint Dinámico**

En lugar de crear sprites separados, las partes calientes usan:
- **Color multiplier** en código Java según temperatura NBT
- **BER rendering** con color rojo cuando están en fragua/yunque
- **Mismo sprite base** para versión fría y caliente

**Implementación técnica**:
```java
// En ToolPart.java
@Override
public int getColor(ItemStack stack, int tintIndex) {
    int temp = TemperatureComponent.get(stack).heatLevel;
    if (temp > 75) return 0xFFFF99; // Blanco incandescente
    if (temp > 50) return 0xFF3300; // Rojo brillante
    if (temp > 25) return 0xFF6600; // Naranja
    return 0xFFFFFF; // Sin tint (normal)
}
```

**Beneficios**:
- ✅ Cero sprites adicionales necesarios
- ✅ Transición suave de color según temperatura
- ✅ Menos complejidad en items (no necesitas hot/cold variants)
- ✅ ~7 horas de trabajo ahorradas

**Nota**: Para efecto de brillo/glow, usar partículas en BER cuando el item está caliente

---

## 🧊 2. MODELOS 3D DE BLOQUES (Blockbench)

### A. Ember Hearth (2 bloques verticales)

#### **Firebox** (Bloque inferior)
- **Dimensiones**: 16x16x16 (cubo completo)
- **Elementos a modelar**:
  - Base de piedra/metal oscuro
  - Rejilla frontal para ver el fuego dentro
  - Apertura superior para conectar con Hearth Bed
  - (Opcional) Cenizas en el fondo
- **Texturas necesarias**:
  - `firebox_side.png` (lados con rejilla)
  - `firebox_top.png` (apertura superior)
  - `firebox_bottom.png` (base sólida)
- **Estados**: 
  - Apagado (gris oscuro)
  - Encendido (brillo naranja en rejilla) - usar emissive texture

#### **Hearth Bed** (Bloque superior)
- **Dimensiones**: 16x16x8 (medio bloque de altura)
- **Elementos a modelar**:
  - Superficie plana permeable (rejilla metálica)
  - Bordes elevados (4 lados)
  - Conexión con Firebox debajo
- **Texturas necesarias**:
  - `hearth_bed_top.png` (rejilla metálica)
  - `hearth_bed_side.png` (marco de hierro)
- **Notas**: Los lingotes se renderizan ENCIMA usando BER, no en el modelo

---

### B. Grand Anvil (1-2 bloques horizontales)

#### **Anvil Single** (1 bloque)
- **Dimensiones**: 16x10x16 (bloque bajo)
- **Elementos a modelar**:
  - Cuerpo del yunque (forma clásica de yunque)
  - Superficie plana superior para trabajar
  - Base con 4 patas cortas
  - Cuerno lateral (opcional, estético)
- **Texturas necesarias**:
  - `anvil_top.png` (superficie de trabajo)
  - `anvil_body.png` (cuerpo principal)
  - `anvil_base.png` (patas)
- **Referencia**: Vanilla anvil pero más grande y plano

#### **Anvil Left/Right** (2 bloques conectados)
- **Diseño**: Igual que single pero modelo extendido
- **Left**: Extremo izquierdo del yunque largo
- **Right**: Extremo derecho del yunque largo
- **Transición**: Superficie continua entre ambos bloques
- **Texturas**: Reutilizar las mismas pero con UVs extendidas

---

### C. Quench Tank (1-2 bloques horizontales)

#### **Tank Single** (1 bloque - cubo)
- **Dimensiones**: 16x12x16 (80% del bloque)
- **Elementos a modelar**:
  - 4 paredes exteriores (metal/piedra)
  - Interior hueco
  - Reborde superior
  - Fondo visible
- **Texturas necesarias**:
  - `tank_outer.png` (exterior metálico)
  - `tank_inner.png` (interior más oscuro)
  - `tank_rim.png` (borde superior)
- **Notas**: El líquido se renderiza dinámicamente con BER

#### **Tank Left/Right** (2 bloques - bañera)
- **Diseño**: Forma rectangular alargada
- **Left**: Extremo izquierdo (pared + esquina)
- **Right**: Extremo derecho (pared + esquina)
- **Dimensiones**: 32x12x16 (dos bloques de largo)
- **Texturas**: Reutilizar las del single

---

### D. Armorer's Bench (1-3 bloques horizontales)

#### **Bench Single** (1 bloque)
- **Dimensiones**: 16x12x16
- **Elementos a modelar**:
  - Mesa plana superior
  - 4 patas de madera/metal
  - Superficie de trabajo con marcas guía
  - (Opcional) Estantes inferiores
- **Texturas necesarias**:
  - `bench_top.png` (superficie con marcas)
  - `bench_leg.png` (patas)
  - `bench_side.png` (laterales)
- **Referencia**: Similar a vanilla crafting table pero más robusto

#### **Bench Left/Middle/Right** (2-3 bloques)
- **Left**: Extremo izquierdo con pata
### A. Ember Hearth BER
**Qué renderiza**:
- Hasta 4 lingotes flotando sobre Hearth Bed
- **Color dinámico** según temperatura NBT (gris → naranja → rojo → blanco)
- Efecto de brillo/emisión usando `RenderType.glint()` o partículas
- (Opcional) Partículas de calor ascendentes tipo lava

**Implementación de color**:
```java
int color = getTemperatureColor(temperature);
poseStack.setColor(color >> 16 & 0xFF, color >> 8 & 0xFF, color & 0xFF, 255);
```

**Complejidad**: Media (4 items con colores dinámicos + partículas)
Estos NO son modelos ni sprites, sino sistemas de renderizado en código Java:

### A. Ember Hearth BER
**Qué renderiza**:
- Hasta 4 lingotes flotando sobre Hearth Bed
- Color dinámico según temperatura (gris → naranja → rojo → blanco)
- Efecto de brillo/emisión en lingotes calientes
### B. Grand Anvil BER
**Qué renderiza**:
- 1-3 lingotes calientes con **color rojo dinámico** (mismo sistema que Hearth)
- Template (plantilla) semi-transparente superpuesta (alpha 0.5)
- Progreso de forjado (barra visual o modelo que se aplana gradualmente)
- Deformación progresiva del metal hacia forma de template
- Partículas de chispas al martillar (tipo `minecraft:lava` o custom)

**Nota sobre color**: Los lingotes en el yunque mantienen su temperatura NBT y se renderizan rojos sin necesitar sprites separados

**Complejidad**: Alta (deformación de mesh, progreso visual, múltiples items)
- Template (plantilla) semi-transparente superpuesta
- Progreso de forjado (barra o % visual)
- Deformación progresiva del metal hacia forma de template
- Partículas de chispas al martillar

**Complejidad**: Alta (deformación de mesh, progreso visual)

---

### C. Quench Tank BER
**Qué renderiza**:
- Nivel de líquido dentro del tanque (variable)
- Color del líquido (azul agua, marrón aceite, naranja lava)
- Efecto de ondulaciones en superficie
- Explosión de vapor al templar (partículas)

**Complejidad**: Media (fluido simple + partículas)

---

### D. Armorer's Bench BER
**Qué renderiza**:
- Hasta 4 partes frías colocadas en posiciones específicas
- Estado translúcido (no fijadas) vs sólido (fijadas)
- Modelo 3D del arma completa al finalizar
- Indicadores visuales de uniones

**Complejidad**: Alta (múltiples items, estados, validación espacial)

---

### 🔴 FASE 1: Mínimo Viable (Core Loop)
**Para probar el concepto básico**

1. **Sprites Críticos** (Solo 3 items):
   - ✅ Tongs (16x16)
   - ✅ Hammer (16x16)
   - ✅ Sword Blade Template (16x16)
   - ~~❌ Hot Sword Blade~~ → **NO NECESARIO** (usa tint dinámico)

2. **Modelos Críticos**:
   - ✅ Firebox (Blockbench)
   - ✅ Hearth Bed (Blockbench)
   - ✅ Anvil Single (Blockbench)
   - ✅ Tank Single (Blockbench)

3. **Código Crítico**:
   - ✅ TemperatureComponent (Data Component NBT)
   - ✅ Ember Hearth BER (lingotes con color dinámico)
   - ✅ Grand Anvil BER (básico, sin deformación compleja)
   - ✅ Color multiplier en items según temperatura

**Resultado**: Puedes calentar 1 lingote (se pone rojo) → forjar 1 sword blade → templar (se enfría)

**Resultado**: Puedes calentar 1 lingote → forjar 1 sword blade → templar

---

### 🟡 FASE 2: Expansión de Partes
**Añadir variedad de armas**

1. **Sprites**:
   - Knife Blade Template
   - Katana Blade Template
   - Axe Head Template
   - Hot variants de las anteriores

2. **Completar sprites temporales**:
   - Spearhead (32x32)
   - Long Handle (32x32)
   - Large Guard (16x16)
   - Binding (16x16)

---

### 🟢 FASE 3: Multibloque & Assembly
**Sistema completo de ensamblaje**

1. **Modelos**:
   - Anvil Left/Right
   - Tank Left/Right
   - Bench Single/Left/Middle/Right

2. **BER**:
   - Quench Tank BER (líquido dinámico)
   - Armorer's Bench BER (ensamblaje visual)

3. **Sprites restantes**:
   - Todas las templates faltantes
   - Todas las hot parts faltantes

---

## 📐 5. ESPECIFICACIONES TÉCNICAS

### Sprites (PNG)
- **Resolución**: 16x16 o 32x32 píxeles
- **Formato**: PNG con transparencia (alpha channel)
- **Paleta**: Limitada (estilo Minecraft vanilla)
- **Ubicación**: `src/main/resources/assets/moltensmith/textures/item/`

### Modelos de Bloques (JSON)
- **Software**: Blockbench 4.x
- **Formato**: Exportar como "Java Block/Item"
- **Texturas**: Referenciar con `moltensmith:block/nombre_textura`
- **Ubicación**: 
  - Modelos: `src/main/resources/assets/moltensmith/models/block/`
  - Texturas: `src/main/resources/assets/moltensmith/textures/block/`

### Texturas de Bloques (PNG)
- **Resolución**: 16x16 píxeles (vanilla style)
- **Formato**: PNG con transparencia si es necesario
## ✅ 6. CHECKLIST FINAL COMPLETO

### Items 2D (20 total - ✅ Reducido de 27)
**Herramientas del Herrero:**
- [ ] Tongs sprite
- [ ] Hammer sprite

**Templates (7):**
- [ ] Template base design (papel beige)
- [ ] Knife Blade Template
- [ ] Sword Blade Template
- [ ] Katana Blade Template
- [ ] Spearhead Template
- [ ] Axe Head Template
- [ ] Pickaxe Head Template
- [ ] Shovel Head Template

**Completar Sprites Temporales (4):**
- [ ] Spearhead (reemplazar temporal)
- [ ] Long Handle (reemplazar temporal)
- [ ] Large Guard (reemplazar temporal)
- [ ] Binding (reemplazar temporal)

**~~Hot Parts~~:** ❌ **ELIMINADOS** - Usan tint dinámico en código (ahorra 7 sprites)
- [ ] Spearhead (reemplazar temporal)
- [ ] Long Handle (reemplazar temporal)
- [ ] Large Guard (reemplazar temporal)
- [ ] Binding (reemplazar temporal)

### Modelos 3D (8 modelos, 6 bloques únicos)
- [ ] Firebox (Ember Hearth inferior)
- [ ] Hearth Bed (Ember Hearth superior)
- [ ] Anvil Single (Grand Anvil 1 bloque)
- [ ] Anvil Left + Right (Grand Anvil 2 bloques)
- [ ] Tank Single (Quench Tank 1 bloque)
- [ ] Tank Left + Right (Quench Tank 2 bloques)
- [ ] Bench Single (Armorer's Bench 1 bloque)
- [ ] Bench Left/Middle/Right (Armorer's Bench 2-3 bloques)

### Texturas de Bloques (estimado 20-25 texturas)
- [ ] firebox_side.png
- [ ] firebox_top.png
- [ ] firebox_bottom.png
- [ ] firebox_side_lit.png (emissive)
- [ ] hearth_bed_top.png
- [ ] hearth_bed_side.png
- [ ] anvil_top.png
- [ ] anvil_body.png
- [ ] anvil_base.png
- [ ] tank_outer.png
- [ ] tank_inner.png
- [ ] tank_rim.png
- [ ] bench_top.png
- [ ] bench_leg.png
- [ ] bench_side.png

### BER (Código Java - No assets visuales)
- [ ] EmberHearthRenderer.java
- [ ] GrandAnvilRenderer.java
- [ ] QuenchTankRenderer.java
- [ ] ArmorersBenchRenderer.java

---

## 🎨 7. RECOMENDACIONES DE ESTILO

### Color Palette Sugerida:
```
Metales Fríos:
- Hierro: #8A8A8A (gris claro)
- Acero: #B8B8B8 (gris brillante)
- Detalles: #4A4A4A (gris oscuro)

Metales Calientes:
- Temperatura baja: #FF6600 (naranja)
- Temperatura media: #FF3300 (rojo brillante)
- Temperatura alta: #FFFF99 (blanco amarillento)

Materiales:
- Madera: #8B4513 (marrón)
- Piedra: #696969 (gris medio)
- Papel (templates): #F5DEB3 (beige)
```

### Referencias Visuales:
- **Tongs**: Buscar "blacksmith tongs pixel art"
- **Hammer**: Estilo "sledgehammer" más grande que vanilla
- **Anvil**: Combinar vanilla anvil + forma más plana
- **Templates**: Estilo "blueprint" o "schematic"

---

## 🎯 8. SISTEMA DE COLOR DINÁMICO (Temperatura)

### Implementación Técnica del Tint

**Paleta de temperatura**:
```java
public static int getTemperatureColor(int heatLevel) {
    if (heatLevel >= 75) return 0xFFFF99; // Blanco incandescente (255,255,153)
    if (heatLevel >= 50) return 0xFF3300; // Rojo brillante (255,51,0)
    if (heatLevel >= 25) return 0xFF6600; // Naranja oscuro (255,102,0)
    return 0xFFFFFF; // Sin tint (blanco = sin cambio)
}
```

**En cada ToolPart item**:
```java
@Override
public int getColor(ItemStack stack, int tintIndex) {
    if (!stack.has(DataComponents.CUSTOM_DATA)) return 0xFFFFFF;
    CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).copyTag();
    int temperature = tag.getInt("temperature");
    return getTemperatureColor(temperature);
}
```

**Registrar el color provider** (en client setup):
```java
ColorProviderRegistry.register((stack, tintIndex) -> {
    if (stack.getItem() instanceof ToolPart part) {
        return part.getColor(stack, tintIndex);
    }
    return 0xFFFFFF;
}, ModItems.SWORD_BLADE.get(), ModItems.AXE_HEAD.get(), ...);
```

**Ventaja clave**: El mismo sprite `sword_blade.png` se ve gris (frío) o rojo (caliente) automáticamente

---

**Última actualización**: 2 Diciembre 2025 v1.1  
**Total estimado de trabajo**: 
- Sprites: **~4-6 horas** (reducido 33% al eliminar hot parts)
- Modelos 3D: ~10-12 horas (Blockbench)
- BER + Temperatura: ~25-35 horas (código Java + sistema de tint)

**Ahorro total**: ~7 horas de sprites + simplificación de inventario

**Próximo paso**: Crear 3 sprites de Fase 1 (Tongs, Hammer, Template) y probar sistema de temperatura con tint

**Próximo paso**: Crear sprites de Fase 1 y probar BER básico

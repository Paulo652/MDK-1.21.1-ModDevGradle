# MoltenSmith - Sistema de Partes Optimizado

## 🎯 Concepto Central: Reutilización Inteligente

En lugar de crear partes únicas para cada arma, usamos **5 partes comodín** que se combinan con **7 cabezas especializadas** para crear **10 tipos de armas**.

---

## 🔧 Las 5 Partes Comodín

### 1. **VARA (Rod)** - El Mango Universal de Una Mano
```
Textura: rod_<material>.png
Molde: mold_rod.png

Usado en:
├── Daga          (Vara + Hoja de Cuchillo + Guarda)
├── Espada        (Vara + Hoja de Espada + Guarda + Pomo)
├── Katana        (Vara + Hoja de Katana + Ligadura)
├── Hacha         (Vara + Cabeza de Hacha + Ligadura)
└── Pico          (Vara + Cabeza de Pico + Ligadura)

Estadísticas:
- Material ligero (Madera): +Velocidad, -Durabilidad
- Material pesado (Metal): +Durabilidad, -Velocidad
```

### 2. **ASTA (Pole)** - El Mango Universal de Dos Manos
```
Textura: pole_<material>.png
Molde: mold_pole.png

Usado en:
├── Claymore      (Asta + Hoja de Espada + Guarda + Pomo)
├── Lanza         (Asta + Punta de Lanza + Pomo)
├── Alabarda      (Asta + Cabeza de Hacha + Ligadura)
└── Pala          (Asta + Placa Grande + Ligadura)

Estadísticas:
- SIEMPRE: +Alcance, -Velocidad (por ser dos manos)
- Material ligero: Reduce penalización de velocidad
- Material pesado: +Durabilidad, penaliza más la velocidad
```

### 3. **LIGADURA (Binding)** - La Unión Universal
```
Textura: binding_<material>.png
Molde: mold_binding.png

Usado en:
├── Hacha         (Vara + Cabeza de Hacha + Ligadura)
├── Pico          (Vara + Cabeza de Pico + Ligadura)
├── Alabarda      (Asta + Cabeza de Hacha + Ligadura)
├── Pala          (Asta + Placa Grande + Ligadura)
└── Katana        (Vara + Hoja de Katana + Ligadura) *Simula el Habaki*

Estadísticas:
- Material flexible (Cuero/Madera): +Durabilidad menor, +Velocidad
- Material rígido (Metal): +Durabilidad mayor
- Efecto fijo: +10% durabilidad base
```

### 4. **GUARDA (Guard)** - Protección de Mano Occidental
```
Textura: guard_<material>.png
Molde: mold_guard.png

Usado en:
├── Daga          (Vara + Hoja de Cuchillo + Guarda)
├── Espada        (Vara + Hoja de Espada + Guarda + Pomo)
└── Claymore      (Asta + Hoja de Espada + Guarda + Pomo)

Estadísticas:
- Material ligero: +Durabilidad, bonus defensivo mínimo
- Material pesado: +Durabilidad mayor, +Resistencia knockback, -Velocidad
- Efecto fijo: Protección al bloquear
```

### 5. **POMO (Pommel)** - El Contrapeso Universal
```
Textura: pommel_<material>.png
Molde: mold_pommel.png

Usado en:
├── Espada        (Vara + Hoja de Espada + Guarda + Pomo)
├── Claymore      (Asta + Hoja de Espada + Guarda + Pomo)
└── Lanza         (Asta + Punta de Lanza + Pomo) *Actúa como "Butt"*

Estadísticas:
- Material ligero: Reduce penalización de armas pesadas
- Material pesado: +Knockback, +Balance, -Velocidad
- En Lanzas: Mejora precisión y balance
```

---

## ⚔️ Las 7 Cabezas Especializadas

### 1. **Hoja de Cuchillo** (Knife Blade)
```
Textura: knife_blade_<material>.png
Molde: mold_knife_blade.png

SOLO para: Daga
Receta: Hoja de Cuchillo + Guarda + Vara

Característica: Hoja corta y ligera, diseñada para velocidad
```

### 2. **Hoja de Espada** (Sword Blade)
```
Textura: sword_blade_<material>.png
Molde: mold_sword_blade.png

Usado en:
├── Espada     (Hoja de Espada + Guarda + Vara + Pomo)
└── Claymore   (Hoja de Espada + Guarda + Asta + Pomo)

Característica: ¡La MISMA hoja funciona para ambas!
- Con Vara = Espada de una mano
- Con Asta = Espada larga de dos manos
```

### 3. **Hoja de Katana** (Katana Blade)
```
Textura: katana_blade_<material>.png
Molde: mold_katana_blade.png

SOLO para: Katana
Receta: Hoja de Katana + Ligadura + Vara

Característica: Hoja curva única, no usa Guarda ni Pomo occidental
```

### 4. **Punta de Lanza** (Spearhead)
```
Textura: spearhead_<material>.png
Molde: mold_spearhead.png

SOLO para: Lanza
Receta: Punta de Lanza + Asta + Pomo

Característica: Punta perforante diseñada para máximo alcance
```

### 5. **Cabeza de Hacha** (Axe Head)
```
Textura: axe_head_<material>.png
Molde: mold_axe_head.png

Usado en:
├── Hacha      (Cabeza de Hacha + Vara + Ligadura)
└── Alabarda   (Cabeza de Hacha + Asta + Ligadura)

Característica: ¡La MISMA cabeza funciona para ambas!
- Con Vara = Hacha de una mano
- Con Asta = Alabarda de dos manos
```

### 6. **Cabeza de Pico** (Pickaxe Head)
```
Textura: pickaxe_head_<material>.png
Molde: mold_pickaxe_head.png

SOLO para: Pico
Receta: Cabeza de Pico + Vara + Ligadura

Característica: Diseño especializado para minería
```

### 7. **Placa Grande** (Large Plate)
```
Textura: large_plate_<material>.png
Molde: mold_large_plate.png

Usado en:
└── Pala       (Placa Grande + Asta + Ligadura)

Futuro: Esta pieza podrá usarse para Escudos

Característica: Superficie grande, multiusos
```

---

## 📋 Tabla de Recetas Completa

| Arma | Cabeza | Parte 1 | Parte 2 | Parte 3 |
|------|--------|---------|---------|---------|
| **Daga** | Hoja de Cuchillo | Guarda | Vara | - |
| **Espada** | Hoja de Espada | Guarda | Vara | Pomo |
| **Claymore** | Hoja de Espada | Guarda | **Asta** | Pomo |
| **Katana** | Hoja de Katana | Ligadura | Vara | - |
| **Lanza** | Punta de Lanza | **Asta** | Pomo | - |
| **Hacha** | Cabeza de Hacha | Ligadura | Vara | - |
| **Alabarda** | Cabeza de Hacha | Ligadura | **Asta** | - |
| **Pico** | Cabeza de Pico | Ligadura | Vara | - |
| **Pala** | Placa Grande | Ligadura | **Asta** | - |
| **Azada** | Cabeza de Hacha* | Ligadura | Vara | - |

*Nota: La Azada usa una versión modificada de Cabeza de Hacha o Placa Grande*

---

## 🎨 Ventajas del Sistema

### 1. **Reducción Masiva de Assets**
```
Sistema Anterior:
- Blade, Guard, Handle, Pommel específicos por arma
- Spearhead, Shaft, Butt específicos
- Axe Head, Axe Handle, Binding específicos
- Pickaxe Head, Pickaxe Handle específicos
- Total: ~30+ moldes diferentes

Sistema Optimizado:
- 5 partes comodín + 7 cabezas
- Total: 12 moldes
- Ahorro: ~60% menos moldes
```

### 2. **Texturas Optimizadas**
```
Partes × Materiales:
- 12 tipos de partes × 10 materiales = 120 texturas de partes

Moldes:
- 12 moldes únicos + 2 extra (blank, ingot) = 14 texturas

Armas completas:
- 0 texturas estáticas (renderizado dinámico)

Total: ~172 texturas (vs ~190 del sistema anterior)
```

### 3. **Lógica Realista**
- Una **Vara** sirve para cualquier arma de una mano
- Una **Asta** sirve para cualquier arma de dos manos
- Una **Ligadura** sujeta cualquier cabeza pesada a un mango
- La misma **Hoja de Espada** puede ser de una o dos manos según el mango

### 4. **Facilidad de Expansión**
```
Añadir nueva arma:
1. Crear 1 nueva cabeza única (7 → 8)
2. Reutilizar partes comodín existentes
3. Definir receta de combinación
4. ¡Listo! Solo +10 texturas (1 cabeza × 10 materiales)
```

---

## 🔮 Futuras Expansiones

### Armas Adicionales (Usando el mismo sistema):
- **Martillo** = Cabeza de Martillo (nueva) + Asta + Ligadura
- **Maza** = Cabeza de Maza (nueva) + Vara + Pomo
- **Estoque** = Hoja de Estoque (nueva) + Guarda + Vara + Pomo
- **Guadaña** = Hoja de Guadaña (nueva) + Asta + Ligadura

### Armadura Modular:
- **Escudo** = Placa Grande + Vara + Ligadura (¡reutilización!)
- **Casco** = Placa Mediana (nueva) + Ligadura
- **Peto** = 2× Placa Grande + 2× Ligadura

---

## 💾 Implementación en Código

### Estructura de Clases:
```java
// Partes Comodín
public class RodPart extends ToolPart { }
public class PolePart extends ToolPart { }
public class BindingPart extends ToolPart { }
public class GuardPart extends ToolPart { }
public class PommelPart extends ToolPart { }

// Cabezas Únicas
public class KnifeBladePart extends ToolPart { }
public class SwordBladePart extends ToolPart { }
public class KatanaBladePart extends ToolPart { }
public class SpearheadPart extends ToolPart { }
public class AxeHeadPart extends ToolPart { }
public class PickaxeHeadPart extends ToolPart { }
public class LargePlatePart extends ToolPart { }
```

### Sistema de Validación:
```java
public class WeaponRecipe {
    Map<WeaponType, List<PartType>> validRecipes = Map.of(
        DAGGER, List.of(KNIFE_BLADE, GUARD, ROD),
        SWORD, List.of(SWORD_BLADE, GUARD, ROD, POMMEL),
        LONGSWORD, List.of(SWORD_BLADE, GUARD, POLE, POMMEL),
        KATANA, List.of(KATANA_BLADE, BINDING, ROD),
        // ...
    );
}
```

---

## 📊 Comparación Final

| Aspecto | Sistema Anterior | Sistema Optimizado |
|---------|------------------|-------------------|
| **Moldes necesarios** | ~30+ | 12 |
| **Texturas de partes** | ~60-80 | 120 |
| **Texturas de armas** | ~80 | 0 (dinámico) |
| **Total texturas** | ~190 | ~172 |
| **Complejidad código** | Alta | Media |
| **Flexibilidad** | Baja | Alta |
| **Realismo** | Medio | Alto |
| **Facilidad expansión** | Baja | **Muy Alta** |

---

## ✅ Conclusión

Este sistema optimizado reduce la cantidad de assets únicos mientras mantiene la profundidad del sistema modular. La clave está en **reutilizar inteligentemente** las partes comunes y solo especializar las cabezas que definen el tipo de arma.

**Ejemplo de éxito del sistema:**
- Espada + Claymore = Misma hoja, diferente mango (Vara vs Asta)
- Hacha + Alabarda = Misma cabeza, diferente mango (Vara vs Asta)
- 1 molde de Ligadura sirve para Hacha, Pico, Alabarda, Pala y Katana

**Resultado:** Máxima variedad con mínimo trabajo de assets. 🎯

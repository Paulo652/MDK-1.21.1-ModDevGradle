# MoltenSmith - Plan de Desarrollo

## Información General
- **Nombre del Mod**: MoltenSmith
- **Mod ID**: moltensmith
- **Versión de Minecraft**: 1.21.1
- **Plataforma**: NeoForge 21.1.215
- **Concepto**: Mod de armas modulares con fundición realista y compatibilidad con Better Combat. Enfocado en crear un sistema de herrería inmersivo para roleplay y balance de progresión.

## Visión del Mod
**Filosofía**: Crear un sistema de herrería realista que:
- Elimine la facilidad de obtener herramientas de hierro básicas
- Ofrezca profundidad en el late-game mediante combinación de partes
- Permita roleplay de herrero en servidores (venta de armas personalizadas)
- Sea compatible con Better Combat para combate mejorado
- Equilibre estadísticas mediante trade-offs (mejorar algo = empeorar otra cosa)

---

## 1. SISTEMAS PRINCIPALES

### 1.1 Sistema de Materiales
**Prioridad: ALTA - Fundamento del mod**

#### Materiales Base:
- **Metales**: Hierro, Oro, Cobre, Netherite, etc.
- **Madera**: Roble, Abedul, Abeto, etc.
- **Cristales**: Diamante, Esmeralda, Cuarzo, Amatista
- **Especiales**: Obsidiana, Hueso, Piedra, etc.

#### Propiedades de Materiales:
```java
public class Material {
    - String id
    - int durability           // Durabilidad base
    - float miningSpeed        // Velocidad de minado
    - float attackDamage       // Daño de ataque
    - int miningLevel          // Nivel de herramienta (1=madera, 5=netherita)
    - int enchantability       // Facilidad para encantar
    - float attackSpeed        // Velocidad de ataque
    - float knockback          // Retroceso
    - float weight             // Peso (afecta velocidad)
    - Color color              // Color visual del material
    - Map<String, MaterialTrait> traits  // Rasgos especiales
}
```

#### Traits/Rasgos Especiales:
- **Netherite**: Resistencia al fuego, no se quema en lava
- **Oro**: Alta encantabilidad, baja durabilidad
- **Diamante**: Alta durabilidad, buen daño
- **Madera**: Reparable con palos, ligera, bajo peso
- **Hierro**: Balanceada, versátil
- **Custom**: Posibilidad de añadir rasgos personalizados

---

### 1.2 Sistema de Moldes (Mold System)
**Prioridad: ALTA - Determina qué partes se pueden fabricar**

#### 🔧 Moldes Necesarios (Solo 12 moldes en total):

**Moldes Comodín (5):**
1. **Molde de Vara** (Rod Mold) - Para todos los mangos de una mano
2. **Molde de Asta** (Pole Mold) - Para todos los mangos de dos manos
3. **Molde de Ligadura** (Binding Mold) - Para todas las uniones
4. **Molde de Guarda** (Guard Mold) - Para todas las guardas de espadas
5. **Molde de Pomo** (Pommel Mold) - Para todos los contrapesos

**Moldes de Cabezas Únicas (7):**
6. **Molde de Hoja de Cuchillo** (Knife Blade Mold)
7. **Molde de Hoja de Espada** (Sword Blade Mold)
8. **Molde de Hoja de Katana** (Katana Blade Mold)
9. **Molde de Punta de Lanza** (Spearhead Mold)
10. **Molde de Cabeza de Hacha** (Axe Head Mold)
11. **Molde de Cabeza de Pico** (Pickaxe Head Mold)
12. **Molde de Placa Grande** (Large Plate Mold)

**Crafteo de Moldes:**
- **Moldes de Madera/Piedra**: Crafteo vanilla (4 tablas/piedras + item de patrón)
- **Moldes avanzados**: Requieren fundición (arcilla cocida + patrón)

---

### 1.3 Sistema de Fundición (Smeltery)
**Prioridad: ALTA - Mecánica central del mod**

#### Estructura Multibloque:
- **Bloques necesarios**:
  - `Smeltery Controller` (Controlador principal)
  - `Smeltery Bricks` (Ladrillos de fundición)
  - `Smeltery Tank` (Tanque de metal fundido)
  - `Smeltery Drain` (Drenaje/salida)
  - `Casting Table` (Mesa de fundición)
  - `Casting Basin` (Cuenca de fundición)

#### Tamaño de la Estructura:
- Mínimo: 3x3x3 (interior 1x1x1)
- Máximo: 11x11x11 (configurable)
- Capacidad de tanque escalable según tamaño

#### Funcionamiento:
1. **Fundición**: Colocar lingotes/minerales → Calentar → Metal líquido
2. **Aleaciones**: Combinar metales fundidos para nuevos materiales
3. **Moldeado**: Verter metal líquido en moldes para crear partes

#### Combustibles:
- Lava (más eficiente)
- Carbón
- Bloques de carbón
- Lava en cubos

---

### 1.3 Sistema de Componentes de Armas
**Prioridad: ALTA - Define las armas modulares**

#### ⚔️ RECETAS DE ENSAMBLAJE (Sistema Optimizado)

**A. ARMAS DE FILO (Swords & Daggers)**

**1. DAGA** (Dagger)
- **Receta**: Hoja de Cuchillo + Guarda + Vara
- **Lógica**: Vara = mango corto
- *Trade-off*: Alta velocidad → Bajo daño y alcance
- **Partes**: 1 única + 2 reutilizables

**2. ESPADA** (Sword)
- **Receta**: Hoja de Espada + Guarda + Vara + Pomo
- **Lógica**: Arma balanceada con contrapeso
- *Trade-off*: Balanceada → Sin especializaciones extremas
- **Partes**: 1 única + 3 reutilizables

**3. ESPADA LARGA / CLAYMORE** (Longsword)
- **Receta**: Hoja de Espada + Guarda + Asta + Pomo
- **Reutilización**: ¡Misma hoja que espada normal! Solo cambia el mango a Asta
- *Trade-off*: Alto daño y alcance → Muy lenta, dos manos
- **Partes**: 1 única + 3 reutilizables

**4. KATANA**
- **Receta**: Hoja de Katana + Ligadura + Vara
- **Lógica**: Ligadura = Habaki (pieza que sujeta la hoja) + Tsuba
- *Trade-off*: Velocidad media-alta y daño decente → Menor durabilidad
- **Partes**: 1 única + 2 reutilizables

---

**B. ARMAS DE ASTA (Polearms)**

**5. LANZA** (Spear)
- **Receta**: Punta de Lanza + Asta + Pomo
- **Lógica**: Pomo = "Butt" (base metálica) para equilibrar peso
- *Trade-off*: Máximo alcance → Inefectiva en espacios cerrados
- **Partes**: 1 única + 2 reutilizables

**6. ALABARDA / HACHA DE GUERRA** (Halberd)
- **Receta**: Cabeza de Hacha + Asta + Ligadura
- **Reutilización**: ¡Misma cabeza de hacha normal! Cambia Vara por Asta
- *Trade-off*: Alto daño de dos manos → Muy lenta
- **Partes**: 1 única + 2 reutilizables

---

**C. HERRAMIENTAS Y HACHAS**

**7. HACHA DE MANO** (Axe)
- **Receta**: Cabeza de Hacha + Vara + Ligadura
- **Lógica**: Ligadura asegura cabeza pesada al mango corto
- *Trade-off*: Alto daño → Velocidad baja
- **Partes**: 1 única + 2 reutilizables

**8. PICO** (Pickaxe)
- **Receta**: Cabeza de Pico + Vara + Ligadura
- **Reutilización**: Misma Ligadura que Hacha
- *Trade-off*: Especialización en piedra → Ineficiente en otros bloques
- **Partes**: 1 única + 2 reutilizables

**9. PALA** (Shovel)
- **Receta**: Placa Grande + Asta + Ligadura
- **Innovación**: Placa Grande reutilizable para escudos futuros
- *Trade-off*: Eficiente en tierra/arena → Inútil en piedra
- **Partes**: 1 única + 2 reutilizables

**10. AZADA** (Hoe)
- **Receta**: Cabeza de Hacha + Vara + Ligadura (versión modificada)
- **Alternativa**: Placa Grande + Vara (versión simple)
- *Trade-off*: Versátil en agricultura → Daño muy bajo en combate
- **Partes**: 1 única + 2 reutilizables

#### 📊 Sistema de Trade-offs por Componente:

**Partes Comodín - Efectos según Material:**

**VARA (Rod):**
- Material ligero (Madera): +Velocidad de ataque, -Durabilidad
- Material pesado (Metal): +Durabilidad, -Velocidad de ataque
- Material balanceado (Hierro): Stats neutrales

**ASTA (Pole):**
- Siempre: +Alcance, -Velocidad de ataque (penalización fija por ser dos manos)
- Material ligero: Reduce penalización de velocidad
- Material pesado: Aumenta durabilidad pero penaliza más la velocidad

**LIGADURA (Binding):**
- Material flexible (Cuero/Madera): +Durabilidad menor, +Velocidad
- Material rígido (Metal): +Durabilidad mayor, -Velocidad menor
- Efecto fijo: +10% durabilidad base

**GUARDA (Guard):**
- Material ligero: +Durabilidad, bonus defensivo mínimo
- Material pesado: +Durabilidad mayor, +Resistencia al knockback, -Velocidad
- Efecto fijo: Protección al bloquear

**POMO (Pommel):**
- Material ligero: Reduce penalización de armas pesadas
- Material pesado: +Knockback, +Balance, -Velocidad de ataque
- En Lanzas: Actúa como contrapeso (mejora precisión)

**Cabezas Únicas - Determinan el rol del arma:**
- **Hoja de Cuchillo**: Daño bajo, velocidad muy alta
- **Hoja de Espada**: Daño medio, velocidad media
- **Hoja de Katana**: Daño medio-alto, velocidad alta, durabilidad reducida
- **Punta de Lanza**: Daño perforante, alcance máximo
- **Cabeza de Hacha**: Daño alto, velocidad baja
- **Cabeza de Pico**: Velocidad de minado, nivel de herramienta
- **Placa Grande**: Área de efecto (pala), potencial para escudo

---

### 1.5 Sistema de Ensamblaje (Tool Station)
**Prioridad: ALTA**

#### Tool Station (Mesa de Herramientas):
- GUI con slots para cada parte del arma
- Vista previa 3D del arma ensamblada (opcional, complejo)
- Mostrar estadísticas calculadas en tiempo real
- Validar que las partes sean compatibles

#### Tool Forge (Forja de Herramientas):
- Versión mejorada para armas más complejas
- Permite más slots de modificadores
- Necesaria para herramientas de nivel superior

#### 🎯 Validación de Recetas:
El Tool Station debe validar que las combinaciones sean correctas:
```java
// Ejemplos de validaciones:
- Espada = Hoja de Espada + Guarda + Vara + Pomo ✓
- Claymore = Hoja de Espada + Guarda + Asta + Pomo ✓
- Daga = Hoja de Espada + Guarda + Vara (INVÁLIDO) ✗
- Daga = Hoja de Cuchillo + Guarda + Vara ✓
```

---

### 1.6 Sistema de Modificadores
**Prioridad: MEDIA**

#### Tipos de Modificadores:
- **Filo**: +Daño
- **Reforzado**: +Durabilidad
- **Velocidad**: +Velocidad de ataque/minado
- **Fortuna**: Probabilidad de drops extra
- **Toque de seda**: Minar bloques sin romper
- **Afilado**: Daño extra a ciertos mobs
- **Empuje**: Knockback
- **Fuego**: Aspecto ígneo
- **Reparación**: Auto-reparación con materiales

#### Sistema de Slots:
- Cada arma tiene un número limitado de slots de modificadores
- Algunos modificadores consumen múltiples slots
- Materiales pueden añadir slots extra

---

### 1.7 Sistema de Estadísticas y Balance
**Prioridad: ALTA**

#### Cálculo de Estadísticas:
```java
Durabilidad Total = (durabilidadHoja * 0.6) + (durabilidadGuarda * 0.2) + (durabilidadEmpuñadura * 0.2)
Daño Total = (dañoHoja * 0.8) + (dañoGuarda * 0.1) + (dañoEmpuñadura * 0.1) + modificadores
Velocidad = (velocidadBase) + (modificadorEmpuñadura) + modificadores
```

#### Persistencia de Datos:
- Usar NBT para almacenar datos de componentes en el item
- Guardar durabilidad, materiales, modificadores, y estadísticas

---

## 2. ESTRUCTURA DE PAQUETES JAVA

```
com.paulo.moltensmith/
├── MoltenSmith.java                 // Clase principal del mod
├── config/
│   └── ModConfig.java               // Configuraciones
├── materials/
│   ├── Material.java                // Clase base de material
│   ├── MaterialRegistry.java        // Registro de materiales
│   ├── MaterialStats.java           // Estadísticas de materiales
│   └── MaterialTraits.java          // Rasgos especiales
├── items/
│   ├── parts/                       // Partes de armas
│   │   ├── BladePart.java
│   │   ├── GuardPart.java
│   │   ├── HandlePart.java
│   │   └── ToolPart.java           // Clase base
│   ├── tools/                       // Armas modulares
│   │   ├── ModularDagger.java
│   │   ├── ModularSword.java
│   │   ├── ModularLongsword.java
│   │   ├── ModularKatana.java
│   │   ├── ModularSpear.java
│   │   ├── ModularAxe.java
│   │   ├── ModularPickaxe.java
│   │   ├── ModularHoe.java
│   │   └── ModularTool.java        // Clase base
│   └── ModItems.java                // Registro de items
├── blocks/
│   ├── smeltery/
│   │   ├── SmelteryControllerBlock.java
│   │   ├── SmelteryBrickBlock.java
│   │   ├── SmelteryTankBlock.java
│   │   ├── CastingTableBlock.java
│   │   └── CastingBasinBlock.java
│   ├── station/
│   │   ├── ToolStationBlock.java
│   │   └── ToolForgeBlock.java
│   └── ModBlocks.java               // Registro de bloques
├── blockentities/
│   ├── SmelteryControllerBlockEntity.java
│   ├── SmelteryTankBlockEntity.java
│   ├── CastingTableBlockEntity.java
│   ├── ToolStationBlockEntity.java
│   └── ModBlockEntities.java        // Registro
├── gui/
│   ├── screen/
│   │   ├── SmelteryScreen.java
│   │   ├── ToolStationScreen.java
│   │   └── CastingTableScreen.java
│   └── menu/
│       ├── SmelteryMenu.java
│       ├── ToolStationMenu.java
│       └── ModMenuTypes.java        // Registro
├── data/
│   ├── recipes/
│   │   ├── SmelteryRecipe.java
│   │   ├── CastingRecipe.java
│   │   ├── AlloyRecipe.java
│   │   └── ModRecipeTypes.java
│   └── ModRecipeSerializers.java
├── client/
│   ├── renderer/
│   │   └── ToolPartRenderer.java    // Renderizado de partes
│   └── ModClient.java
├── integration/
│   └── bettercombat/
│       └── BetterCombatCompat.java  // Integración con Better Combat
├── network/
│   ├── PacketHandler.java
│   └── packets/                     // Paquetes de red
│       ├── SmelteryDataPacket.java
│       └── ToolDataPacket.java
└── util/
    ├── ToolStats.java               // Cálculos de estadísticas
    ├── TradeOffCalculator.java      // Sistema de trade-offs
    ├── NBTHelper.java               // Helpers para NBT
    └── MultiblockHelper.java        // Validación de multibloques
```

---

## 3. FASES DE DESARROLLO

### Fase 1: Fundamentos (1-2 semanas) ⭐ COMENZANDO AHORA
**Objetivo: Configurar el proyecto y crear el sistema base**

- [ ] Renombrar el mod de "examplemod" a "moltensmith"
- [ ] Configurar gradle.properties con información del mod
- [ ] Refactorizar paquetes de com.example.examplemod a com.paulo.moltensmith
- [ ] Actualizar neoforge.mods.toml y recursos
- [ ] Crear estructura de paquetes completa
- [ ] Implementar clase Material y MaterialRegistry
- [ ] Registrar materiales básicos (hierro, oro, diamante, madera)
- [ ] Crear sistema de estadísticas base con trade-offs
- [ ] Implementar TradeOffCalculator para balance automático

### Fase 2: Sistema de Fundición (2-3 semanas)
**Objetivo: Implementar la fundición multibloque funcional**

- [ ] Crear bloques de fundición
- [ ] Implementar BlockEntity del controlador
- [ ] Sistema de validación de estructura multibloque
- [ ] Sistema de tanque de fluidos (metal fundido)
- [ ] GUI de fundición con visualización de contenido
- [ ] Recetas de fundición básicas
- [ ] Sistema de combustible

### Fase 3: Moldes y Fundición (1-2 semanas)
**Objetivo: Crear partes de armas mediante moldes**

- [ ] Crear items de moldes
- [ ] Implementar Casting Table y Basin
- [ ] Recetas de fundición para crear partes
- [ ] Crear items de partes de herramientas
- [ ] Sistema de NBT para almacenar material en partes

### Fase 4: Ensamblaje de Herramientas (2-3 semanas)
**Objetivo: Crear el sistema de ensamblaje de armas**

- [ ] Crear Tool Station block
- [ ] Implementar GUI de ensamblaje
- [ ] Sistema de validación de partes compatibles
- [ ] Cálculo de estadísticas combinadas
- [ ] Crear items de herramientas modulares
- [ ] Implementar funcionalidad de herramientas (minado, ataque)
- [ ] Sistema de durabilidad

### Fase 5: Modificadores (2 semanas)
**Objetivo: Sistema de mejora de herramientas**

- [ ] Implementar sistema de slots de modificadores
- [ ] Crear modificadores básicos
- [ ] GUI para aplicar modificadores
- [ ] Efectos de modificadores en gameplay
- [ ] Items para modificadores

### Fase 6: Materiales Avanzados y Aleaciones (1-2 semanas)
**Objetivo: Ampliar opciones de materiales**

- [ ] Implementar sistema de aleaciones
- [ ] Crear recetas de aleaciones
- [ ] Añadir materiales personalizados
- [ ] Implementar traits especiales de materiales
- [ ] Balancear estadísticas

### Fase 7: Pulido y Balance (1-2 semanas)
**Objetivo: Mejorar experiencia de usuario**

- [ ] Crear texturas personalizadas
- [ ] Añadir traducciones (en_us, es_es)
- [ ] Balancear todas las estadísticas
- [ ] Crear recetas de crafteo para bloques
- [ ] Documentación en libro (Patchouli - opcional)
- [ ] Testing exhaustivo

### Fase 8: Extras Opcionales (Futuro)
**Objetivo: Características adicionales**

- [ ] Armaduras modulares
- [ ] Arcos y ballestas modulares
- [ ] Escudos modulares
- [ ] Herramientas especiales (excavadora, martillo)
- [ ] Compatibilidad con otros mods
- [ ] Renderizado 3D de herramientas en GUI
- [ ] Efectos de partículas especiales

---

## 4. RECURSOS NECESARIOS

### Assets (Texturas):
- **Items**:
  - Partes de herramientas (hoja, guarda, empuñadura, etc.) - 1 por material
  - Herramientas completas (espada, hacha, pico, pala)
  - Moldes
  - Modificadores
- **Bloques**:
  - Smeltery blocks (controlador, ladrillos, tanque)
  - Tool Station
  - Casting Table/Basin
- **GUI**:
  - Fondo de interfaz de fundición
  - Fondo de interfaz de Tool Station
  - Iconos y elementos UI

### Data:
- **Recipes**: Recetas de crafteo para bloques y moldes
- **Loot Tables**: Drops de bloques
- **Tags**: Tags de items y bloques
- **Lang**: Archivos de traducción

### Configuración:
```properties
# En gradle.properties
mod_id=moltensmith
mod_name=MoltenSmith
mod_version=0.1.0
mod_authors=Paulo652
mod_description=A realistic weapon forging mod with modular crafting. Compatible with Better Combat. Create custom weapons through smelting and assembly - perfect for roleplay servers!
mod_license=MIT
mod_group_id=com.paulo.moltensmith
```

---

## 5. TECNOLOGÍAS Y DEPENDENCIAS

### Dependencias Necesarias:
- **NeoForge API**: Incluido en el template
- **Java 21**: Runtime de Minecraft 1.21.1
- **Gradle**: Sistema de build

### Dependencias Recomendadas:
- **Better Combat** (soft dependency): Para mecánicas de combate mejoradas
- **JEI (Just Enough Items)**: Para mostrar recetas en GUI
- **Patchouli**: Para libro de herrería in-game (guía para jugadores)

### Dependencias Opcionales:
- **Curios API**: Si quieres añadir accesorios modulares
- **Jade/WTHIT**: Para mostrar información de bloques de fundición

---

## 6. CONSIDERACIONES TÉCNICAS

### NBT Data Structure para Herramientas:
```json
{
  "modularweapons": {
    "parts": {
      "blade": {
        "material": "iron",
        "durability": 250
      },
      "guard": {
        "material": "gold",
        "durability": 32
      },
      "handle": {
        "material": "oak",
        "durability": 59
      }
    },
    "modifiers": [
      {
        "type": "sharpness",
        "level": 2
      }
    ],
    "stats": {
      "damage": 7.0,
      "speed": 1.6,
      "durability": 341,
      "miningLevel": 2
    }
  }
}
```

### Sincronización Cliente-Servidor:
- Usar paquetes de red para sincronizar datos de multibloque
- Actualizar NBT de items en servidor y sincronizar con cliente
- Manejar GUI data packets para interfaces complejas

### Performance:
- Cachear cálculos de estadísticas
- Validar multibloque solo cuando sea necesario (no cada tick)
- Usar capabilities para datos de fluidos si es necesario

---

## 7. PRÓXIMOS PASOS INMEDIATOS (FASE 1 - EN PROGRESO)

### ✅ Pasos a Ejecutar Ahora:
1. **Actualizar gradle.properties** con moltensmith
2. **Refactorizar paquetes Java** de com.example.examplemod → com.paulo.moltensmith
3. **Actualizar neoforge.mods.toml** con información correcta
4. **Actualizar carpetas de recursos** (assets/examplemod → assets/moltensmith)
5. **Crear estructura de paquetes** completa según el plan
6. **Implementar sistema de materiales** base
7. **Testear que el mod cargue correctamente**

## 8. CARACTERÍSTICAS ESPECIALES PARA ROLEPLAY

### Sistema de Firma de Herrero:
- Cada arma puede tener NBT con el nombre del herrero que la creó
- Útil en servidores roleplay para tracking y prestigio
- Comando para herreros: `/moltensmith sign <player>` (marca el arma con tu nombre)

### Estaciones de Trabajo Públicas:
- Los herreros pueden crear estaciones de trabajo "públicas" que otros jugadores pueden usar
- Opción de cobrar fees por uso (integración con economía - futuro)
- Sistema de permisos para controlar quién puede usar qué estación

### Balance de Progresión Temprana:
- Remover o modificar recetas vanilla de herramientas de hierro+
- Forzar a los jugadores a usar el sistema de fundición
- Herramientas de madera/piedra siguen disponibles normalmente
- Hierro+ requiere fundición y ensamblaje adecuado

---

## 8. RECURSOS DE APRENDIZAJE

### Documentación:
- NeoForge Documentation: https://docs.neoforged.net/
- Minecraft Forge Wiki: https://mcforge.readthedocs.io/
- Parchment Mappings: Para nombres de métodos legibles

### Ejemplos de Código:
- Tinkers' Construct (referencia conceptual, código para 1.18/1.19)
- Silent Gear (otro mod de herramientas modulares)
- Repositorios de ejemplo de NeoForge

### Comunidad:
- NeoForge Discord
- Minecraft Mod Development subreddit
- Stack Overflow para problemas específicos

---

## NOTAS FINALES

Este plan está diseñado para ser implementado de forma incremental. No intentes hacer todo a la vez. Comienza con el sistema de materiales, luego la fundición básica, y construye desde ahí.

**Recuerda:**
- Testea frecuentemente
- Haz commits regulares en Git
- Documenta tu código
- Pide ayuda cuando te atasques
- Diviértete creando tu mod!

**Tiempo Estimado Total**: 10-15 semanas para versión básica funcional (trabajando parte del tiempo)

¡Buena suerte con tu mod de armas modulares!
